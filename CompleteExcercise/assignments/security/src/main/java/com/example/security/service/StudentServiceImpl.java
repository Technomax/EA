package com.example.security.service;

import com.example.security.domain.Student;
import com.example.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements  StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> students= studentRepository.findAll();
        return students;
    }

    @Override
    public Student update(long id, Student student) {
        Student entity=studentRepository.getById(id);
        entity.setGender(student.getGender());
        entity.setName(student.getName());
        return studentRepository.save(entity);
    }
}
