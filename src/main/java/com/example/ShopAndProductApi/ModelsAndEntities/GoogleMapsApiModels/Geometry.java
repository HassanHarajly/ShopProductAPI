package com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Geometry{
    public Location location;
    public String location_type;
}
