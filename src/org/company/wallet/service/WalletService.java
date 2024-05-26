package org.company.wallet.service;

import org.company.wallet.exception.InsufficientBalanceException;
import org.company.wallet.exception.UserAlreadyExistsException;
import org.company.wallet.exception.InvalidAmountException;
import org.company.wallet.exception.UserNotExistsException;
import org.company.wallet.models.*;
import org.company.wallet.utils.ServiceUtils;

import java.util.*;

public class WalletService {
    Map<String, User> userMap;
    List<Offer> offers;

    public WalletService() {
        this.userMap = new HashMap<>();
        this.offers=new ArrayList<>();
    }

    public void registerUser(String name) throws UserAlreadyExistsException {
        name = name.toLowerCase();
        if (!userMap.containsKey(name)) {
            userMap.put(name, new User(name));
        } else {
            throw new UserAlreadyExistsException("User already exists!");
        }
    }

    public void topUpWallet(String name, int amount, PaymentSource paymentSource) throws InvalidAmountException, UserNotExistsException {
        if (userMap.containsKey(name)) {
            if (amount < 0) {
                throw new InvalidAmountException("Amount invalid");
            }
            TopUpTransaction topUpTransaction = new TopUpTransaction(UUID.randomUUID().toString(), amount, paymentSource);
            userMap.get(name).getTransactions().add(topUpTransaction);
            userMap.get(name).setBalance(userMap.get(name).getBalance() + amount);
            System.out.println("Top up done for " + name);
            offers.stream().forEach(offer -> {
                if(offer.isEligible(userMap.get(name))){
                    offer.apply(userMap.get(name));
                }
            });
        } else {
            throw new UserNotExistsException(("User not exists!"));
        }
    }

    public int fetchBalance(String name) throws UserNotExistsException {
        if (userMap.containsKey(name)) {
            return userMap.get(name).getBalance();
        } else {
            throw new UserNotExistsException(("User not exists!"));
        }
    }

    public void sendMoney(String sender, String receiver, int amount) throws UserNotExistsException, InsufficientBalanceException, InvalidAmountException {
        if (!userMap.containsKey(sender)) {
            throw new UserNotExistsException(("Sender " + sender + " doesn't not exists!"));
        }
        if (!userMap.containsKey(receiver)) {
            throw new UserNotExistsException(("receiver " + receiver + " doesn't not exists!"));
        }

        if (userMap.get(sender).getBalance() < amount) {
            throw new InsufficientBalanceException("Balance not sufficient to be send by sender " + sender);
        }
        if (amount < 0) {
            throw new InvalidAmountException("Amount invalid");
        }
        userMap.get(sender).setBalance(userMap.get(sender).getBalance() - amount);
        userMap.get(receiver).setBalance(userMap.get(receiver).getBalance() + amount);
        UserTransaction userTransaction = new UserTransaction(100, sender, receiver);
        userMap.get(sender).getTransactions().add(userTransaction);
        userMap.get(receiver).getTransactions().add(userTransaction);
        System.out.println("Successfully transferred money");
    }

    public List<Transaction> getTransactions(String user, List<TransactionFilter> transactionFilters) throws UserNotExistsException {
        if (!userMap.containsKey(user)) {
            throw new UserNotExistsException((user + " doesn't not exists!"));
        }

        List<Transaction> transactions = userMap.get(user).getTransactions();
        for (TransactionFilter transactionFilter :
                transactionFilters) {
            transactions = transactionFilter.apply(transactions);
        }
        ServiceUtils.printTransactions(transactions, user);
        return transactions;
    }

    public void addOffer(TopUpFirstTranscOffer offer) {
        offers.add(offer);
    }
}
