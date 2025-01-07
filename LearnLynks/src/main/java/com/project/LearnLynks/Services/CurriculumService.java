package com.project.LearnLynks.Services;

import com.project.LearnLynks.Dtos.Request.CreateCurriculumRequest;
import com.project.LearnLynks.Dtos.Request.DeleteCurriculumRequest;
import com.project.LearnLynks.Dtos.Request.FindCurriculumRequest;
import com.project.LearnLynks.Dtos.Request.UpdateCurriculumRequest;
import com.project.LearnLynks.Dtos.Response.*;

public interface CurriculumService {
    CreateCurriculumResponse create (CreateCurriculumRequest createCurriculumRequest);
    UpdateCurriculumResponse update (UpdateCurriculumRequest updateCurriculumRequest);
    FindCurriculumResponse findByName (FindCurriculumRequest findCurriculumRequest);
    FindCurriculumResponse getAll();
    ArchiveCurriculumResponse archive();
    DeleteCurriculumResponse deleteCurriculum(DeleteCurriculumRequest deleteCurriculumRequest);
}
