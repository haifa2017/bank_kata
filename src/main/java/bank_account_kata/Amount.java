package bank_account_kata;


import java.time.LocalDateTime;

public class Amount {


    private int value;

    private final LocalDateTime date;
    public Amount(int value, LocalDateTime date) {
        this.date = date;
        if (value < 0)
            throw new IllegalArgumentException();
        this.value = value;
    }

   public Amount add(Amount amount ) {
        return new Amount(this.value + amount.value, date);
    }

   public Amount subtract(Amount amount  ) {
        return new Amount(this.value - amount.value, date);
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public boolean negativeResult(Amount amount) {
        return this.value - amount.value < 0;
    }
}