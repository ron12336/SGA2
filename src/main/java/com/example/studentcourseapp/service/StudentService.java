package com.example.studentcourseapp.service;

import com.example.studentcourseapp.model.Student;
import com.example.studentcourseapp.dto.StudentCourseDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Student student);
    List<StudentCourseDTO> getStudentCourseData();
}