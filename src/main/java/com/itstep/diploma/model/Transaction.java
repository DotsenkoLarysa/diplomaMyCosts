package com.itstep.diploma.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transaction",schema="mycosts")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;

    @Column(name = "name_transaction")
    private String name_transaction;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event_id")
    @JsonManagedReference
    private Set<Journal> journals;

    public Transaction() {
    }

    public Transaction(int transaction_id, String name_transaction, Set<Journal> journals) {
        this.transaction_id = transaction_id;
        this.name_transaction = name_transaction;
        this.journals = journals;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getName_transaction() {
        return name_transaction;
    }

    public void setName_transaction(String name_transaction) {
        this.name_transaction = name_transaction;
    }

    public Set<Journal> getJournals() { return journals; }

    public void setJournals(Set<Journal> journals) { this.journals = journals; }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", name_transaction='" + name_transaction + '\'' +
                ", journals=" + journals +
                '}';
    }
}
