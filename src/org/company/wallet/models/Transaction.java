package org.company.wallet.models;

import java.time.LocalDateTime;

public class Transaction {
    TransactionType transactionType;
    String id;
    LocalDateTime date;
    int amount;

    public Transaction(TransactionType transactionType, String id, int amount) {
        this.transactionType = transactionType;
        this.id = id;
        this.date = LocalDateTime.now();
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
