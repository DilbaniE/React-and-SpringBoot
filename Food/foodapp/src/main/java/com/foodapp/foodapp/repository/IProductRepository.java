package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByUuid(String uuid);
    Optional<ProductEntity> findByFantasyName(String fantasyName);

    Boolean existsByFantasyName(String fantasyName);
}
