package com.PayToPay.application.entity;

import java.io.Serializable;
import java.util.List;

/**
 * The type Bank.
 */
public class PaySystem implements Serializable {
    /**
     * The Transactions.
     */
    List<Transaction> transactions;

    /**
     * Instantiates a new Bank.
     *
     * @param transactions the transactions
     */
    public PaySystem(List<Transaction> transactions){
        this.transactions = transactions;
    }
}
