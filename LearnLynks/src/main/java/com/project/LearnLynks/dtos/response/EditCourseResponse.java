package com.project.LearnLynks.dtos.response;

public class EditCourseResponse {
    private int courseId;
    private String message;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
