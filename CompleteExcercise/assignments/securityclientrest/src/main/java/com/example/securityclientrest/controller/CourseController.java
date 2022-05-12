package com.example.securityclientrest.controller;

import com.example.securityclientrest.domain.Course;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${server-service.service-name}")
    private String serverServiceName;

    @Value("${server-service.username}")
    private String username;

    @Value("${geography-service.password}")
    private String password;

    private List<Course> countryListCache = new ArrayList<>();

    private RestTemplate restTemplate= new RestTemplate();

    @GetMapping("/courses")
    @CircuitBreaker(name="circuit_breaker",fallbackMethod = "myFallBackMethod")
    public List<Course> gets() {
        String url = lookupUrlFor(serverServiceName) + "/courses";
        countryListCache = Arrays.asList(restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), Course[].class).getBody());
        return countryListCache;
    }

    public List<Course> myFallBackMethod(Exception ex){
        System.out.println("I am inside fallback");
        return countryListCache;
    }

    private HttpEntity<Object> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth(username, password);
        return new HttpEntity<>(headers);
    }

    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
}
