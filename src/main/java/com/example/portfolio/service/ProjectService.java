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

    public Project updateProject(int id, Project updates) {
    Project existing = projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No project found with id: " + id));

    if (updates.getTitle() != null) {
        existing.setTitle(updates.getTitle());
    }
    if (updates.getShortDescription() != null) {
        existing.setShortDescription(updates.getShortDescription());
    }
    if (updates.getLongDescription() != null) {
        existing.setLongDescription(updates.getLongDescription());
    }
    if (updates.getCategory() != null) {
        existing.setCategory(updates.getCategory());
    }
    if (updates.getFunFact() != null) {
        existing.setFunFact(updates.getFunFact());
    }
    if (updates.getStack() != null) {
        existing.setStack(updates.getStack());
    }
    if (updates.getGitHubUrl() != null) {
    existing.setGitHubUrl(updates.getGitHubUrl());
    }
    return projectRepository.save(existing);
}
}
