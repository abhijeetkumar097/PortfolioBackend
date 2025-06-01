package com.example.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "frontpage")
public class FrontPage {
    @Id
    private ObjectId id;
    private String name;
    private String title;
    private String smallAbout;
    private String about;
    private String imgUrl;
    private String cvUrl;
    private HashMap<String, String> connect;
}
