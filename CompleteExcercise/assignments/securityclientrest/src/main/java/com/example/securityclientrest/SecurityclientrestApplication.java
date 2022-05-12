package com.example.securityclientrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecurityclientrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityclientrestApplication.class, args);
    }

}
