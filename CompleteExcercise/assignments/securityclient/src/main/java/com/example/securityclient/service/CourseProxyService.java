package com.example.securityclient.service;

import com.example.securityclient.domain.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="${server-service.service-name}")
public interface CourseProxyService {
    @GetMapping("/courses")
    public List<Course> gets();
}

