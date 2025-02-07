package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.EmailSenderRequest;
import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.request.SearchProgressReportRequest;
import com.project.LearnLynks.dtos.response.EmailSenderResponse;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.dtos.response.SearchProgressReportResponse;
import com.project.LearnLynks.exceptions.UserNotFoundException;
import com.project.LearnLynks.models.*;
import com.project.LearnLynks.repositories.LessonPlanRepository;
import com.project.LearnLynks.repositories.ProgressReportRepository;
import com.project.LearnLynks.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressReportServiceImpl implements ProgressReportService {


    @Autowired
    private ProgressReportRepository progressReportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private LessonPlanRepository lessonPlanRepository;

    @Override
    public ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest) {
//        Users users = new Users();
        ProgressReport progressReport = new ProgressReport();
        Optional<Users> userOptional = userRepository.findById(progressReportRequest.getUserId());
        {
            if (!userOptional.isPresent()) {
                throw new UserNotFoundException("user not found" + progressReportRequest.getUserId());
            }
            Users user = userOptional.get();
            Optional<LessonPlan> lessonPlanOptional = lessonPlanRepository.findById(progressReportRequest.getLessonPlanId());
            if (!lessonPlanOptional.isPresent()) {
                throw new IllegalArgumentException("Lesson Plan not found with ID: " + progressReportRequest.getLessonPlanId());
            }
            LessonPlan lessonPlan = lessonPlanOptional.get();
            progressReport.setLessonPlan(lessonPlan);

            System.out.println("LessonPlan ID: " + (lessonPlan != null ? lessonPlan.getId() : "NULL"));
            System.out.println("LessonPlan Name: " + (lessonPlan != null ? lessonPlan.getLessonPlanName() : "NULL"));


            progressReport.setUser(user);
            progressReport.setStatus(progressReportRequest.getStatus());
            progressReport.setReportDate(LocalDate.now());
            progressReport.setLessonPlan(lessonPlan);
            progressReport.setRecommendation(progressReportRequest.getRecommendation());
            progressReport.setGrade(progressReportRequest.getGrade());

            switch (progressReport.getGrade()) {
                case A:
                    progressReport.setStrength(Ability.great_one);
                    break;
                case B:
                    progressReport.setStrength(Ability.Good_at_who_grasping_new_concepts_easily);
                    break;
                case C:
                    progressReport.setStrength(Ability.Great_learner_but_needs_more_time_and_repetition);
                    break;
                case D:
                    progressReport.setStrength(Ability.Low_test_scores_and_grades_put_more_effort);
                    progressReport.setWeakness(Ability.Poor_analytical_skill);
                    break;
                case E:
                    progressReport.setStrength(Ability.Low_test_scores_and_grades_put_more_effort);
                    progressReport.setWeakness(Ability.Struggling_to_grasp_key_ideas_in_a_particular_subject_area);
                    break;
                case F:
                    progressReport.setStrength(Ability.Struggling_to_grasp_key_ideas_in_a_particular_subject_area);
                    progressReport.setWeakness(Ability.Poor_analytical_skill);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid grade: " + progressReport.getGrade());
            }

            ProgressReport savedReport = progressReportRepository.save(progressReport);

            System.out.println("Saved LessonPlan in Report: " + (savedReport.getLessonPlan() != null ? savedReport.getLessonPlan().getLessonPlanName() : "NULL"));


            ProgressReportResponse response = new ProgressReportResponse();
            response.setId(savedReport.getProgressId());
            response.setUserId(savedReport.getUser().getId());
            response.setStatus(savedReport.getStatus());
            response.setReportDate(savedReport.getReportDate());
            response.setLessonPlanName(savedReport.getLessonPlan().getLessonPlanName());
            response.setGrade(savedReport.getGrade());

            response.setStrength(savedReport.getStrength() != null ? savedReport.getStrength().toString() : "None");
            response.setWeakness(savedReport.getWeakness() != null ? savedReport.getWeakness().toString() : "None");
            response.setRecommendation(savedReport.getRecommendation());

            return response;
        }
    }


    public List<ProgressReport> getAllProgressReports() {
        return progressReportRepository.findAll();
    }

    public SearchProgressReportResponse searchById(SearchProgressReportRequest searchProgressReportRequest) {
        Optional<ProgressReport> optionalProgressReport = progressReportRepository.findById(searchProgressReportRequest.getUser().getId());
        if (!optionalProgressReport.isPresent()) {
            throw new UserNotFoundException("user not found" + searchProgressReportRequest.getUser().getId());
        }
        ProgressReport progressReport = optionalProgressReport.get();
        System.out.println("Found ProgressReport: " + progressReport);

        SearchProgressReportResponse response = new SearchProgressReportResponse();
        response.setUserId(progressReport.getUser().getId());
        response.setStatus(progressReport.getStatus());
        response.setReportDate(progressReport.getReportDate());
        response.setLessonPlanName(progressReport.getLessonPlan().getLessonPlanName());
        response.setGrade(progressReport.getGrade());
        response.setStrength(progressReport.getStrength() != null ? progressReport.getStrength().toString() : "None");
        response.setWeakness(progressReport.getWeakness() != null ? progressReport.getWeakness().toString() : "None");
        response.setRecommendation(progressReport.getRecommendation());
        return response;

    }

    public EmailSenderResponse sendEmail(EmailSenderRequest emailSenderRequest) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailSenderRequest.getTo());
        mailMessage.setSubject(emailSenderRequest.getSubject());
        mailMessage.setText(emailSenderRequest.getBody());
        javaMailSender.send(mailMessage);
        EmailSenderResponse emailSenderResponse = new EmailSenderResponse();
        emailSenderResponse.setMessage("Successfully sent email");
        return emailSenderResponse;

    }

    public EmailSenderResponse sendEmailWithAttachment(EmailSenderRequest emailSenderRequest) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("emediongcharlie@gmail.com");
        helper.setTo(emailSenderRequest.getTo());
        helper.setSubject(emailSenderRequest.getSubject());
        helper.setText(emailSenderRequest.getBody(), true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(emailSenderRequest.getAttachment()));
        helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(mimeMessage);
        EmailSenderResponse emailSenderResponse = new EmailSenderResponse();
        emailSenderResponse.setMessage("Successfully sent email");
        return emailSenderResponse;

    }

    }

