package com.example.ShopAndProductApi.producttransactions.apicontrollers;

import com.example.ShopAndProductApi.ModelsAndEntities.Product;
import com.example.ShopAndProductApi.producttransactions.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("getAllProducts")
    List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(shop -> {
            products.add(shop);
        });
        return products;
    }

    @PostMapping("addNewProduct")
    public void insertNewProduct(@RequestBody @NonNull Product Product) {
        productRepository.save(Product);
    }

    @GetMapping("getProductByNameAndProximity")
    List<Product> getAllSimilarProducts(@RequestParam String name,@RequestParam double longitude, @RequestParam double latitude,@RequestParam double distance_limit ) {
        return productRepository.findByNameAndProximity(name,latitude,longitude,distance_limit);
    }

    @GetMapping(path = "getProximalProduct")
    public List<Product> getProximalShops(@RequestParam double longitude, @RequestParam double latitude) {
        return productRepository.getProximalProduct(latitude,longitude);
    }
}
