package com.example.studentcourseapp.config;

import com.example.studentcourseapp.model.Course;
import com.example.studentcourseapp.model.Student;
import com.example.studentcourseapp.repository.CourseRepository;
import com.example.studentcourseapp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(CourseRepository courseRepo, StudentRepository studentRepo) {
        return args -> {

            if (courseRepo.count() == 0) {
                List<Course> courses = new ArrayList<>();
                courses.add(new Course("Mathematics", "Study of numbers"));
                courses.add(new Course("Physics", "Study of matter and energy"));
                courses.add(new Course("Chemistry", "Study of substances"));
                courses.add(new Course("Biology", "Study of living things"));
                courses.add(new Course("Computer Science", "Study of computation"));
                courses.add(new Course("History", "Study of past events"));
                courses.add(new Course("Geography", "Study of Earth"));
                courses.add(new Course("Economics", "Study of markets"));
                courses.add(new Course("Psychology", "Study of the mind"));
                courses.add(new Course("Sociology", "Study of society"));

                courseRepo.saveAll(courses);
            }

       

            if (studentRepo.count() == 0) {
                List<Course> allCourses = courseRepo.findAll();

                String[] names = {
                    "Ali", "Fatima", "Ahmed", "Zainab", "Hassan",
                    "Ayesha", "Bilal", "Mariam", "Usman", "Noor"
                };

                for (int i = 0; i < names.length; i++) {
                    Student student = new Student();
                    student.setName(names[i]);

                    // Assign 2 random courses
                    Collections.shuffle(allCourses);
                    Set<Course> enrolled = new HashSet<>(allCourses.subList(0, 2));
                    student.setCourses(enrolled);

                    studentRepo.save(student);
                }
            }
        };
    }
}