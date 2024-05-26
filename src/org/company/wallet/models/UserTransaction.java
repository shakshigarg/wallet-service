package org.company.wallet.models;

import java.util.UUID;

public class UserTransaction extends Transaction {
    String sender;
    String receiver;

    public UserTransaction(int amount, String sender, String receiver) {
        super(TransactionType.USER, UUID.randomUUID().toString(), amount);
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", transactionType=" + transactionType +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
