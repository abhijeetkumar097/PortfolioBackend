package com.example.portfolio.repository;

import com.example.portfolio.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntity, ObjectId> {
}
