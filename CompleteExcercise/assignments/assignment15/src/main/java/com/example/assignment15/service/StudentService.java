package com.example.assignment15.service;

import com.example.assignment15.domain.Course;
import com.example.assignment15.domain.Student;
import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student update(long id, Student student);
}