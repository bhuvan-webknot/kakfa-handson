package com.bhuvan.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced  //To enable client side load balancing (Service registry)
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }
}
