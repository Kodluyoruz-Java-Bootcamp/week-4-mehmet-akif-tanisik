package com.emlakcepteloggerservice.listener;

import com.emlakcepteloggerservice.model.Log;
import com.emlakcepteloggerservice.repository.LogRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggerListener {

    @Autowired
    private LogRepository logRepository;

    @RabbitListener(queues = "emlakcepte-logger-service.queue")
    public void paymentListener(Log log) {
        logRepository.save(log);
        System.out.println(log);
    }

}
