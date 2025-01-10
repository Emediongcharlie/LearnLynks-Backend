package com.project.LearnLynks.Web;

import com.project.LearnLynks.Services.CurriculumService;
import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @PostMapping("/create")
    public CreateCurriculumResponse create (@RequestBody CreateCurriculumRequest createCurriculumRequest) {
        return curriculumService.create(createCurriculumRequest);
    }

    @PutMapping("/update")
    public UpdateCurriculumResponse update (@RequestBody UpdateCurriculumRequest updateCurriculumRequest) {
        return curriculumService.update(updateCurriculumRequest);
    }

    @GetMapping("/findByName")
    public FindCurriculumResponse findByName (@RequestBody FindCurriculumRequest findCurriculumRequest) {
        return curriculumService.findByName(findCurriculumRequest);
    }

    @GetMapping("/curricula")
    public FindCurriculumResponse getAll() {
        return curriculumService.getAll();
    }

    @PatchMapping("/curricula/{curriculumId}/archive")
    public ArchiveCurriculumResponse archive( @PathVariable Long curriculumId) {
        return curriculumService.archive(curriculumId);
    }

    @DeleteMapping("/deleteCurricula")
    public DeleteCurriculumResponse deleteCurriculum( @RequestBody DeleteCurriculumRequest deleteCurriculumRequest) {
        return curriculumService.deleteCurriculum(deleteCurriculumRequest);
    }
}
