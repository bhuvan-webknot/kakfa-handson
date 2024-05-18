package com.bhuvan.cabdriver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Stream;

@Service
public class StreamingService {
    public WebClient webClient;
    public StreamingService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        }

    public Stream<String> streamData() {
        return webClient.get().uri("/stream/recentchange").retrieve().bodyToFlux(String.class).toStream();
    }
}
