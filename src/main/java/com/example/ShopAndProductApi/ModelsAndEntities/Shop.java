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
    private double shop_latitude;
    private double shop_longitude;



}
