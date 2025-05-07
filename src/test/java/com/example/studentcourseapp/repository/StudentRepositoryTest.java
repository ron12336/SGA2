package com.example.studentcourseapp.repository;

import com.example.studentcourseapp.config.DataLoader;
import com.example.studentcourseapp.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DataLoader.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindAll() {
        List<Student> students = studentRepository.findAll();
        assertThat(students).isNotNull();
        assertThat(students.size()).isGreaterThanOrEqualTo(10);
    }
}