package com.example.securityclient.controller;

import com.example.securityclient.domain.Course;
import com.example.securityclient.service.CourseProxyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseProxyService courseProxyService;

    @Value("${server-service.service-name}")
    private String serverServiceName;

    @Value("${server-service.username}")
    private String username;

    @Value("${geography-service.password}")
    private String password;

    private List<Course> countryListCache = new ArrayList<>();

    @GetMapping("/courses")
    @CircuitBreaker(name="circuit_breaker",fallbackMethod = "myFallBackMethod")
    public List<Course> gets() {
       return courseProxyService.gets();
    }

    public List<Course> myFallBackMethod(Exception ex){
        System.out.println("I am inside fallback");
        return countryListCache;
    }


}
