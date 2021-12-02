package com.example.second_try.repository;

import com.example.second_try.entity.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionEntity, Long> {
//    @Query("SELECT * FROM TRANSACTION_ENTITY , CLIENT_ENTITY WHERE TRANSACTION_ENTITY.INN =CLIENT_ENTITY.INN")

}
