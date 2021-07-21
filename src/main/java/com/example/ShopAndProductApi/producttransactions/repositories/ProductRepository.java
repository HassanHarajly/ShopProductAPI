package com.example.ShopAndProductApi.producttransactions.repositories;
import com.example.ShopAndProductApi.ModelsAndEntities.ProductModels.ProductWithoutDistance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<ProductWithoutDistance,Integer> {


}
