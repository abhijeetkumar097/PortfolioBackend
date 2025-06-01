package com.example.portfolio.service;

import com.example.portfolio.entity.FrontPage;
import com.example.portfolio.repository.FrontPageRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FrontPageService {
    @Autowired
    private FrontPageRepo frontPageRepo;

    public List<FrontPage> getAll() {
        return frontPageRepo.findAll();
    }

    public boolean addFrontPage(FrontPage frontPage) {
        try {
            frontPageRepo.save(frontPage);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public boolean deleteFrontPage(ObjectId objectId) {
        try {
            frontPageRepo.deleteById(objectId);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
