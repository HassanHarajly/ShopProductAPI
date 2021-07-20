package com.example.ShopAndProductApi.ModelsAndEntities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@MappedSuperclass
@Setter
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String shop_name;
    private double SHOP_LATITUDE;
    private double SHOP_LONGITUDE;


    public Shop(String shop_name, double SHOP_LATITUDE, double SHOP_LONGITUDE) {
        this.shop_name = shop_name;
        this.SHOP_LATITUDE = SHOP_LATITUDE;
        this.SHOP_LONGITUDE = SHOP_LONGITUDE;
    }

}
