package com.example.ShopAndProductApi.shoptransactions.repositories;


import com.example.ShopAndProductApi.ModelsAndEntities.Shop;
import com.example.ShopAndProductApi.ModelsAndEntities.ShopWithDistance;
import com.example.ShopAndProductApi.ModelsAndEntities.shopWithoutDistance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<shopWithoutDistance, Integer> {


    @Query(
            value = "SELECT * FROM shops WHERE shop_name = ?1",
            nativeQuery = true)
    List<shopWithoutDistance> findByName(String shop_name);
}
