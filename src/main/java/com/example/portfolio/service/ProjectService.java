package com.example.portfolio.service;

import com.example.portfolio.model.Project;
import com.example.portfolio.repository.ProjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(int id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No project found with id: " + id));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
