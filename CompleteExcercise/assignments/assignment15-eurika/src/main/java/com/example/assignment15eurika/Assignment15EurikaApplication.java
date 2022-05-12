package com.example.assignment15eurika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Assignment15EurikaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment15EurikaApplication.class, args);
    }

}
