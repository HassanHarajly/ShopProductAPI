package com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApi;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class MapsResponse {
    List<Results> Results;
}
