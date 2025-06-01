package com.example.portfolio.service;

import com.example.portfolio.entity.Certificate;
import com.example.portfolio.repository.CertificateRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CertificateService {
    @Autowired
    private CertificateRepo certificateRepo;

    public List<Certificate> getAll() {
        return certificateRepo.findAll();
    }

    public boolean addElement(Certificate certificate) {
        try {
            certificateRepo.save(certificate);
            return true;
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public void deleteCertificate(ObjectId objectId) {
        try {
            certificateRepo.deleteById(objectId);
        }catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
