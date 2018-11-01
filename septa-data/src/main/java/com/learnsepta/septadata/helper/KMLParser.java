package com.learnsepta.septadata.helper;

import java.util.ArrayList;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class KMLParser {
    private Document doc;
    private ArrayList<String> coordinates;
    private double totalDistance;

    public KMLParser(String kml_website) {
        try {           
            System.out.println("----------------------------");
            URL url = new URL(kml_website);
            System.out.println("Initializing Coordinates for: " + url.toString());
            //Resource resource = new ClassPathResource(file_name);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder  dBuilder = dbFactory.newDocumentBuilder();
            //doc = dBuilder.parse(resource.getFile());
            doc = dBuilder.parse(url.openStream());
            doc.getDocumentElement().normalize();

            totalDistance = 0;

            initCoordinates();
            calculateTotalDistance();
            
            System.out.println("----------------------------");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void initCoordinates() {
        NodeList lineStrings = doc.getElementsByTagName("LineString");
        Node lineString;
        coordinates = new ArrayList<String>();

        for (int index = 0; index < lineStrings.getLength(); index++) {
            lineString = lineStrings.item(index);

            if (lineString.getNodeType() == Node.ELEMENT_NODE) {
                Element coordWrapper = (Element) lineString;
                Node coord = coordWrapper.getElementsByTagName("coordinates").item(0).getLastChild();
                coord.normalize();

                coordinates.add(coord.getNodeValue());
            }
        }
    }

    private void calculateTotalDistance() {
        String[] coords_set;
        String[] coords_one_str;
        double[] coords_one = new double[3];
        String[] coords_two_str;
        double[] coords_two = new double[3];
        for (int x = 0; x < coordinates.size(); x++) {
            coords_set = coordinates.get(x).split("\\s+");
            for (int y = 1; y < coords_set.length - 1; y++) {
                coords_one_str = coords_set[y].split(",");
                coords_two_str= coords_set[y+1].split(",");
                for (int index = 0; index < coords_one_str.length; index++) {
                    coords_one[index] = Double.parseDouble(coords_one_str[index]);
                    coords_two[index] = Double.parseDouble(coords_two_str[index]);
                }

                distance(coords_one[1], coords_two[1], coords_one[0], coords_two[0], coords_one[2], coords_two[2]);
            }
        }

        System.out.println("Total Distance: " + this.totalDistance + " miles");
    }

    private final int RADIUS = 6371;

    public void distance(double lat1, double lat2, double lng1,
        double lng2, double el1, double el2) {

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lng2 - lng1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        // Convert to Miles
        double distance = RADIUS * c * 1000 * 0.000621371; 

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        totalDistance += Math.sqrt(distance);
    }

    public double returnTotalDistance() {
        return totalDistance;
    }
}