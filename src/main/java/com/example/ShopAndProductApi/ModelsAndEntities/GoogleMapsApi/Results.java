package com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("results")
public class Results {
    public String formatted_address;
    public Geometry geometry;
    public String place_id;
    public List<String> types;
}
