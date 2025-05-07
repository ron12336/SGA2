package com.example.studentcourseapp.service;

import com.example.studentcourseapp.model.Course;
import com.example.studentcourseapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
}@Override
public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
}

@Override
public boolean existsCourseById(Long id) {
    return courseRepository.existsById(id);
}