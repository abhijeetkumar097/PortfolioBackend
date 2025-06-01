package com.example.portfolio.controller;

import com.example.portfolio.DTO.CertificateDto;
import com.example.portfolio.entity.Certificate;
import com.example.portfolio.service.CertificateService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public List<CertificateDto> getCertificates() {
        List<Certificate> certificates = certificateService.getAll();

        return certificates.stream().map(certificate -> new CertificateDto(
                certificate.getId().toHexString(),
                certificate.getName(),
                certificate.getProvider(),
                certificate.getDuration(),
                certificate.getUrl()
        )).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> addCertificate(@RequestBody Certificate certificate) {
        try {
            certificateService.addElement(certificate);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCertificate(@PathVariable ObjectId id, @RequestBody Certificate certificate) {
        try {
            certificate.setId(id);
            certificateService.addElement(certificate);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificate(@PathVariable ObjectId id) {
        try {
            certificateService.deleteCertificate(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
