package org.company.wallet.models;

import java.util.List;

public abstract class TransactionFilter {
    TransactionFilterType transactionFilterType;

    public List<Transaction> apply(List<Transaction> transactions) {
        return null;
    }
}
