package com.example.ShopAndProductApi.shoptransactions.services;

import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.Geometry;
import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.Location;
import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.MapsResponse;
import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.Results;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeoCacheApiServiceTest {
    @InjectMocks
    GeoCacheApiService geoCacheApiService = new GeoCacheApiService();
    @Test
    void getApiResponse() {
        geoCacheApiService.restTemplate =Mockito.mock(RestTemplate.class);
        MapsResponse mapsResponse = new MapsResponse();
        List<Results> temp = new ArrayList<>();
        temp.add(new Results());
        mapsResponse.setResults(temp);
        mapsResponse.getResults().get(0).setGeometry(new Geometry());
        mapsResponse.getResults().get(0).getGeometry().setLocation(new Location());
        mapsResponse.getResults().get(0).getGeometry().getLocation().setLat(37.4215301);
        mapsResponse.getResults().get(0).getGeometry().getLocation().setLng(-91.4215301);
        Mockito
                .when(geoCacheApiService.restTemplate.getForObject(
                        "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCCRGeNH19EK4lOvPQNucL4MP3Iolzsyxo&address=1600+Amphitheatre+Parkway,+Mountain+View,+CA", MapsResponse.class))
          .thenReturn(mapsResponse);

        assertEquals(geoCacheApiService.getApiResponse("1600+Amphitheatre+Parkway,+Mountain+View,+CA").getResults().get(0).getGeometry().getLocation().getLat()
                ,37.4215301);
        assertEquals(geoCacheApiService.getApiResponse("1600+Amphitheatre+Parkway,+Mountain+View,+CA").getResults().get(0).getGeometry().getLocation().getLng()
                ,-91.4215301);
    }

}
