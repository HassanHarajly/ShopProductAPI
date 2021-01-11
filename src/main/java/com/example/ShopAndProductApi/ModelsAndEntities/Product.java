package com.example.ShopAndProductApi.ModelsAndEntities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    double distance;
}
