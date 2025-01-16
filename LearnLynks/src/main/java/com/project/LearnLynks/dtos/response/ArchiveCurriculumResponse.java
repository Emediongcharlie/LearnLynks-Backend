package com.project.LearnLynks.dtos.response;

public class ArchiveCurriculumResponse {
    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    private Long curriculumId;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
