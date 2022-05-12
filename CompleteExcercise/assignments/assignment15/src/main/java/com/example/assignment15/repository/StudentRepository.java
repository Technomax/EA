package com.example.assignment15.repository;

import com.example.assignment15.domain.Course;
import com.example.assignment15.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
