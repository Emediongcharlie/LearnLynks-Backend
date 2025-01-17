package com.project.LearnLynks.services;

import com.project.LearnLynks.Data.Repositories.CoursesRepository;
import com.project.LearnLynks.dtos.request.AddCoursesRequest;
import com.project.LearnLynks.dtos.request.DeleteCourseRequest;
import com.project.LearnLynks.dtos.request.EditCourseRequest;
import com.project.LearnLynks.dtos.response.AddCoursesResponse;
import com.project.LearnLynks.dtos.response.DeleteCourseResponse;
import com.project.LearnLynks.dtos.response.EditCourseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CoursesRepository coursesRepository;

    @Test
    public void testAddCourseSuccessfully() {
        AddCoursesRequest request = new AddCoursesRequest();
        request.setName("Software engineering");
        request.setDescription("Software engineering is how to write our web app code");
        request.setLearningObjectives("You will be able to code after this course");

        AddCoursesResponse response = courseService.addCourse(request);

        assertNotNull(response);
        assertEquals("Course added successfully", response.getMessage());
    }

    @Test
    public void testAddCourseFail() {
        AddCoursesRequest add = new AddCoursesRequest();
        add.setName("");
        add.setDescription("");
        add.setLearningObjectives("Software engineering");
        try {
            courseService.addCourse(add);
            assert false : "Expected IllegalArgumentException to be thrown";
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            assertTrue(errorMessage.contains("Course name is required") ||
                    errorMessage.contains("Course description is required"));
        }
    }

    @Test
    public void testAddCourseNullRequest() {
        assertThrows(IllegalArgumentException.class, () -> courseService.addCourse(null));
    }

    @Test
    public void testEditCourse() {
        AddCoursesRequest addRequest = new AddCoursesRequest();

        addRequest.setName("Engineering");
        addRequest.setDescription("Engineering is how to join wires");
        addRequest.setLearningObjectives("You will be able to join wires after this course");

        AddCoursesResponse addResponse = courseService.addCourse(addRequest);

        EditCourseRequest editRequest = new EditCourseRequest();
        editRequest.setCourseId(addResponse.getCourseId());
        editRequest.setName("Updated Engineering");
        editRequest.setDescription("Updated Engineering is how to join wires");
        editRequest.setLearningObjective("Updated You will be able to join wires after this course");

        EditCourseResponse response = courseService.editCourse(editRequest);

        assertNotNull(response);
        assertEquals("Course updated successfully", response.getMessage());
    }

    @Test
    public void testEditCourseEmptySpace() {
        AddCoursesRequest addRequest = new AddCoursesRequest();

        addRequest.setName("Health care management");
        addRequest.setDescription("It's the general study of the wellbeing of humans");
        addRequest.setLearningObjectives("How to do your personal hygiene");

        AddCoursesResponse addResponse = courseService.addCourse(addRequest);

        EditCourseRequest editRequest = new EditCourseRequest();
        editRequest.setCourseId(addResponse.getCourseId());
        editRequest.setName("Updated Health care management");
        editRequest.setDescription("");
        editRequest.setLearningObjective("How to do your personal hygiene");

        try {
            courseService.editCourse(editRequest);
            assert false : "Expected IllegalArgumentException to be thrown";
        } catch (IllegalArgumentException e) {
            assertEquals("Course description is required", e.getMessage());
        }
    }

    @Test
    public void testEditCourseNullRequest () {
        assertThrows(IllegalArgumentException.class, () -> courseService.editCourse(null));
    }

    @Test
    public void testDeleteCourse() {
        AddCoursesRequest request = new AddCoursesRequest();
        request.setName("Test course");
        request.setDescription("Test course description");
        request.setLearningObjectives("Test learning objectives");

        AddCoursesResponse response = courseService.addCourse(request);

        DeleteCourseRequest deleteRequest = new DeleteCourseRequest();
        deleteRequest.setCourseId(response.getCourseId());

        DeleteCourseResponse deleteResponse = courseService.deleteCourse(deleteRequest);

        assertNotNull(deleteResponse);
        assertEquals("Course deleted successfully", deleteResponse.getMessage());
    }
}
