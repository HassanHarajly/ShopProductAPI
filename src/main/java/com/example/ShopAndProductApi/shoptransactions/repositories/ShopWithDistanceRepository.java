package com.example.ShopAndProductApi.shoptransactions.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopWithDistanceRepository extends CrudRepository<com.example.ShopAndProductApi.ModelsAndEntities.ShopWithDistance, Integer> {

    @Query(
            value =
                    "SELECT top 20 *, Calculated_Distance = GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(SHOP_LATITUDE, SHOP_LONGITUDE, 4326)) / 1609.344 from shops ORDER BY Calculated_Distance ASC",
            nativeQuery = true)
    List<com.example.ShopAndProductApi.ModelsAndEntities.ShopWithDistance> getProximalShops(@Param("user_latitude") Double userlatitude, @Param("user_longitude") Double userlongitude);

}
