package com.emailmicroservice.emailmicroservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.emailmicroservice.emailmicroservice.enums.StatusEmailEnum;
import com.emailmicroservice.emailmicroservice.models.EmailModel;
import com.emailmicroservice.emailmicroservice.repositories.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());

            emailSender.send(message);
            emailModel.setStatus(StatusEmailEnum.SENT);
        } catch (MailException e) {
            emailModel.setStatus(StatusEmailEnum.ERROR);
        }

        return emailRepository.save(emailModel);
    }
}
