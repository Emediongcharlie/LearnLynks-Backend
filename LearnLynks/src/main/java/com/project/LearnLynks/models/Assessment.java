package com.project.LearnLynks.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Assessment {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MultipleChoiceQuestions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<MultipleChoiceQuestions> questions) {
        this.questions = questions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<MultipleChoiceQuestions> questions;
    private int score;
    private Double average;
    private Status status;
}
