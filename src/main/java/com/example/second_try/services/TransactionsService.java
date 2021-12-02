package com.example.second_try.services;

import com.example.second_try.SaxMyParser;
import com.example.second_try.entity.ClientEntity;
import com.example.second_try.entity.TransactionEntity;
import com.example.second_try.repository.ClientRepo;
import com.example.second_try.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionsService {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    TransactionRepo transactionRepo;

    public Boolean addTransactions(ArrayList<TransactionEntity> list,ArrayList<ClientEntity> set){

        try {
            list.forEach(x->transactionRepo.save(x));
            for (ClientEntity entity:set){
                if (clientRepo.findByInn(entity.getInn()) == null){
                    clientRepo.save(entity);
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

}


