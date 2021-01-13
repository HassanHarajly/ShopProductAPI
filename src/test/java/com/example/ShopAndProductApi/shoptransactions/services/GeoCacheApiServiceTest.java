package com.example.ShopAndProductApi.shoptransactions.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoCacheApiServiceTest {


    GeoCacheApiService geoCacheApiService = new GeoCacheApiService();
    @Test
    void getApiResponse() {
        assertEquals(geoCacheApiService.getApiResponse("1600+Amphitheatre+Parkway,+Mountain+View,+CA").getResults().get(0).getGeometry().getLocation().getLat()
                ,37.4215301);
        assertEquals(geoCacheApiService.getApiResponse("1600+Amphitheatre+Parkway,+Mountain+View,+CA").getResults().get(0).getGeometry().getLocation().getLat()
                ,37.4215301);
    }
}
