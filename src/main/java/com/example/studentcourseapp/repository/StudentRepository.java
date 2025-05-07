package com.example.studentcourseapp.repository;

import com.example.studentcourseapp.model.Student;
import com.example.studentcourseapp.dto.StudentCourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT new com.example.studentcourseapp.dto.StudentCourseDTO(s.name, c.title) " +
    "FROM Student s JOIN s.courses c")
List<StudentCourseDTO> fetchStudentCourseData();

}

