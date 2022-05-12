package com.example.assignment15.service;

import com.example.assignment15.domain.Course;
import java.util.List;

public interface CourseService {
    public List<Course> findAll();

    public Course update(long id, Course course);
}
