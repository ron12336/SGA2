package com.example.studentcourseapp.service;

import com.example.studentcourseapp.model.Student;
import com.example.studentcourseapp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private final StudentRepository mockRepo = mock(StudentRepository.class);
    private final StudentService studentService = new StudentServiceImpl(mockRepo);

    @Test
    public void testGetAllStudents() {
        List<Student> mockStudents = Arrays.asList(
            new Student("Ali", null),
            new Student("Fatima", null)
        );

        when(mockRepo.findAll()).thenReturn(mockStudents);

        List<Student> result = studentService.getAllStudents();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Ali");

        verify(mockRepo, times(1)).findAll();
    }
}