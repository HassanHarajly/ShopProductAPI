package com.example.ShopAndProductApi.shoptransactions.apicontrollers;

import com.example.ShopAndProductApi.entities.Shop;
import com.example.ShopAndProductApi.shoptransactions.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api/v1/")
@RestController
public class ShopController {
    @Autowired
    ShopRepository shopRepository;
    @PostMapping(path = "addNewShop")
    public void addNewShop(@RequestBody @NonNull Shop shop) {
        shopRepository.insertshop(shop.getShop_name(),shop.getShop_street_address(),shop.getShop_zip(),shop.getShop_state(),shop.getSHOP_LATITUDE(),shop.getSHOP_LONGITUDE());
    }

    @GetMapping(path = "getAllShops")
    public List<Shop> getAllShops() {
        final List<Shop> shops = new ArrayList<>();
        shopRepository.findAll().forEach(Shop -> shops.add(Shop));
        return shops;
    }

    @GetMapping(path = "getShopByName")
    public List<Shop> getShopByName(@RequestParam String name) {
        return shopRepository.findByName(name);
    }

    @GetMapping(path = "getProximalShop")
    public List<Shop> getProximalShops(@RequestParam double longitude,@RequestParam double latitude) {
        return shopRepository.getProximalShops(latitude,longitude);
    }
}
