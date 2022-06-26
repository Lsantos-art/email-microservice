package com.emailmicroservice.emailmicroservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailmicroservice.emailmicroservice.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

    
}
