package com.project.LearnLynks.dtos.request;

public class EditCourseRequest {
    private int courseId;

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private String name;
    private String description;
    private String learningObjective;

    public int getCourseId() {
        return courseId;
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

    public String getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(String learningObjective) {
        this.learningObjective = learningObjective;
    }
}
