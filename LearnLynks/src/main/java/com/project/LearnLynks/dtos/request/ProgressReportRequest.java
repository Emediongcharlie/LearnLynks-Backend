package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.Assessment;
import com.project.LearnLynks.models.Status;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class ProgressReportRequest {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoOfTaskCompleted() {
        return noOfTaskCompleted;
    }

    public void setNoOfTaskCompleted(int noOfTaskCompleted) {
        this.noOfTaskCompleted = noOfTaskCompleted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDaysSinceStart() {
        return daysSinceStart;
    }

    public void setDaysSinceStart(LocalDate daysSinceStart) {
        this.daysSinceStart = daysSinceStart;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    private Long id;
    private Long usersId;
    @ManyToOne
    private Assessment assessment;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate daysSinceStart;
    private String message;
    private int noOfTaskCompleted;
}
