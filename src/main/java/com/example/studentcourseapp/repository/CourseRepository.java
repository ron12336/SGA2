package com.example.studentcourseapp.repository;

import com.example.studentcourseapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}