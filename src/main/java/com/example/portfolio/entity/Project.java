package com.example.portfolio.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Getter
    @Setter
    private ObjectId id;
    @NonNull
    private String name;
    private String description;
    private String imgUrl;
    private String githubUrl1;
    private String githubUrl2;
    private String liveUrl;
    private List<String> techStack = new ArrayList<>();
}
