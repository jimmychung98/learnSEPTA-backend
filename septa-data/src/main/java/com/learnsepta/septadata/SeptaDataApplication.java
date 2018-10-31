package com.learnsepta.septadata;

import com.learnsepta.septadata.helper.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SeptaDataApplication {
    public static void main(String args[]) {
        SpringApplication.run(SeptaDataApplication.class);


        KMLParser kml = new KMLParser("busRoutes/17.kml");
    }
    
}


