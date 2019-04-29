package bank_account_kata;


import java.time.LocalDateTime;

public class Statement {

    private final LocalDateTime localDatetime;
    private final Amount amount;
    private final Balance currentBalance;
    private final TypeOfOperation typeofoperation;

    private Statement(LocalDateTime localDatetime, Amount amount, Balance currentBalance, TypeOfOperation typeofoperation) {
        this.localDatetime = localDatetime;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.typeofoperation = typeofoperation;
    }

    public void print(Printer printer) {
        printer.print(this.toString());
    }


    @Override
    public String toString() {
        return localDatetime +
                " | " + typeofoperation.getOperation() + amount +
                " | " + currentBalance;
    }

    public static final class StatementBuilder {
        private LocalDateTime localDate;
        private Amount amount;
        private Balance currentBalance;
        private TypeOfOperation typeofoperation;

        private StatementBuilder() {
        }

        public static StatementBuilder aStatement() {
            return new StatementBuilder();
        }

        public StatementBuilder withLocalDate(LocalDateTime localDate) {
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
            return new Statement(localDate, amount, currentBalance, typeofoperation);
        }
    }
}
