package com.project.LearnLynks.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends User {

    private String course;
    private String level;
}
