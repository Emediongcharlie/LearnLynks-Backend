package com.project.LearnLynks.dtos.response;

import com.project.LearnLynks.Data.Models.Curriculum;

import java.util.List;

public class FindCurriculumResponse {
    private List<Curriculum> curricula;
    private String name;
    private String description;
    private String creator;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCurricula(List<Curriculum> curricula) {
        this.curricula = curricula;
    }

    public List<Curriculum> getCurricula() {
        return curricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
