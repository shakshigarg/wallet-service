package org.company.wallet.utils;

import org.company.wallet.models.OfferTransaction;
import org.company.wallet.models.Transaction;
import org.company.wallet.models.TransactionType;

import java.util.List;

public class ServiceUtils {

    public static void printTransactions(List<Transaction> transactions, String user) {
        if (transactions.isEmpty()) {
            System.out.println("No matching transactions for " + user);
        }
        System.out.println("Printing transactions for " + user);
        System.out.println("------------------------------------");
        transactions.stream().forEach(transaction -> System.out.println(transaction));
        System.out.println("------------------------------------");
    }
}
