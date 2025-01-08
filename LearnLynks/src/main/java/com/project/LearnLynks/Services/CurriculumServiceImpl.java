package com.project.LearnLynks.Services;

import com.project.LearnLynks.Data.Repositories.CurriculumRepository;
import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    private final CurriculumRepository curriculumRepository;

    public CurriculumServiceImpl (CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    @Override
    public CreateCurriculumResponse create (CreateCurriculumRequest createCurriculumRequest) {
        return null;
    }

    @Override
    public UpdateCurriculumResponse update (UpdateCurriculumRequest updateCurriculumRequest) {
        return null;
    }

    @Override
    public FindCurriculumResponse findByName (FindCurriculumRequest findCurriculumRequest) {
        return null;
    }

    @Override
    public FindCurriculumResponse getAll() {
        return null;
    }

    @Override
    public ArchiveCurriculumResponse archive() {
        return null;
    }

    @Override
    public DeleteCurriculumResponse deleteCurriculum(DeleteCurriculumRequest deleteCurriculumRequest) {
        return null;
    }
}
