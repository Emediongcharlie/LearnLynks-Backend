package com.project.LearnLynks.dtos.request;

public class DeleteCurriculumRequest {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Long curriculumId;

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }
}
