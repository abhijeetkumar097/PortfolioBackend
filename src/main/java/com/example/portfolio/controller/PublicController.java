package com.example.portfolio.controller;

import com.example.portfolio.DTO.*;
import com.example.portfolio.service.*;

import lombok.extern.slf4j.Slf4j;

import com.example.portfolio.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private CertificateService certificateService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private FrontPageService frontPageService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SkillService skillService;

    @GetMapping("/certificate")
    public List<CertificateDto> getCertificates() {
        try {
            List<Certificate> certificates = certificateService.getAll();

            return certificates.stream().map(certificate -> new CertificateDto(
                    certificate.getId().toHexString(),
                    certificate.getName(),
                    certificate.getProvider(),
                    certificate.getDuration(),
                    certificate.getUrl()
            )).collect(Collectors.toList());
        }catch(Exception e) {
            log.error("Error in public controller ", e.getMessage());
            return List.of();
        }
    }

    @GetMapping("/education")
    public List<EducationDto> getEducation() {
        try {
            List<Education> educations = educationService.getEducation();
            return educations.stream().map(education -> new EducationDto(
                    education.getId().toHexString(),
                    education.getInstituteName(),
                    education.getDegree(),
                    education.getAddress(),
                    education.getPincode(),
                    education.getCgpa(),
                    education.getPercentage(),
                    education.getDescription(),
                    education.getDuration()
            )).collect(Collectors.toList());
        }catch(Exception e) {
            log.error("Error in public controller : ", e);
            return List.of();
        }
    }

    @GetMapping("/frontPage")
    public List<FrontPageDto> getAll() {
        try {
            List<FrontPage> frontPageList = frontPageService.getAll();
            return frontPageList.stream().map(frontPage -> new FrontPageDto(
                    frontPage.getId().toHexString(),
                    frontPage.getName(),
                    frontPage.getTitle(),
                    frontPage.getSmallAbout(),
                    frontPage.getAbout(),
                    frontPage.getImgUrl(),
                    frontPage.getCvUrl(),
                    frontPage.getConnect()
            )).collect(Collectors.toList());
        }catch(Exception e) {
            log.error("Error in public controller : ", e);
            return List.of();
        }
    }

    @GetMapping("/project")
    public List<ProjectDto> getAllProjects() {
        try {
            List<Project> projects = projectService.getAll();

            return projects.stream().map(project -> new ProjectDto(
                    project.getId().toHexString(), // convert ObjectId to string
                    project.getName(),
                    project.getDescription(),
                    project.getImgUrl(),
                    project.getGithubUrl1(),
                    project.getGithubUrl2(),
                    project.getLiveUrl(),
                    project.getTechStack()
            )).collect(Collectors.toList());
        }catch(Exception e) {
            log.error("Error in public controller : ", e);
            return List.of();
        }
    }

    @GetMapping("/skill")
    public List<SkillDto> getSkills() {
        try {
            List<Skill> skills = skillService.getAll();
            return skills.stream().map(skill -> new SkillDto(
                    skill.getId().toHexString(),
                    skill.getType(),
                    skill.getName(),
                    skill.getProficiency()
            )).collect(Collectors.toList());
        }catch(Exception e) {
            log.error("Error in skill controller : ", e.getMessage());
            return List.of();
        }
        
    }
}
