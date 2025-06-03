package com.example.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto {
    private String id;
    private String name;
    private String description;
    private String imgUrl;
    private String githubUrl1;
    private String githubUrl2;
    private String liveUrl;
    private List<String> techStack = new ArrayList<>();
}
