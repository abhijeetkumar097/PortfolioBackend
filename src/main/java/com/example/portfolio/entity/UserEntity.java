package com.example.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "credentials")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    ObjectId objectId;
    String userName;
    String password;
}
