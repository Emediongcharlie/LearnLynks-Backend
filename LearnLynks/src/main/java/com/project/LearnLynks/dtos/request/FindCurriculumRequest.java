package com.project.LearnLynks.dtos.request;

public class FindCurriculumRequest {
    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int curriculumId;
    private String name;
}
