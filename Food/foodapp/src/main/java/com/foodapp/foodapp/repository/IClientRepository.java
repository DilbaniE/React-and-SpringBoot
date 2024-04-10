package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends CrudRepository<ClientEntity, Integer> {
    // queris busquedas espesificas
    Optional<ClientEntity> findByDocument(String document);
}
