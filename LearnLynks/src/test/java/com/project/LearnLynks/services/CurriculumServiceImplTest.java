package com.project.LearnLynks.services;

import com.project.LearnLynks.Data.Models.Curriculum;
import com.project.LearnLynks.Data.Repositories.CurriculumRepository;
import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.services.CurriculumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CurriculumServiceImplTest {

    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private CurriculumRepository curriculumRepository;

    @Test
    public void testCreateCurriculum() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Test curriculum");
        request.setDescription("Test description");
        request.setCreator("Sunday");

        CreateCurriculumResponse response = curriculumService.create(request);

        assertNotNull(response);
        assertEquals("Created successfully", response.getMessage());
    }

    @Test
    public void testCreateCurriculumWithNullRequest() {
        assertThrows(IllegalArgumentException.class, () -> curriculumService.create(null));
    }

    @Test
    public void testCreateCurriculumWithAnEmpty() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("");
        request.setDescription("Empty description");
        request.setCreator("Kim");

        try {
            curriculumService.create(request);
            assert false : "Expected IllegalArgumentException to be thrown";
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            assertTrue(errorMessage.contains("Curriculum name is required"));
        }
    }

    @Test
    public void testCreateCurriculumWithAnEmptyDescription() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Empty");
        request.setDescription("");
        request.setCreator("Kim");

        try {
            curriculumService.create(request);
            assert false : "Expected IllegalArgumentException to be thrown";
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            assertTrue(errorMessage.contains("Curriculum description is required"));
        }
    }

    @Test
    public void testUpdateCurriculum() {
        CreateCurriculumRequest curriculum = new CreateCurriculumRequest();

        curriculum.setName("Test curriculum");
        curriculum.setDescription("This is a test curriculum");
        curriculum.setCreator("John");

        CreateCurriculumResponse createResponse = curriculumService.create(curriculum);

        UpdateCurriculumRequest updateRequest = new UpdateCurriculumRequest();
        updateRequest.setCurriculumId(createResponse.getCurriculumId());
        updateRequest.setName("Updated Test curriculum");
        updateRequest.setDescription("This is an updated test curriculum");
        updateRequest.setCreator("Jane");

        UpdateCurriculumResponse response = curriculumService.update(updateRequest);

        assertNotNull(response);
        assertEquals("Updated successfully", response.getMessage());
    }

    @Test
    public void testFindByName() {
        CreateCurriculumRequest curriculum = new CreateCurriculumRequest();

        curriculum.setName("Curry soup");
        curriculum.setDescription("This is ac");
        curriculum.setCreator("Johnny");

        CreateCurriculumResponse createResponse = curriculumService.create(curriculum);

        FindCurriculumRequest find = new FindCurriculumRequest();
        find.setName("Curry soup");

        FindCurriculumResponse findResponse = curriculumService.findByName(find);

        assertNotNull(findResponse);
        assertEquals(curriculum.getName(), findResponse.getName());
        assertEquals(curriculum.getDescription(), findResponse.getDescription());
        assertEquals(curriculum.getCreator(), findResponse.getCreator());
    }

    @Test
    public void testGetAll() {
        curriculumRepository.deleteAll();

        CreateCurriculumRequest request1 = new CreateCurriculumRequest();
        request1.setName("Curriculum 1");
        request1.setDescription("Description 1");
        request1.setCreator("Creator 1");
        curriculumService.create(request1);

        CreateCurriculumRequest request2 = new CreateCurriculumRequest();
        request2.setName("Curriculum 2");
        request2.setDescription("Description 2");
        request2.setCreator("Creator 2");
        curriculumService.create(request2);

        FindCurriculumResponse response = curriculumService.getAll();

        assertNotNull(response);
        assertNotNull(response.getCurricula());
        assertEquals(2, response.getCurricula().size());
    }

    @Test
    public void testArchiveCurriculum() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Test Curriculum");
        request.setDescription("This is a test curriculum");
        request.setCreator("John Doe");

        CreateCurriculumResponse createResponse = curriculumService.create(request);

        ArchiveCurriculumResponse response = curriculumService.archive(createResponse.getCurriculumId());

        assertNotNull(response);
        assertEquals(createResponse.getCurriculumId(), response.getCurriculumId());
        assertEquals("Archived successfully", response.getMessage());

        Curriculum archivedCurriculum = curriculumRepository.findById(createResponse.getCurriculumId()).orElseThrow();

        assertTrue(archivedCurriculum.isArchived());
    }

    @Test
    public void testArchiveAlreadyArchivedCurriculum() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Test Curriculum");
        request.setDescription("This is a test curriculum");
        request.setCreator("John Doe");
        CreateCurriculumResponse createResponse = curriculumService.create(request);

        curriculumService.archive(createResponse.getCurriculumId());

        ArchiveCurriculumResponse response = curriculumService.archive(createResponse.getCurriculumId());

        assertNotNull(response);
        assertEquals(createResponse.getCurriculumId(), response.getCurriculumId());
        assertEquals("Archived successfully", response.getMessage());
    }

    @Test
    public void testDeleteCurriculum() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Test Curriculum");
        request.setDescription("This is a test curriculum");
        request.setCreator("John Doe");
        CreateCurriculumResponse createResponse = curriculumService.create(request);

        DeleteCurriculumRequest deleteRequest = new DeleteCurriculumRequest();
        deleteRequest.setCurriculumId(createResponse.getCurriculumId());
        DeleteCurriculumResponse response = curriculumService.deleteCurriculum(deleteRequest);

        assertNotNull(response);
        assertEquals("Deleted successfully", response.getMessage());
    }

    @Test
    public void testDeleteAlreadyDeletedCurriculum() {
        CreateCurriculumRequest request = new CreateCurriculumRequest();
        request.setName("Test Curriculum");
        request.setDescription("This is a test curriculum");
        request.setCreator("John Doe");
        CreateCurriculumResponse createResponse = curriculumService.create(request);

        DeleteCurriculumRequest deleteRequest = new DeleteCurriculumRequest();
        deleteRequest.setCurriculumId(createResponse.getCurriculumId());
        curriculumService.deleteCurriculum(deleteRequest);

        try {
            curriculumService.deleteCurriculum(deleteRequest);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Curriculum not found", e.getMessage());
        }
    }

}
