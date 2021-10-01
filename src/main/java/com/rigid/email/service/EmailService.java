package com.rigid.email.service;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String context);
}
