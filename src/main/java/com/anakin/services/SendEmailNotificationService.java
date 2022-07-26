package com.anakin.services;

import org.springframework.stereotype.Service;

@Service
public interface SendEmailNotificationService {
    void sendMail(String to, String subject, String body);
}
