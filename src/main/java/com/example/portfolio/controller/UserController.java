package com.example.portfolio.controller;

import com.example.portfolio.DTO.UserDto;
import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    private ResponseEntity<?> getUser() {
        try {
            UserEntity user = userService.user();

            return new ResponseEntity<>(new UserDto(user.getObjectId().toHexString(), user.getUserName(), user.getPassword()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> setUserNamePassword(@RequestBody UserEntity user, @PathVariable ObjectId id) {
        user.setObjectId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userService.update(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
