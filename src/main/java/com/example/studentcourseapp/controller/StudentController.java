package com.example.studentcourseapp.controller;

import com.example.studentcourseapp.model.Student;
import com.example.studentcourseapp.model.Course;
import com.example.studentcourseapp.service.StudentService;
import com.example.studentcourseapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }


    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
    try {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    } catch (Exception e) {
        model.addAttribute("error", "Failed to save student. Reason: " + e.getMessage());
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }
    }
    

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }

    @GetMapping("/joined")
    public String showStudentCourseJoin(Model model) {
        model.addAttribute("joinedData", studentService.getStudentCourseData());
        return "student-course-join";
    }
}

