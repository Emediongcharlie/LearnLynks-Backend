package com.project.LearnLynks;

import com.project.LearnLynks.dtos.request.CreateLessonPlanRequest;
import com.project.LearnLynks.dtos.response.CreateLessonPlanResponse;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.services.LessonPlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LessonPlanTest {

    @Autowired
    private LessonPlanService lessonPlanService;

    @Test
    public void testLessonsWereCreated(){
        CreateLessonPlanRequest request = new CreateLessonPlanRequest();
        request.setLessonPlanName("physics course");
        request.setLessonPlanDescription("thermodynamics");
        request.setLessonPlanDuration(LocalDate.ofEpochDay(3));
        CreateLessonPlanResponse response = lessonPlanService.createLessonPlan(request);
        assertNotNull(response);
    }

    @Test
    public void testLessonCouldBeFoundByID(){
        CreateLessonPlanRequest request = new CreateLessonPlanRequest();
        request.setLessonPlanName("physics course");
        request.setLessonPlanId(1L);
        LessonPlan response = lessonPlanService.getLessonPlanById(1);
        assertNotNull(response);
        assertEquals(response.getLessonPlanId(), 1);
        assertEquals(response.getLessonPlanName(), "physics course");
    }

    @Test
    public void testLessonDeleteById(){
        CreateLessonPlanRequest request = new CreateLessonPlanRequest();
        request.setLessonPlanName("physics course");
        request.setLessonPlanId(1L);
        LessonPlan response = lessonPlanService.deleteLessonPlan(1);
        assertEquals(response.getLessonPlanId(), 0);
    }


}
