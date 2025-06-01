package com.example.portfolio.service;

import com.example.portfolio.entity.Education;
import com.example.portfolio.repository.EducationRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EducationService {
    @Autowired
    private EducationRepo educationRepo;

    public List<Education> getEducation() {
        return educationRepo.findAll();
    }

    public boolean setEducation(Education education) {
        try {
            educationRepo.save(education);
            return true;
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public boolean deleteEducation(ObjectId objectId) {
        try {
            educationRepo.deleteById(objectId);
            return true;
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }



}
