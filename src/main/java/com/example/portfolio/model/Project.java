package com.example.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.ElementCollection;

@Entity
@Table(name= "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //title
    private String title;
    //shortDescrption
    private String shortDescription;
    //longDescription
    private String longDescription;
    //category - choice of 3
    @ElementCollection
    private List<String> category;
    //funFact
    private String funFact;
    //stack
    private String stack;
    //url
    private String gitHubUrl;
    //image loc
    private String imageSource;
    //image description
    private String imageDescription; 

    public Project() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getFunFact() {
        return this.funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getStack() {
        return this.stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getGitHubUrl() {
        return this.gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getImageSource() { 
        return imageSource; 
    }
    
    public void setImageSource(String imageSource) { 
        this.imageSource = imageSource; 
    }

    public String getImageDescription() { 
        return imageDescription; 
    }
    
    public void setImageDescription(String imageDescription) { 
        this.imageDescription = imageDescription; 
    }
}
