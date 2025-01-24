package com.project.LearnLynks.Web;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.request.UpdateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;
import com.project.LearnLynks.dtos.response.DeleteAssessmentResponse;
import com.project.LearnLynks.dtos.response.GetAssessmentResponse;
import com.project.LearnLynks.dtos.response.UpdateAssessmentResponse;
import com.project.LearnLynks.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentServiceController {

    private final AssessmentService assessmentService;

    @Autowired
    public AssessmentServiceController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping
    public CreateAssessmentResponse createAssessment(@RequestBody CreateAssessmentRequest createAssessmentRequest) {
        return assessmentService.createAssessment(createAssessmentRequest);
    }

    @GetMapping("/{assessmentId}")
    public GetAssessmentResponse getAssessment(@PathVariable Long assessmentId) {
        return assessmentService.getAssessment(assessmentId);
    }

    @PutMapping("/{assessmentId}")
    public UpdateAssessmentResponse updateAssessment(@PathVariable Long assessmentId,
                                                     @RequestBody UpdateAssessmentRequest request) {
        return assessmentService.updateAssessment(assessmentId, request);
    }

    @DeleteMapping("/{assessmentId}")
    public DeleteAssessmentResponse deleteAssessment(@PathVariable Long assessmentId) {
        return assessmentService.deleteAssessment(assessmentId);
    }
}
