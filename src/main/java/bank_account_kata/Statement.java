package bank_account_kata;


import java.time.LocalDateTime;

public class Statement {

    private final LocalDateTime localDate;
    private final Amount amount;
    private final Balance currentBalance;
    private final TypeOfOperation typeofoperation;

    private Statement(LocalDateTime localDate, Amount amount, Balance currentBalance, TypeOfOperation typeofoperation) {
        this.localDate = localDate;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.typeofoperation = typeofoperation;
    }

    void print(Printer printer) {
        printer.print(this.toString());
    }


    @Override
    public String toString() {
        return localDate +
                " | " + typeofoperation.getOperation() + amount +
                " | " + currentBalance;
    }

    static final class StatementBuilder {
        private LocalDateTime localDate;
        private Amount amount;
        private Balance currentBalance;
        private TypeOfOperation typeofoperation;

        private StatementBuilder() {
        }

        static StatementBuilder aStatement() {
            return new StatementBuilder();
        }

        StatementBuilder withLocalDate(LocalDateTime localDate) {
            this.localDate = localDate;
            return this;
        }

        StatementBuilder withAmount(Amount amount) {
            this.amount = amount;
            return this;
        }

        StatementBuilder withCurrentBalance(Balance currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        StatementBuilder withOperation(TypeOfOperation typeofoperation) {
            this.typeofoperation = typeofoperation;
            return this;
        }

        Statement build() {
            return new Statement(localDate, amount, currentBalance, typeofoperation);
        }
    }
}
