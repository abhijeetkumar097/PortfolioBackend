package com.example.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "certificate")
public class Certificate {
    private ObjectId id;
    private String name;
    private String provider;
    private String duration;
    private String url;
}
