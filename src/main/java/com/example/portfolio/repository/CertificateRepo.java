package com.example.portfolio.repository;

import com.example.portfolio.entity.Certificate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CertificateRepo extends MongoRepository<Certificate, ObjectId> {
}
