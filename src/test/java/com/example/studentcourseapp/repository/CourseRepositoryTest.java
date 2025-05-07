package com.example.studentcourseapp.repository;

import com.example.studentcourseapp.model.Course;
import com.example.studentcourseapp.repository.CourseRepository;
import com.example.studentcourseapp.config.DataLoader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@Import(DataLoader.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFindAllCourses() {
        List<Course> courses = courseRepository.findAll();
        assertThat(courses).isNotNull();
        assertThat(courses.size()).isGreaterThanOrEqualTo(10);
    }
}