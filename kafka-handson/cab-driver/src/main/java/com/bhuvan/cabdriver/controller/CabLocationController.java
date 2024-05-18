package com.bhuvan.cabdriver.controller;


import com.bhuvan.cabdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cablocation")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;


    //BUSINESS LOGIC call service

    @SuppressWarnings("rawtypes")
    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {
        int range = 100;
        while(range > 0){
            cabLocationService.updateLocation(Math.random()+" , "+ Math.random());
            Thread.sleep(1000);
            range--;
        }
        return new ResponseEntity<>(Map.of("message", "Location updated successfully"), HttpStatus.OK);
    }
}
