package com.project.LearnLynks.dtos.response;

public class UpdateCurriculumResponse {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    private Long curriculumId;
}
