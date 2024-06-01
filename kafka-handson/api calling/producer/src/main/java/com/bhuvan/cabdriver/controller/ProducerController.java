package com.bhuvan.cabdriver.controller;


import com.bhuvan.cabdriver.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {
    @Autowired
    public ProducerService producerService;

    //BUSINESS LOGIC call service

    @PutMapping
    public ResponseEntity<String> updateContent(){
        producerService.updateContent();
        return new ResponseEntity<>("Location updated successfully", HttpStatus.OK);
    }
}

