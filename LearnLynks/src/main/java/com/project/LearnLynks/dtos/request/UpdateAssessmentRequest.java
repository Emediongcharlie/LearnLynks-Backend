package com.project.LearnLynks.dtos.request;

public class UpdateAssessmentRequest {
    private Double totalScore;
    private Double timeSpent;

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Double timeSpent) {
        this.timeSpent = timeSpent;
    }
}
