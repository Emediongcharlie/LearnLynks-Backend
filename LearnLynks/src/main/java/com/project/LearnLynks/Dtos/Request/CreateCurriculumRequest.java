package com.project.LearnLynks.Dtos.Request;

import com.project.LearnLynks.Data.Models.CoursesData;
import com.project.LearnLynks.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateCurriculumRequest {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private String creator;
    private List<CoursesData> courses;
}
