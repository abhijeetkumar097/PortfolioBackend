package com.example.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "education")
public class Education {
    @Id
    private ObjectId id;
    private String instituteName;
    private String degree;
    private String address;
    private String pincode;
    private String cgpa;
    private String percentage;
    private String description;
    private String duration;
}
