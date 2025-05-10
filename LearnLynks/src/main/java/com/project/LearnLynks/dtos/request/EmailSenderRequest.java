package com.project.LearnLynks.dtos.request;

import lombok.Getter;
import lombok.Setter;


public class EmailSenderRequest {

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String to;
    private String subject;
    private String body;
    private String attachment;
}
