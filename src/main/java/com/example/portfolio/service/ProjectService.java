package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.model.Project;
import com.example.portfolio.repository.ProjectRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Path;
import java.util.UUID;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProjectWithImage(ProjectDTO dto, MultipartFile imageFile) {
    String newFilename = null;

    if (imageFile != null && !imageFile.isEmpty()) {
        try {
            String uploadDir = System.getProperty("user.dir") + "/uploads";

            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            String originalFilename = imageFile.getOriginalFilename();
            newFilename = UUID.randomUUID() + "_" + originalFilename;
            Path destination = Path.of(uploadDir, newFilename);
            Files.copy(imageFile.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    Project project = new Project();
    project.setTitle(dto.getTitle());
    project.setShortDescription(dto.getShortDescription());
    project.setLongDescription(dto.getLongDescription());
    project.setCategory(dto.getCategory());
    project.setFunFact(dto.getFunFact());
    project.setStack(dto.getStack());
    project.setGitHubUrl(dto.getGitHubUrl());
    project.setImageDescription(dto.getImageDescription());

    if (newFilename != null) {
        project.setImageSource("/uploads/" + newFilename);
    }

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

    public void deleteProject(int id) {
    if (!projectRepository.existsById(id)) {
        throw new RuntimeException("No project found with id: " + id);
    }
    projectRepository.deleteById(id);
    }
}
