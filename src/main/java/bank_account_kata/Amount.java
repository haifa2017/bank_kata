package bank_account_kata;


public class Amount {


    private int value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Amount subtract(Amount amount) {
        return new Amount(this.value - amount.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
}