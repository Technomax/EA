package com.example.security.service;

import com.example.security.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();

    public Course update(long id, Course course);
}
