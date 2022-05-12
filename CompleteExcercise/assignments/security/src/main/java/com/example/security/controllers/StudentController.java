package com.example.security.controllers;

import com.example.security.domain.Student;
import com.example.security.service.StudentService;
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
