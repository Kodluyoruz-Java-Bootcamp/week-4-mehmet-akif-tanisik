package emlakcepte.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import emlakcepte.client.PaymentServiceClient;
import emlakcepte.client.model.Payment;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.repository.RealtyRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import emlakcepte.configuration.RabbitMQConfiguration;
import emlakcepte.controller.UserController;
import emlakcepte.dto.converter.UserConverter;
import emlakcepte.model.User;
import emlakcepte.repository.UserRepository;
import emlakcepte.dto.model.request.UserRequest;
import emlakcepte.dto.model.request.UserUpdateRequest;
import emlakcepte.dto.model.response.UserResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

	private final RabbitTemplate rabbitTemplate;
	private final RabbitMQConfiguration rabbitMQConfiguration;
	private final UserRepository userRepository;

	private final RealtyRepository realtyRepository;

	private final UserConverter userConverter;
	private final Logger logger = Logger.getLogger(UserController.class.getName());
	private PaymentServiceClient paymentServiceClient;

	public UserService(RabbitTemplate rabbitTemplate, RabbitMQConfiguration rabbitMQConfiguration, UserRepository userRepository, RealtyRepository realtyRepository, UserConverter userConverter, PaymentServiceClient paymentServiceClient)
	{
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitMQConfiguration = rabbitMQConfiguration;
		this.userRepository = userRepository;
		this.realtyRepository = realtyRepository;
		this.userConverter = userConverter;
		this.paymentServiceClient=paymentServiceClient;
	}
	public Payment processPayment(User user, String cardNo) throws Exception {
		return paymentServiceClient.processPayment(user.getId(),cardNo);
	}

	public void extendPackageExpiration(Payment payment)
	{
		var user = userRepository.findById(payment.getUserId());
		if(user.isPresent()) {
			if (user.get().getPackageExpireDate() == null || user.get().getPackageExpireDate().isBefore(LocalDateTime.now())) {
				user.get().setPackageExpireDate(LocalDateTime.now().plusMonths(1));
			}
			else {
				user.get().setPackageExpireDate(user.get().getPackageExpireDate().plusMonths(1));
			}
			userRepository.save(user.get());
		}

	}

	public UserResponse createUser(UserRequest userRequest) {
		User savedUser = userRepository.save(userConverter.convert(userRequest));
		logger.log(Level.INFO, "[createUser] - user created: {0}", savedUser.getId());
		rabbitTemplate.convertAndSend(rabbitMQConfiguration.getQueueName(), savedUser);

		logger.log(Level.WARNING, "[createUser] - userRequest: {0}, sent to : {1}",
				new Object[] { userRequest.getEmail(), rabbitMQConfiguration.getQueueName() });
		return userConverter.convert(savedUser);
	}


	public List<UserResponse> getAll() {
		return userConverter.convert(userRepository.findAll());
	}

	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordü update et.
	}

	public User getByEmailAntiPattern(String email) {

		//// @formatter:off
		return userRepository.findAll()
				.stream()
				.filter(user -> user.getEmail().equals(email))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
		// @formatter:on

	}

	public UserResponse getByEmail(String email) {
		return userConverter.convert(userRepository.findByEmail(email));
	}

	public Optional<User> getById(Integer userId) {
		return userRepository.findById(userId);
	}

	public UserResponse update(UserUpdateRequest userUpdateRequest) {

		return null;
	}

	@PostConstruct
	public void checkPackageExpiration ()
	{
		var timer = new Timer();
		long period = 24 * 60 * 60 * 1000;


		timer.scheduleAtFixedRate(new TimerTask() {
			public void run()
			{
				System.out.println("Aktif kullanıcıların üyelikleri kontrol ediliyor " + LocalDateTime.now().toString());

				var list = userRepository.findAll().stream()
						.filter(u -> u.getPackageExpireDate() != null)
						.filter(u -> LocalDateTime.now().isAfter(u.getPackageExpireDate()))
						.toList()
						.stream()
						.map(User::getRealtyList)
						.flatMap(Collection::stream)
						.toList();

				list.forEach(r -> r.setStatus(RealtyType.PASSIVE));

				realtyRepository.saveAll(list);
			}
		}, 1000, period);

	}

}
