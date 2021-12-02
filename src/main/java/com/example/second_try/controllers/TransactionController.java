package com.example.second_try.controllers;

import com.example.second_try.entity.ClientEntity;
import com.example.second_try.entity.TransactionEntity;
import com.example.second_try.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class TransactionController {

    private static ArrayList<TransactionEntity> list;
    private static ArrayList<ClientEntity> clientEntitySet;

    @Qualifier("transactionsService")
    @Autowired
    private TransactionsService clientService;

    @GetMapping("/")
    public ResponseEntity readXml(){
        if (clientService.addTransactions(list,clientEntitySet)){
        return ResponseEntity.ok("READ COMPLITE");}
        else return ResponseEntity.ok("ERROR");
    }

    public void setList(ArrayList<TransactionEntity> list, ArrayList<ClientEntity> set) {
        this.list = (ArrayList<TransactionEntity>) list.clone();
        this.clientEntitySet = (ArrayList<ClientEntity>)set.clone();
    }
}
