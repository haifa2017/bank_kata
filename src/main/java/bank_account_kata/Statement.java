package bank_account_kata;


import java.time.LocalDate;

public class Statement {

    private final LocalDate localDate;
    private final Amount amount;
    private final Balance currentBalance;
    private final TypeOfOperation typeofoperation;

    private Statement(LocalDate localDatetime, LocalDate localDate, Amount amount, Balance currentBalance, TypeOfOperation typeofoperation) {
        this.localDate = localDate;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.typeofoperation = typeofoperation;
    }

    public void print(Printer printer) {
        printer.print(this.toString());
    }


    @Override
    public String toString() {
        return localDate +
                " | " + typeofoperation.getOperation() + amount +
                " | " + currentBalance;
    }

    public static final class StatementBuilder {
        private LocalDate localDate;
        private Amount amount;
        private Balance currentBalance;
        private TypeOfOperation typeofoperation;

        private StatementBuilder() {
        }

        public static StatementBuilder aStatement() {
            return new StatementBuilder();
        }

        public StatementBuilder withLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public StatementBuilder withAmount(Amount amount) {
            this.amount = amount;
            return this;
        }

        public StatementBuilder withCurrentBalance(Balance currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        public StatementBuilder withOperation(TypeOfOperation typeofoperation) {
            this.typeofoperation = typeofoperation;
            return this;
        }

        public Statement build() {
            return new Statement(localDate, localDate, amount, currentBalance, typeofoperation);
        }
    }
}
