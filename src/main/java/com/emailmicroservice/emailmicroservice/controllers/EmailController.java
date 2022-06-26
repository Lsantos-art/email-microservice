package com.emailmicroservice.emailmicroservice.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailmicroservice.emailmicroservice.dtos.EmailDto;
import com.emailmicroservice.emailmicroservice.models.EmailModel;
import com.emailmicroservice.emailmicroservice.services.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    
    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailModel> send(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
