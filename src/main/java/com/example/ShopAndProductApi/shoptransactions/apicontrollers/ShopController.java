package com.example.ShopAndProductApi.shoptransactions.apicontrollers;

import com.example.ShopAndProductApi.ModelsAndEntities.GeoCacheResponse;
import com.example.ShopAndProductApi.ModelsAndEntities.GoogleMapsApiModels.MapsResponse;
import com.example.ShopAndProductApi.ModelsAndEntities.Shop;
import com.example.ShopAndProductApi.ModelsAndEntities.ShopWithDistance;
import com.example.ShopAndProductApi.ModelsAndEntities.shopWithoutDistance;
import com.example.ShopAndProductApi.shoptransactions.repositories.ShopRepository;
import com.example.ShopAndProductApi.shoptransactions.repositories.ShopWithDistanceRepository;
import com.example.ShopAndProductApi.shoptransactions.services.GeoCacheApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class ShopController {
    @Autowired
    GeoCacheApiService geoCacheApiService;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ShopWithDistanceRepository shopWithDistanceRepository;
    @PostMapping(path = "addNewShop")
    public void addNewShop(@RequestBody @NonNull Shop shop) {
        MapsResponse mapsResponse = geoCacheApiService.getApiResponse(shop.getShop_street_address()+'+'+shop.getShop_state()+'+'+shop.getShop_zip());
        shopRepository.insertshop(shop.getShop_name(),shop.getShop_street_address(),shop.getShop_zip(), "mi",83.11
                ,99.25);
    }

    @GetMapping(path = "getAllShops")
    public List<shopWithoutDistance> getAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping(path = "getShopByName")
    public List<Shop> getShopByName(@RequestParam String name) {
        return shopRepository.findByName(name);
    }

    @GetMapping(path = "getProximalShop")
    public List<ShopWithDistance> getProximalShops(@RequestParam double longitude, @RequestParam double latitude) {
        return shopWithDistanceRepository.getProximalShops(latitude,longitude);
    }
}
