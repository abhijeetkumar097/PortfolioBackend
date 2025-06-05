package com.example.portfolio.service;

import com.example.portfolio.entity.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${MYMAIL}")
    private String myMail;

    public boolean sendMail(Mail data) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(myMail);
            mail.setSubject(data.getSubject());
            String desc = data.getDescription() + " from, Name: " + data.getName() + ". Email: " + data.getEmail();
            mail.setText(desc);
            javaMailSender.send(mail);
            return true;
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
