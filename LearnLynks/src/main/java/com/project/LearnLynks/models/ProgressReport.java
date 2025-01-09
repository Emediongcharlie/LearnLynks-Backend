package com.project.LearnLynks.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
public class ProgressReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usersId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDaysSinceStart() {
        return daysSinceStart;
    }

    public void setDaysSinceStart(LocalDate daysSinceStart) {
        this.daysSinceStart = daysSinceStart;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNoOfTaskCompleted() {
        return noOfTaskCompleted;
    }

    public void setNoOfTaskCompleted(int noOfTaskCompleted) {
        this.noOfTaskCompleted = noOfTaskCompleted;
    }

    @ManyToOne
    private Assessment assessment;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate daysSinceStart;
    private String message;
    private int noOfTaskCompleted;
}
