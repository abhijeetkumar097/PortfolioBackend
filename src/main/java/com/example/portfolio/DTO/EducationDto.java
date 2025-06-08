package com.example.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationDto {
    private String id;
    private String instituteName;
    private String degree;
    private String address;
    private String pincode;
    private String cgpa;
    private String percentage;
    private String description;
    private String duration;
}
