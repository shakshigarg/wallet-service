package org.company.wallet.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String id;
    int balance;
    List<Transaction> transactions;

    public User(String id, int balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }

    public User(String name) {
        this.id = name;
        this.balance=0;
        this.transactions=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}
