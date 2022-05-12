package com.example.assignment15clientrest.controller;

import com.example.assignment15clientrest.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    private RestTemplate restTemplate= new RestTemplate();

    @GetMapping("/courses")
    public List<Course> gets() {
       Course[] courses= restTemplate.getForObject("${url}/courses", Course[].class);
       return Arrays.asList(courses);
    }
}
