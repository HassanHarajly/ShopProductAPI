package com.example.ShopAndProductApi.producttransactions.repositories;

import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.Product;
import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.ProductWithDistance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductWithDistanceRepository extends CrudRepository<ProductWithDistance,Integer> {

    @Query(
            value =
                    "SELECT top 20 *,   distance = GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344 from products ORDER BY distance ASC",
            nativeQuery = true)
    List<ProductWithDistance> getProximalProduct(@Param("user_latitude") Double userlatitude, @Param("user_longitude") Double userlongitude);
    @Query(value= " DECLARE @ProductName AS VARCHAR(400) SET @ProductName = :product_name SET @ProductName = CONCAT('\"',@ProductName,'\"') SELECT top 100 * FROM( SELECT *, distance = (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) FROM products WHERE (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) < :distance_limit) AS FT_TBL INNER JOIN FREETEXTTABLE(products, product_name, @ProductName) AS KEY_TBL ON FT_TBL.id = KEY_TBL.[key] WHERE KEY_TBL.RANK >= 10 ORDER BY KEY_TBL.RANK ASC ,distance ASC"
            ,nativeQuery = true)
    List<ProductWithDistance> findByNameAndProximity(@Param("product_name") String product_name,@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude,@Param("distance_limit") Double distance_limit);

}
