package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.EmailSenderRequest;
import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.EmailSenderResponse;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;
import com.project.LearnLynks.models.Status;
import com.project.LearnLynks.models.Users;
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
import java.util.Optional;

@Service
public class ProgressReportServiceImpl implements ProgressReportService {


    @Autowired
    private ProgressReportRepository progressReportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest) {

        Optional<Users> user = userRepository.findById(progressReportRequest.getId());
        if (user.isPresent()) {
            ProgressReport progressReport = new ProgressReport();
            progressReport.setId(progressReportRequest.getId());
            progressReport.setAssessment(progressReportRequest.getAssessment());
            progressReport.setStartDate(LocalDate.now());
            progressReport.setEndDate(progressReportRequest.getEndDate().plusMonths(1));
            progressReport.setStatus(Status.ACTIVE);
            progressReportRepository.save(progressReport);
            ProgressReportResponse progressReportResponse = getProgressReportResponse(progressReport);
            return progressReportResponse;
        }
        throw new IllegalArgumentException("User not found");
    }

    private static ProgressReportResponse getProgressReportResponse(ProgressReport progressReport) {
        ProgressReportResponse progressReportResponse = new ProgressReportResponse();
        progressReportResponse.setId(progressReport.getId());
        progressReportResponse.setAssessment(progressReport.getAssessment());
        progressReportResponse.setStartDate(progressReport.getStartDate());
        progressReportResponse.setEndDate(progressReport.getEndDate());
        progressReportResponse.setStatus(Status.ACTIVE);
        progressReportResponse.setMessage("Successfully generated progress report");

        return progressReportResponse;
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

