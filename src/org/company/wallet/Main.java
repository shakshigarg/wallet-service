package org.company.wallet;

import org.company.wallet.entities.Command;
import org.company.wallet.models.*;
import org.company.wallet.service.WalletService;
import org.company.wallet.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        WalletService walletService = new WalletService();
        walletService.addOffer(new TopUpFirstTranscOffer(100));

        try {
            walletService.registerUser("sakshi");
            walletService.registerUser("mahi");


            walletService.topUpWallet("sakshi", 100, PaymentSource.UPI);
            //walletService.topUpWallet("saki", 1000, PaymentSource.UPI);
            //walletService.topUpWallet("sakshi",-100, PaymentSource.UPI);
            walletService.topUpWallet("mahi", 1000, PaymentSource.UPI);

            System.out.println(walletService.fetchBalance("sakshi"));
            //System.out.println(walletService.fetchBalance("saki"));
            System.out.println(walletService.fetchBalance("mahi"));

            walletService.sendMoney("mahi", "sakshi", 100);
            System.out.println(walletService.fetchBalance("sakshi"));
            System.out.println(walletService.fetchBalance("mahi"));
//            walletService.sendMoney("mahi","sakshi",1000);
//            walletService.sendMoney("mahi","sakshi",-100);

            TransactionFilter transactionTypeFilter = new TransactionTypeFilter(TransactionType.OFFER);
            TransactionFilter amountTypeFilter = new AmountTransactionFilter(100);
            List<TransactionFilter> transactionFilters = new ArrayList<>();

            transactionFilters.add(transactionTypeFilter);
            transactionFilters.add(amountTypeFilter);


            walletService.getTransactions("mahi", transactionFilters);

            walletService.getTransactions("sakshi", new ArrayList<>());



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}