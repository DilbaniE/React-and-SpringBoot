package com.foodApp.foodapp.repository;

import com.foodApp.foodapp.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends CrudRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByDocument(String document);
}
