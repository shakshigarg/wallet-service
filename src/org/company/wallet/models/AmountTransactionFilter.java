package org.company.wallet.models;

import java.util.List;
import java.util.stream.Collectors;

public class AmountTransactionFilter extends TransactionFilter {
    int amount;

    public AmountTransactionFilter(int amount) {
        this.amount = amount;
    }

    @Override
    public List<Transaction> apply(List<Transaction> transactions) {
        return transactions.stream().filter(transaction -> transaction.getAmount() == amount).collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
