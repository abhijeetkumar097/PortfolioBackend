package com.example.portfolio.service;

import com.example.portfolio.entity.Skill;
import com.example.portfolio.repository.SkillRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SkillService {
    @Autowired
    private SkillRepo skillRepo;

    public List<Skill> getAll() {
        return skillRepo.findAll();
    }

    public boolean addSkill(Skill skill) {
        try {
            skillRepo.save(skill);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean deleteSkill(ObjectId objectId) {
        try {
            skillRepo.deleteById(objectId);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
