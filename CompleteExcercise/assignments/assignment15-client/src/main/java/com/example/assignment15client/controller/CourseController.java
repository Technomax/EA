package com.example.assignment15client.controller;

import com.example.assignment15client.domain.Course;
import com.example.assignment15client.service.CourseProxyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseProxyService courseProxyService;

    @GetMapping("/courses")
    @CircuitBreaker(name="circuit_breaker",fallbackMethod = "myFallBackMethod")
    public List<Course> gets() {
       return courseProxyService.gets();
    }

    public List<Course> myFallBackMethod(Exception ex){
        System.out.println("I am inside fallback");
        return null;
    }
}
