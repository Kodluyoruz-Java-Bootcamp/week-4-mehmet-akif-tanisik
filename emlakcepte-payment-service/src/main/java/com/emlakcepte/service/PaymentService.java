package com.emlakcepte.service;


import com.emlakcepte.configuration.RabbitMQConfiguration;
import com.emlakcepte.model.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConfiguration rabbitMQConfiguration;


    public PaymentService(RabbitTemplate rabbitTemplate, RabbitMQConfiguration rabbitMQConfiguration) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQConfiguration = rabbitMQConfiguration;

    }

    public void processPayment(Payment payment, String cardNo) {
        rabbitTemplate.convertAndSend(rabbitMQConfiguration.getQueueName(), payment);
    }

}
