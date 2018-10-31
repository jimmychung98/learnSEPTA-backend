package com.learnsepta.septadata.helper;

import java.io.*;

import org.springframework.core.io.*;

public class KMLParser {
    public KMLParser(String file_name) {
        try {
            Resource resource = new ClassPathResource(file_name);
            InputStream resourceInputStream = resource.getInputStream();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
}