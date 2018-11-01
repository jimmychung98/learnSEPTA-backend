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

        // http://www3.septa.org/transitview/kml/17.kml
        //KMLParser kml = new KMLParser("busRoutes/17.kml");
        //KMLParser kml = new KMLParser("http://www3.septa.org/transitview/kml/17.kml");
        for (int index = 1; index < 10; index++) {
            KMLParser kml = new KMLParser("http://www3.septa.org/transitview/kml/" + index + ".kml");
        }
    }
    
}


