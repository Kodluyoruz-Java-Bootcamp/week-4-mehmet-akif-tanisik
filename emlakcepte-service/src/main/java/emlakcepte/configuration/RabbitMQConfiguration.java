package emlakcepte.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RabbitMQConfiguration {

	private String queueName = "emlakcepte.notification";
	private String paymentQueueName="emlakcepte.payment";

	@Value("${emlakcepte-logger-service.rabbitmq.queue}")
	private String loggerQueue;

	@Value("${emlakcepte-logger-file-service.rabbitmq.queue}")
	private String loggerFileQueue;

	@Value("${emlakcepte.rabbitmq.realtyQueue}")
	private String realtyQueueName;

	private String exchange = "emlakcepte.notification-exchange";


	@Bean
	public Queue loggerQueue(){
		return new Queue(loggerQueue, false);
	}

	@Bean
	public Queue loggerFileQueue(){
		return new Queue(loggerFileQueue, false);
	}

	@Bean
	public Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	public Queue paymentQueue() {
		return new Queue(paymentQueueName, false);
	}

	@Bean
	public Queue realtyQueue() {
		return new Queue(realtyQueueName, false);
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("");
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
				.modules(new JavaTimeModule())
				.dateFormat(new StdDateFormat())
				.build();
		Jackson2JsonMessageConverter jackson2JsonMessageConverter
				= new Jackson2JsonMessageConverter(objectMapper);
		return jackson2JsonMessageConverter;
		//return new Jackson2JsonMessageConverter();
	}

	public String getQueueName() {
		return queueName;
	}

	public String getpaymentQueueName() {
		return paymentQueueName;
	}
	public String getrealtyQueueName() {
		return realtyQueueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}


	public String getLoggerQueue() {
		return loggerQueue;
	}

	public void setLoggerQueue(String loggerQueue) {
		this.loggerQueue = loggerQueue;
	}

}
