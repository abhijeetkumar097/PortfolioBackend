package com.example.portfolio.service;

import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity user() {
        return userRepo.findAll().getFirst();
    }

    public String getUserName() {
        return userRepo.findAll().getFirst().getUserName();
    }

    public String getPassword() {
        return userRepo.findAll().getFirst().getPassword();
    }

    public boolean update(UserEntity userEntity) {
        try {
            userRepo.save(userEntity);
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), " inside UserService update");
            return false;
        }
    }
}
