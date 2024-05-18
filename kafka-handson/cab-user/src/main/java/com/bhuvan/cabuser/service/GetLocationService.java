package com.bhuvan.cabuser.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GetLocationService {

    @KafkaListener(topics = "cab-location", groupId = "my-group")
    public void cabLocation(String location){
        System.out.println("Cab is at location"+ location );
    }
}
