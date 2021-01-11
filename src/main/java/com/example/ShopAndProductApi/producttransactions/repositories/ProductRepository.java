package com.example.ShopAndProductApi.producttransactions.repositories;

import com.example.ShopAndProductApi.ModelsAndEntities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {


    @Modifying
@Transactional
    @Query(value =
" INSERT INTO products(shop_id,product_name,product_quantity,product_barcode, product_price,latitude,longitude) VALUES ( ?1,?2, ?3, ?4,?5,?6,?7)",
    nativeQuery = true)
    void insertNewProduct(int shop_id,String product_name,int product_quantity,String product_barcode,double product_price,double latitude,double longitude);
    @Query(
            value =
                    "SELECT top 20 *,   distance = GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344 from products ORDER BY distance ASC",
            nativeQuery = true)
    List<Product> getProximalProduct(@Param("user_latitude") Double userlatitude, @Param("user_longitude") Double userlongitude);
    // todo this logic works on keywords such as "computer water" should implement some logic that if this query returns nothing to try and split it by spaces and make additional queries to get as close as possible result.
    @Query( value = "DECLARE @TestVariable AS VARCHAR(400) SET @TestVariable = :product_name SET @TestVariable = CONCAT('\"',@TestVariable,'\"') SELECT * FROM products AS FT_TBL INNER JOIN FREETEXTTABLE(products, product_name, @TestVariable) AS KEY_TBL ON FT_TBL.id = KEY_TBL.[KEY] WHERE KEY_TBL.RANK >= 10 ORDER BY KEY_TBL.RANK DESC "

            , nativeQuery = true)
    List<Product> findByName(@Param("product_name") String product_name);

    @Query(value= " DECLARE @ProductName AS VARCHAR(400) SET @ProductName = :product_name SET @ProductName = CONCAT('\"',@ProductName,'\"') SELECT top 100 * FROM( SELECT *, distance = (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) FROM products WHERE (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) < :distance_limit) AS FT_TBL INNER JOIN FREETEXTTABLE(products, product_name, @ProductName) AS KEY_TBL ON FT_TBL.id = KEY_TBL.[key] WHERE KEY_TBL.RANK >= 10 ORDER BY KEY_TBL.RANK ASC ,distance ASC"
            ,nativeQuery = true)
    List<Product> findByNameAndProximity(@Param("product_name") String product_name,@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude,@Param("distance_limit") Double distance_limit);

}
