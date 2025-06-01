package com.example.portfolio.repository;

import com.example.portfolio.entity.Skill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepo extends MongoRepository<Skill, ObjectId> {
}
