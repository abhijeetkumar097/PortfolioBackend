package com.example.portfolio.service;

import com.example.portfolio.entity.Project;
import com.example.portfolio.repository.ProjectRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    public void addElement(Project project) {
        projectRepo.save(project);
    }

    public void deleteProject(ObjectId id) {
        projectRepo.deleteById(id);
    }
}
