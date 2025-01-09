package com.project.LearnLynks.dtos.response;

import lombok.Getter;
import lombok.Setter;


public class EmailSenderResponse {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
