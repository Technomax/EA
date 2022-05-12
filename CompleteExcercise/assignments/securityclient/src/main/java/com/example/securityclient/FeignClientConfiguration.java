package com.example.securityclient;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Value("${server-service.service-name}")
    private String serverServiceName;

    @Value("${server-service.username}")
    private String username;

    @Value("${geography-service.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
