package org.company.wallet.models;

public class TopUpFirstTranscOffer extends Offer {

    public TopUpFirstTranscOffer(int amount) {
        giveAwayMoney = amount;
    }

    public boolean isEligible(User user) {
        return user.getTransactions().size() == 1;
    }

    @Override
    public void apply(User user) {
        user.setBalance(user.getBalance() + giveAwayMoney);
        OfferTransaction offerTransaction = new OfferTransaction(giveAwayMoney);
        user.getTransactions().add(offerTransaction);
    }

}
