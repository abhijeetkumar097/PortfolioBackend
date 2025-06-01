package com.example.portfolio.repository;

import com.example.portfolio.entity.FrontPage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FrontPageRepo extends MongoRepository<FrontPage, ObjectId> {
}
