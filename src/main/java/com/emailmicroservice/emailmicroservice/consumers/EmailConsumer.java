package com.emailmicroservice.emailmicroservice.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.emailmicroservice.emailmicroservice.dtos.EmailDto;
import com.emailmicroservice.emailmicroservice.models.EmailModel;
import com.emailmicroservice.emailmicroservice.services.EmailService;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {

        EmailModel emailModel = new EmailModel();

        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        System.out.println("Email status: " + emailModel.getStatus().toString());

    }

}
