package com.example.security.service;

import com.example.security.domain.Student;

import java.util.List;


public interface StudentService {
    public List<Student> findAll();
    public Student update(long id, Student student);
}