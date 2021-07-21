package com.example.ShopAndProductApi.producttransactions.apicontrollers;

import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.Product;
import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.ProductWithDistance;
import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.ProductWithoutDistance;
import com.example.ShopAndProductApi.producttransactions.repositories.ProductRepository;
import com.example.ShopAndProductApi.producttransactions.repositories.ProductWithDistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductWithDistanceRepository productWithDistanceRepository;
    @GetMapping("getAllProducts")
    Iterable<ProductWithoutDistance> getAllProducts() {
        return productRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("addNewProduct")
    public void insertNewProduct(@RequestBody @NonNull ProductWithoutDistance product) {
        productRepository.save(product);
    }

    @GetMapping("getProductByNameAndProximity")
    List<ProductWithDistance> getAllSimilarProducts(@RequestParam String name, @RequestParam double longitude, @RequestParam double latitude, @RequestParam double distance_limit ) {
        return productWithDistanceRepository.findByNameAndProximity(name,latitude,longitude,distance_limit);
    }

    @GetMapping(path = "getProximalProduct")
    public List<ProductWithDistance> getProximalShops(@RequestParam double longitude, @RequestParam double latitude) {
        return productWithDistanceRepository.getProximalProduct(latitude,longitude);
    }
}
