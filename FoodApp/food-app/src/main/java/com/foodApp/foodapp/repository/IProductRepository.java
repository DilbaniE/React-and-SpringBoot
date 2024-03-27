package com.foodApp.foodapp.repository;

import com.foodApp.foodapp.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByUuid(UUID uuid);
    Optional<ProductEntity> findByProductName(String productName);
    Boolean existsByProductName(String productName);

}
