package emlakcepte.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.emlakcepteloggerservice.model.Log;
import emlakcepte.client.model.Payment;
import emlakcepte.configuration.RabbitMQConfiguration;
import emlakcepte.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.dto.model.request.UserRequest;
import emlakcepte.dto.model.request.UserUpdateRequest;
import emlakcepte.dto.model.response.UserResponse;
import emlakcepte.service.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final RabbitTemplate rabbitTemplate;
	private final RabbitMQConfiguration rabbitMQConfiguration;
	private final UserService userService;
	private final Logger logger = Logger.getLogger(UserController.class.getName());
	public UserController(RabbitTemplate rabbitTemplate, RabbitMQConfiguration rabbitMQConfiguration, UserService userService)
	{
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitMQConfiguration = rabbitMQConfiguration;
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAll()
	{
		return ResponseEntity.ok(userService.getAll());
	}

	@PostMapping
	public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.createUser(userRequest);

		String str = "User created: " + userRequest.getName() + " " + userRequest.getEmail();
		rabbitTemplate.convertAndSend(rabbitMQConfiguration.getLoggerQueue(), new Log(str, LocalDateTime.now()));
		logger.log(Level.INFO, "user created: {0}", userResponse);
		return ResponseEntity.ok(userResponse);
	}
	@GetMapping(value = "/{email}")
	public ResponseEntity<UserResponse> getByEmail(@PathVariable String email)
	{
		return ResponseEntity.ok(userService.getByEmail(email));
	}

	@PutMapping
	public ResponseEntity<UserResponse> update(@RequestBody UserUpdateRequest userUpdateRequest)
	{
		UserResponse user = userService.update(userUpdateRequest);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/process/{cardNo}")
	//public ResponseEntity<UserResponse> processPayment(@RequestBody User user, @RequestBody String cardNo)
	public ResponseEntity<Payment> processPayment(@RequestBody User user, @PathVariable String cardNo) throws Exception {

		if(Objects.isNull(user.getPackageExpireDate()))
		{
			user.setPackageExpireDate(LocalDateTime.now());
		}
		return new ResponseEntity<>(userService.processPayment(user,cardNo),HttpStatus.OK);
	}

	// GET /users/{id} -> /users/1

}
