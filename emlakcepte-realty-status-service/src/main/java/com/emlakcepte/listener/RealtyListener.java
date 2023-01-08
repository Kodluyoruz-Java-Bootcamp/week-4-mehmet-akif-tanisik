package com.emlakcepte.listener;


import emlakcepte.dto.model.response.RealtyResponse;
import emlakcepte.model.Realty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RealtyListener {

    @RabbitListener(queues = "${emlakcepte.rabbitmq.queue}")
    public void realtyListener(Realty realty) {
        String url = "http://localhost:8090/realties/change/"+realty.getId();
        RestTemplate template = new RestTemplate();
        template.getForObject(url, RealtyResponse.class);
        System.out.printf("%s ,%s , %s", realty.getTitle(), realty.getStatus(), realty.getProvince());
    }
}

