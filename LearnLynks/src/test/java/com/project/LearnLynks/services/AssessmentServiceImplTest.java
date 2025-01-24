package com.project.LearnLynks.services;

import com.project.LearnLynks.repositories.AssessmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssessmentServiceImplTest {

    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private AssessmentRepository assessmentRepository;

    @Test
    public void testSuccessfulAssessmentCreated() {

    }
}
