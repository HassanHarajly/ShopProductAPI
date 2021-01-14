package com.example.ShopAndProductApi.shoptransactions.services;

import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.MapsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GeoCacheApiService {
    //todo add api key to a more secure place like github credentials.
    private String positionStackGeoCacheUrl="https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCCRGeNH19EK4lOvPQNucL4MP3Iolzsyxo"
            ;
    @Autowired
    RestTemplate restTemplate;

    public MapsResponse getApiResponse(String address)
    {
        String URL = positionStackGeoCacheUrl + "&address=" + address;
        MapsResponse data = restTemplate
                .getForObject(URL, MapsResponse.class);

        return data;
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
