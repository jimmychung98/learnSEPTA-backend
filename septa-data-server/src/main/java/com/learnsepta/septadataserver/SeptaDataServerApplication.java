package com.learnsepta.septadataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SeptaDataServerApplication {
    public static void main(String args[]) {
        SpringApplication.run(SeptaDataServerApplication.class);
    }
    
}


