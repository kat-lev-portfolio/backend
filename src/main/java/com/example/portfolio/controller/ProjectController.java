package com.example.portfolio.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.model.Project;
import com.example.portfolio.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.portfolio.dto.ProjectDTO;

@RestController
@RequestMapping("/api/projects")
// @CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    // @PostMapping
    // public Project createProject(@RequestBody Project project) {
    //     return projectService.createProject(project);
    // }

@PostMapping(consumes = "multipart/form-data")
public Project createProject(
    @RequestPart("project") String projectJson,
    @RequestPart("imageFile") MultipartFile imageSource
) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        ProjectDTO dto = mapper.readValue(projectJson, ProjectDTO.class);
        return projectService.createProjectWithImage(dto, imageSource);
    } catch (IOException e) {
        throw new RuntimeException("Failed to parse project data", e);
    }
}

    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project project) {
    return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
    projectService.deleteProject(id);
    return ResponseEntity.ok("Project deleted successfully.");
    }
}
