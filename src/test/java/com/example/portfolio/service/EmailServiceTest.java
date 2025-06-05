package com.example.portfolio.service;

import com.example.portfolio.entity.Mail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    public MailService mailService;

//    @Test
    public void sendMail() {
        mailService.sendMail(new Mail("Abhi", "symbolise123@gmail.com", "subject", "description"));
    }
}
