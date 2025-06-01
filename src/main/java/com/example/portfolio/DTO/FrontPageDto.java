package com.example.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FrontPageDto {
    private String id;
    private String name;
    private String title;
    private String smallAbout;
    private String about;
    private String imgUrl;
    private String cvUrl;
    private HashMap<String, String> connect;
}
