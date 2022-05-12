package com.example.assignment15client.service;

import com.example.assignment15client.domain.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="${name}")
public interface CourseProxyService {
    @GetMapping("/courses")
    public List<Course> gets();
}

