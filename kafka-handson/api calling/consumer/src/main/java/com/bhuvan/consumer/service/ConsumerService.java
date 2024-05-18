package com.bhuvan.consumer.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "wikimedia", groupId = "my-group")
    public void listen(String content){
        System.out.println("Content : "+ content);
        System.out.println("\n\n");
    }
}
