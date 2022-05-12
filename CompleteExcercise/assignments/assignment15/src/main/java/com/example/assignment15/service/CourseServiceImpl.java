package com.example.assignment15.service;

import com.example.assignment15.domain.Course;
import com.example.assignment15.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements  CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course update(long id, Course course) {
        Course entity=courseRepository.getById(id);
        entity.setCourseCode(course.getCourseCode());
        entity.setCourseName(course.getCourseName());
        return courseRepository.save(entity);
    }
}
