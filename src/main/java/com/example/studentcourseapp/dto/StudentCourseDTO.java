package com.example.studentcourseapp.dto;

public class StudentCourseDTO {
    private String studentName;
    private String courseTitle;

    public StudentCourseDTO(String studentName, String courseTitle) {
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}