package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;

public interface CurriculumService {
    CreateCurriculumResponse create (CreateCurriculumRequest createCurriculumRequest);
    UpdateCurriculumResponse update (UpdateCurriculumRequest updateCurriculumRequest);
    FindCurriculumResponse findByName (FindCurriculumRequest findCurriculumRequest);
    FindCurriculumResponse getAll();
    ArchiveCurriculumResponse archive(Long curriculumId);
    DeleteCurriculumResponse deleteCurriculum(DeleteCurriculumRequest deleteCurriculumRequest);
}
