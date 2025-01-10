package com.project.LearnLynks.dtos.request;

public class DeleteCurriculumRequest {
    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    private Long curriculumId;
}
