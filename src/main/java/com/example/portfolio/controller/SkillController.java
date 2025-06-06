package com.example.portfolio.controller;

import com.example.portfolio.entity.Skill;
import com.example.portfolio.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService service;

    @GetMapping
    public String Check() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<?> addSkill(@RequestBody Skill skill) {
        if(service.addSkill(skill)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editSkill(@RequestBody Skill skill, @PathVariable ObjectId id) {
        try {
            skill.setId(id);
            if(service.addSkill(skill)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable ObjectId id) {
        if(service.deleteSkill(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
