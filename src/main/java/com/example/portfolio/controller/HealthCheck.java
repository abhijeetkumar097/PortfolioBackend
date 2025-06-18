package com.example.portfolio.controller;

import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthCheck {
    @GetMapping("/check")
    public String healthCheck() {
        return "Hello World";
    }

}
