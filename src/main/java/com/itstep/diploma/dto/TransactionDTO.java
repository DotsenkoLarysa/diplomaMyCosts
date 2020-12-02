package com.itstep.diploma.dto;

public class TransactionDTO {

    private int transaction_id;
    private String name_transaction;

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
}
