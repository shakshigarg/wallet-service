package org.company.wallet.models;
public abstract class Offer {
    int giveAwayMoney;

    public boolean isEligible(User user) {
        return false;
    }

    public void apply(User user) {
        return;
    }

}
