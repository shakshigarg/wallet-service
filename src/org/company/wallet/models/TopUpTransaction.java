package org.company.wallet.models;

public class TopUpTransaction extends Transaction{
    PaymentSource source;

    public TopUpTransaction(String id, int amount, PaymentSource source) {
        super(TransactionType.TOP_UP, id, amount);
        this.source=source;
    }

    @Override
    public String toString() {
        return "TopUpTransaction{" +
                "source=" + source +
                ", transactionType=" + transactionType +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
