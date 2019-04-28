package bank_account_kata;

import java.util.Objects;

public class Balance {

    private final Amount amount;

    public Balance(Amount amount) {

        this.amount = amount;
    }

    public Balance deposit(Amount amount) {
        return new Balance(this.amount.add(amount));
    }

    public Balance  removeMoney(Amount amount) {
        return new Balance(this.amount.subtract(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }

    public boolean  removeNegativeResult(Amount amount) {
        return this.amount.negativeResult(amount);
    }

    @Override
    public String toString() {
        return "" + amount;
    }
}
