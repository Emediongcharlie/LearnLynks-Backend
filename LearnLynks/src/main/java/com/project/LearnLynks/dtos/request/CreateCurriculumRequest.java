package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.Data.Models.Courses;

import java.time.LocalDate;
import java.util.List;

public class CreateCurriculumRequest {
    private String name;
    private String description;
    private String creator;

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
