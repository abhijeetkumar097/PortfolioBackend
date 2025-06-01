package com.example.portfolio.controller;

import com.example.portfolio.DTO.EducationDto;
import com.example.portfolio.entity.Education;
import com.example.portfolio.service.EducationService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<EducationDto> getEducation() {
        List<Education> educations = educationService.getEducation();
        return educations.stream().map(education -> new EducationDto(
                education.getId().toHexString(),
                education.getInstituteName(),
                education.getAddress(),
                education.getPincode(),
                education.getCgpa(),
                education.getPercentage(),
                education.getDescription(),
                education.getDuration()
        )).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> addEducation(@RequestBody Education education) {
        if(educationService.setEducation(education)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editEducation(@PathVariable ObjectId id, @RequestBody Education education) {
        try {
            education.setId(id);
            if(educationService.setEducation(education)) {
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
    public ResponseEntity<?> deleteEducation(@PathVariable ObjectId id) {
        if(educationService.deleteEducation(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
