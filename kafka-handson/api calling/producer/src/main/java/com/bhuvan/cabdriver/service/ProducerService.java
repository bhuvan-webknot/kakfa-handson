package com.bhuvan.cabdriver.service;

import com.bhuvan.cabdriver.constants.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String,Object>kafkaTemplate;

    @Autowired
    private StreamingService streamingService;
    public void updateContent() {
        streamingService.streamData().forEach(data -> {
            try {
                kafkaTemplate.send(AppConstant.WIKIMEDIA, data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

