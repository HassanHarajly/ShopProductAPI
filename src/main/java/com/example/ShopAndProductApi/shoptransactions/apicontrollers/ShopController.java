package com.example.ShopAndProductApi.shoptransactions.apicontrollers;
import com.example.ShopAndProductApi.ModelsAndEntities.ShopWithDistance;
import com.example.ShopAndProductApi.ModelsAndEntities.shopWithoutDistance;
import com.example.ShopAndProductApi.shoptransactions.repositories.ShopRepository;
import com.example.ShopAndProductApi.shoptransactions.repositories.ShopWithDistanceRepository;
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
    ShopRepository shopRepository;
    @Autowired
    ShopWithDistanceRepository shopWithDistanceRepository;
    @PostMapping(path = "addNewShop")
    public void addNewShop(@RequestBody @NonNull shopWithoutDistance shop) {
        shopRepository.save(shop);
    }

    @GetMapping(path = "getAllShops")
    public List<shopWithoutDistance> getAllShops() {
        return (List<shopWithoutDistance>) shopRepository.findAll();
    }

    @GetMapping(path = "getShopByName")
    public List<shopWithoutDistance> getShopByName(@RequestParam String name) {
        return shopRepository.findByName(name);
    }

    @GetMapping(path = "getProximalShop")
    public List<ShopWithDistance> getProximalShops(@RequestParam double longitude, @RequestParam double latitude) {
        return shopWithDistanceRepository.getProximalShops(latitude,longitude);
    }
}
