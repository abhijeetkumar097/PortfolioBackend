package com.example.portfolio.controller;

import com.example.portfolio.entity.FrontPage;
import com.example.portfolio.service.FrontPageService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/frontpage")
@Slf4j
public class FrontPageController {
    @Autowired
    private FrontPageService frontPageService;

    @PostMapping
    public ResponseEntity<?> addElement(@RequestBody FrontPage frontPage) {
        if(frontPageService.addFrontPage(frontPage)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPage(@PathVariable ObjectId id, @RequestBody FrontPage frontPage) {
        try {
            frontPage.setId(id);
            if(frontPageService.addFrontPage(frontPage)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
