package com.learnsepta.septadata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus {
    private String lat;
    private String lng;
    private String label;
    private String trip;
    @JsonProperty("VehicleID")
    private String VehicleID;
    @JsonProperty("BlockID")
    private String BlockID;
    private String late;
    private String destination;
}
