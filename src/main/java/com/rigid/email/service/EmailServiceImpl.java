package com.rigid.email.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private void sendSimpleMessage(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("from@from.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            emailSender.send(message);
        } catch (Throwable th) {
            log.error("Unexpected exception in sending simple massage", th);
        }
    }

    public void sendTestMail(String email, String subject, String content) {
        log.info("Sending test mail to: " + email + ", subject: " + subject + ", content: " + content);
        this.sendSimpleMessage(email, subject, content);
    }
}