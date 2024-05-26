package org.company.wallet.models;

import java.util.UUID;

public class OfferTransaction extends Transaction{
    Offer offer;

    public OfferTransaction(int amount) {
        super(TransactionType.OFFER, UUID.randomUUID().toString(), amount);
    }

    @Override
    public String toString() {
        return "OfferTransaction{" +
                "offer=" + offer +
                ", transactionType=" + transactionType +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
