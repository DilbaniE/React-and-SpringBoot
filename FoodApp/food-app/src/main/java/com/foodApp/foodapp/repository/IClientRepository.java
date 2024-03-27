package com.foodApp.foodapp.repository;

import com.foodApp.foodapp.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends CrudRepository<ClientEntity, Integer > {
    // para hacer en espesifico
    Optional<ClientEntity> findByDocument(String document);

}
