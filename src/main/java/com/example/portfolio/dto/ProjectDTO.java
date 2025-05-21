package com.example.portfolio.dto;

import java.util.List;

public class ProjectDTO {
    private String title;
    private String shortDescription;
    private String longDescription;
    private List<String> category;
    private String funFact;
    private String stack;
    private String gitHubUrl;
    private String imageDescription;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public List<String> getCategory() { return category; }
    public void setCategory(List<String> category) { this.category = category; }

    public String getFunFact() { return funFact; }
    public void setFunFact(String funFact) { this.funFact = funFact; }

    public String getStack() { return stack; }
    public void setStack(String stack) { this.stack = stack; }

    public String getGitHubUrl() { return gitHubUrl; }
    public void setGitHubUrl(String gitHubUrl) { this.gitHubUrl = gitHubUrl; }

    public String getImageDescription() { return imageDescription; }
    public void setImageDescription(String imageDescription) { this.imageDescription = imageDescription; }
}
