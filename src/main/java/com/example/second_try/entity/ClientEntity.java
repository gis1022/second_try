package com.example.second_try.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long client_id;
   // @ManyToOne
    private @Getter @Setter String inn;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String middleName;
//    @OneToMany(mappedBy = "client")
//    private ArrayList<TransactionEntity> transactionList;

        /*
         * Конструктор
         */
    public ClientEntity() {
    }


    public ClientEntity(String firstName, String lastName, String middleName, String inn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.inn = inn;
    }
}
