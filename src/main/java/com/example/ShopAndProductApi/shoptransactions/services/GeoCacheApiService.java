package com.example.ShopAndProductApi.shoptransactions.services;

import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.MapsResponse;
import org.springframework.web.client.RestTemplate;

public class GeoCacheApiService {
    //todo add api key to a more secure place like github credentials.
    private String positionStackGeoCacheUrl="https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCCRGeNH19EK4lOvPQNucL4MP3Iolzsyxo"
            ;
    RestTemplate restTemplate = new RestTemplate();

    public MapsResponse getApiResponse(String address)
    {
        String URL = positionStackGeoCacheUrl + "&address=" + address;
        MapsResponse data = restTemplate
                .getForObject(URL, MapsResponse.class);

        return data;
    }
}
