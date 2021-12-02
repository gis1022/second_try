package com.example.second_try.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String place;
    private @Getter @Setter Double amount;
    private @Getter @Setter String currency;
    private @Getter @Setter String card;
   // @OneToMany
    private @Getter @Setter String inn;
//    @ManyToOne(targetEntity = ClientEntity.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "client_entity")
//    private ClientEntity clientEntity;


    public TransactionEntity() {
    }

    public TransactionEntity(String place, Double amount, String currency, String card, String inn) {
        this.place = place;
        this.amount = amount;
        this.currency = currency;
        this.card = card;
        this.inn = inn;
    }
}
