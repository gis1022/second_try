package com.example.second_try.repository;

import com.example.second_try.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
    ClientEntity findByInn(String inn);
}
