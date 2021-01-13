package com.example.ShopAndProductApi.ModelsAndEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCacheResponse {

    @JsonProperty("results")
    private List<GeoCacheResponseData> geoCacheResponseData;

    public void setData(List<GeoCacheResponseData> data){
        this.geoCacheResponseData = data;
    }
    public List<GeoCacheResponseData> getData(){
        return this.geoCacheResponseData;
    }

}
