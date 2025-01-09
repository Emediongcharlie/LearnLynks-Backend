package com.project.LearnLynks.Services;

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
    ArchiveCurriculumResponse archive(int curriculumId);
    DeleteCurriculumResponse deleteCurriculum(DeleteCurriculumRequest deleteCurriculumRequest);
}
