package com.example.studentcourseapp.service;

import com.example.studentcourseapp.model.Course;
import com.example.studentcourseapp.repository.CourseRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseRepository courseRepository;
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        courseService = new CourseServiceImpl(courseRepository);
    }

    @Test
    void testSaveCourse() {
        Course course = new Course("Physics", "Advanced physics course");
        courseService.saveCourse(course);

        ArgumentCaptor<Course> captor = ArgumentCaptor.forClass(Course.class);
        verify(courseRepository).save(captor.capture());

        Course saved = captor.getValue();
        assertEquals("Physics", saved.getTitle());
    }

    @Test
    void testGetAllCourses() {
        Course c1 = new Course("Math", "Algebra and Geometry");
        Course c2 = new Course("Biology", "Cell and Genetic Studies");

        when(courseRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Course> result = courseService.getAllCourses();
        assertEquals(2, result.size());
        assertEquals("Math", result.get(0).getTitle());
    }

    @Test
    void testGetCourseById() {
        Course course = new Course("Chemistry", "Organic and Inorganic");
        course.setId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        
        Optional<Course> optionalCourse = courseService.getCourseById(1L);
        assertTrue(optionalCourse.isPresent(), "Course should be found");
        Course found = optionalCourse.get();
        assertNotNull(found);
        assertEquals("Chemistry", found.getTitle());
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course("Old Title", "Old Desc");
        course.setId(2L);

        when(courseRepository.save(course)).thenReturn(course);

        course.setTitle("New Title");
        course.setDescription("New Description");

        courseService.saveCourse(course);
        verify(courseRepository).save(course);
        assertEquals("New Title", course.getTitle());
    }
}