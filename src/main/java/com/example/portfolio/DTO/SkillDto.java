package com.example.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillDto {
    private String id;
    private String type;
    private String name;
    private int proficiency;
}
