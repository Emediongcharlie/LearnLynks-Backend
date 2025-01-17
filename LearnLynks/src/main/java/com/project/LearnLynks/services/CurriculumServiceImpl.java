package com.project.LearnLynks.services;

import com.project.LearnLynks.Data.Models.Curriculum;
import com.project.LearnLynks.Data.Repositories.CurriculumRepository;
import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    private final CurriculumRepository curriculumRepository;

    public CurriculumServiceImpl (CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    @Override
    public CreateCurriculumResponse create (CreateCurriculumRequest createCurriculumRequest) {
        if (createCurriculumRequest == null) {
            throw new IllegalArgumentException("Create curriculum request cannot be null");
        }

        if (createCurriculumRequest.getName() == null || createCurriculumRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("Curriculum name is required");
        }

        if (createCurriculumRequest.getDescription() == null || createCurriculumRequest.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Curriculum description is required");
        }

        if (createCurriculumRequest.getCreator() == null ||createCurriculumRequest.getCreator().isEmpty()) {
            throw new IllegalArgumentException("Curriculum creator is required");
        }

        Curriculum curriculum = new Curriculum();
        curriculum.setName(createCurriculumRequest.getName());
        curriculum.setDescription(createCurriculumRequest.getDescription());
        curriculum.setCreator(createCurriculumRequest.getCreator());

        Curriculum save = curriculumRepository.save(curriculum);

        CreateCurriculumResponse response = new CreateCurriculumResponse();
        response.setCurriculumId(save.getCurriculumId());
        response.setMessage("Created successfully");

        return response;
    }

    @Override
    public UpdateCurriculumResponse update (UpdateCurriculumRequest updateCurriculumRequest) {
        if (updateCurriculumRequest == null) {
            throw new IllegalArgumentException("Update request cannot be null");
        }

        if (updateCurriculumRequest.getName() == null || updateCurriculumRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("curriculum name is required");
        }

        if (updateCurriculumRequest.getDescription() == null || updateCurriculumRequest.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Course name is required");
        }

        if (updateCurriculumRequest.getCreator() == null || updateCurriculumRequest.getCreator().isEmpty()) {
            throw new IllegalArgumentException("Course name is required");
        }

        Curriculum curriculum = curriculumRepository.findById(updateCurriculumRequest.getCurriculumId())
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        curriculum.setName(updateCurriculumRequest.getName());
        curriculum.setDescription(updateCurriculumRequest.getDescription());
        curriculum.setCreator(updateCurriculumRequest.getCreator());

        Curriculum update = curriculumRepository.save(curriculum);

        UpdateCurriculumResponse response = new UpdateCurriculumResponse();
        response.setCurriculumId(update.getCurriculumId());
        response.setMessage("Updated successfully");

        return response;
    }

    @Override
    public FindCurriculumResponse findByName (FindCurriculumRequest findCurriculumRequest) {
        if (findCurriculumRequest == null) {
            throw new IllegalArgumentException("Find request cannot be null");
        }

        Curriculum curriculum = curriculumRepository.findByName(findCurriculumRequest.getName())
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        FindCurriculumResponse response = new FindCurriculumResponse();
        response.setName(curriculum.getName());
        response.setDescription(curriculum.getDescription());
        response.setCreator(curriculum.getCreator());

        return response;
    }

    @Override
    public FindCurriculumResponse getAll() {
        List<Curriculum> curricula = curriculumRepository.findAll();
        FindCurriculumResponse response = new FindCurriculumResponse();
        response.setCurricula(curricula);
        response.setMessage("Curricula retrieved successfully");

        return response;
    }

    @Override
    public ArchiveCurriculumResponse archive(Long curriculumId) {

        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        curriculum.setArchived(true);

        Curriculum archivedCurriculum = curriculumRepository.save(curriculum);

        ArchiveCurriculumResponse response = new ArchiveCurriculumResponse();
        response.setCurriculumId(archivedCurriculum.getCurriculumId());
        response.setMessage("Archived successfully");

        return response;
    }

    @Override
    public DeleteCurriculumResponse deleteCurriculum(DeleteCurriculumRequest deleteCurriculumRequest) {
        Curriculum curriculum = curriculumRepository.findById(deleteCurriculumRequest.getCurriculumId())
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        curriculumRepository.delete(curriculum);

        DeleteCurriculumResponse response = new DeleteCurriculumResponse();
        response.setMessage("Deleted successfully");

        return response;
    }
}
