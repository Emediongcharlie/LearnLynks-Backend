package com.project.LearnLynks.Services;

import com.project.LearnLynks.Data.Models.Courses;
import com.project.LearnLynks.Data.Repositories.CoursesRepository;
import com.project.LearnLynks.dtos.request.AddCoursesRequest;
import com.project.LearnLynks.dtos.request.DeleteCourseRequest;
import com.project.LearnLynks.dtos.request.EditCourseRequest;
import com.project.LearnLynks.dtos.response.AddCoursesResponse;
import com.project.LearnLynks.dtos.response.DeleteCourseResponse;
import com.project.LearnLynks.dtos.response.EditCourseResponse;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CoursesRepository coursesRepository;

    public CourseServiceImpl (CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public AddCoursesResponse addCourse (AddCoursesRequest addCoursesRequest) {

        if (addCoursesRequest == null) {
            throw new IllegalArgumentException("Add courses field cannot be empty");
        }

        if (addCoursesRequest.getName() == null || addCoursesRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("Course name is required");
        }

        if (addCoursesRequest.getDescription() == null || addCoursesRequest.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Course description is required");
        }

        if (addCoursesRequest.getLearningObjectives() == null || addCoursesRequest.getLearningObjectives().isEmpty()) {
            throw new IllegalArgumentException("Learning objectives are required");
        }

        Courses course = new Courses();
        course.setName(addCoursesRequest.getName());
        course.setDescription(addCoursesRequest.getDescription());
        course.setLearningObjectives(addCoursesRequest.getLearningObjectives());

        Courses saved = coursesRepository.save(course);

        AddCoursesResponse response = new AddCoursesResponse();
        response.setCourseId(saved.getCourseId());
        response.setMessage("Course added successfully");

        return response;
    }

    @Override
    public EditCourseResponse editCourse (EditCourseRequest editCourseRequest) {

        if (editCourseRequest == null) {
            throw new IllegalArgumentException("Edit course cannot be null");
        }

        if (editCourseRequest.getName() == null || editCourseRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("Course name is required");
        }

        if (editCourseRequest.getDescription() == null || editCourseRequest.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Course description is required");
        }

        if (editCourseRequest.getLearningObjective() == null || editCourseRequest.getLearningObjective().isEmpty()) {
            throw new IllegalArgumentException("Learning objectives are required");
        }

        Courses course = coursesRepository.findById(editCourseRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setName(editCourseRequest.getName());
        course.setDescription(editCourseRequest.getDescription());
        course.setLearningObjectives(editCourseRequest.getLearningObjective());

        Courses updatedCourse = coursesRepository.save(course);

        EditCourseResponse response = new EditCourseResponse();
        response.setCourseId(updatedCourse.getCourseId());
        response.setMessage("Course updated successfully");

        return response;
    }

    @Override
    public DeleteCourseResponse deleteCourse (DeleteCourseRequest deleteCourseRequest) {

        if (deleteCourseRequest == null) {
            throw new IllegalArgumentException("Delete Course Request cannot be null");
        }

        Courses course = coursesRepository.findById(deleteCourseRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        coursesRepository.delete(course);

        DeleteCourseResponse response = new DeleteCourseResponse();
        response.setMessage("Course deleted successfully");

        return response;
    }
}
