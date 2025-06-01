package com.example.portfolio.repository;

import com.example.portfolio.entity.Education;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationRepo extends MongoRepository<Education, ObjectId> {
}
