package com.example.portfolio.controller;

import com.example.portfolio.entity.Mail;
import com.example.portfolio.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService service;

    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody Mail mail) {
        if(service.sendMail(mail)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
