package com.example.securityeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SecurityeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityeurekaApplication.class, args);
    }

}
