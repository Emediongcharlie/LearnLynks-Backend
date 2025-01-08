package com.project.LearnLynks.Services;

import com.project.LearnLynks.dtos.request.AddCoursesRequest;
import com.project.LearnLynks.dtos.request.DeleteCourseRequest;
import com.project.LearnLynks.dtos.request.EditCourseRequest;
import com.project.LearnLynks.dtos.response.AddCoursesResponse;
import com.project.LearnLynks.dtos.response.DeleteCourseResponse;
import com.project.LearnLynks.dtos.response.EditCourseResponse;

public interface CourseService {
    AddCoursesResponse addCourse (AddCoursesRequest addCoursesRequest);
    EditCourseResponse editCourse (EditCourseRequest editCourseRequest);
    DeleteCourseResponse deleteCourse (DeleteCourseRequest deleteCourseRequest);
}
