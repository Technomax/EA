package com.example.assignment15.controllers;

import com.example.assignment15.domain.Course;
import com.example.assignment15.domain.Student;
import com.example.assignment15.service.CourseService;
import com.example.assignment15.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> gets() {
        return studentService.findAll();
    }

    @PutMapping("/students/{id}")
    public Student update(@PathVariable long id,@RequestBody Student bodyContent) {
        return studentService.update(id,bodyContent);
    }
}
