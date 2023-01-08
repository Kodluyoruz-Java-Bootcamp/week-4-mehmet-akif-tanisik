package com.emlakcepteloggerservice.listener;

import com.emlakcepteloggerservice.model.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
public class LoggerFileListener {

    @RabbitListener(queues = "${emlakcepte.rabbitmq.queue}")
    public void realtyListener(Log log) throws IOException {
        Logger log2 = Logger.getLogger(Log.class.getName());

        try {
            FileHandler fh = new FileHandler("log_history.log", true);

            log2.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);


            log2.info(log.toString());
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

    }

}
