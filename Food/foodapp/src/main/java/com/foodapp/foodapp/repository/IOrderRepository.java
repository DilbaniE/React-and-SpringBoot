package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface IOrderRepository extends CrudRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findByUuid(UUID uuid);
}
