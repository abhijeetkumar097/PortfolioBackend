package com.example.portfolio.controller;

import com.example.portfolio.entity.Project;
import com.example.portfolio.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Project project) {
        try {
            projectService.addElement(project);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Project project, @PathVariable ObjectId id) {
        try {
            project.setId(id);
            projectService.addElement(project);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable ObjectId id) {
        try {
            projectService.deleteProject(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
