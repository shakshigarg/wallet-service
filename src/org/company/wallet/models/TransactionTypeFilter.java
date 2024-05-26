package org.company.wallet.models;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionTypeFilter extends TransactionFilter{
    TransactionType transactionType;

    public TransactionTypeFilter(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public List<Transaction> apply(List<Transaction> transactions) {
        return transactions.stream().filter(transaction -> transaction.getTransactionType().equals(transactionType)).collect(Collectors.toList());
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
