package com.learnsepta.septadata.scheduler;

import com.learnsepta.septadata.model.*;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BusScheduler {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static BusTransit bustransit;

    // Need to Loop through all bus transits and store into database
    // There are 77 buses
    @Scheduled(fixedRate = 10000)
    public void getBusObject() {
        bustransit = restTemplate.getForObject(
                "http://www3.septa.org/hackathon/TransitView/17", BusTransit.class);
        
        System.out.println(bustransit.toString());
    }
}