package com.example.ShopAndProductApi.ModelsAndEntities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "shops")
@Entity
public class ShopWithDistance extends Shop {
    @Column(name="Calculated_Distance")
    private double Calculated_Distance;
}
