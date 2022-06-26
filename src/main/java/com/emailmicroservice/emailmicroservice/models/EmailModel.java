package com.emailmicroservice.emailmicroservice.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emailmicroservice.emailmicroservice.enums.StatusEmailEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "SENDER_REF")
    private String ownerRef;

    @Column(name = "EMAIL_FROM")
    private String emailFrom;

    @Column(name = "EMAIL_TO")
    private String emailTo;

    @Column(name = "EMAIL_SUBJECT")
    private String subject;

    @Column( name = "TEXT_EMAIL", columnDefinition = "TEXT")
    private String text;

    @Column(name = "EMAIL_DATE")
    private LocalDateTime sendDateEmail;

    @Column(name = "EMAIL_STATUS")
    private StatusEmailEnum status;

}
