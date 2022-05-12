package com.example.security.controllers;

import com.example.security.domain.Course;
import com.example.security.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> gets() {
        return courseService.findAll();
    }

    @PutMapping("/courses/{id}")
    public Course update(@PathVariable long id, @RequestBody Course bodyContent) {
        return courseService.update(id,bodyContent);
    }
}
