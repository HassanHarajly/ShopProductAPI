package com.example.ShopAndProductApi.ModelsAndEntities.ProductModels;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@MappedSuperclass
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    int shop_id;
    String product_name;
    int product_quantity;
    String product_barcode;
    double product_price;
    double latitude;
    double longitude;
    String image;
}
