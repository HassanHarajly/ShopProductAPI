package com.example.ShopAndProductApi.ModelsAndEntities.ProductModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "shops")
@Entity
public class ProductWithDistance extends Product{
    double distance;
}
