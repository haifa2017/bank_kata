package bank_account_kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static bank_account_kata.TypeOfOperation.REMOVE_OPERATION;

public class Account {

    private Balance balance;
    private final List<Statement> statements = new ArrayList<>();


    public Account(Balance balance) {
        this.balance = balance;
    }

    public Account(Amount amount) {
    }


    public void deposit(Amount amount) {
        CreateStatement(amount, REMOVE_OPERATION);
        balance = balance.deposit(amount);
    }


    public void remove(Amount amount) {
        if(balance.removeNegativeResult(amount))
            throw new IllegalStateException();
        CreateStatement(amount, REMOVE_OPERATION);
        balance = balance.removeMoney(amount);
    }

    public void printAllStatement(Printer printer) {
        for (Statement statement : statements) {
            statement.print(printer);
        }
    }

    private void CreateStatement(Amount amount, TypeOfOperation typeOfOperation) {
        Statement statement = Statement.StatementBuilder.aStatement()
                .withLocalDate(LocalDateTime.now())
                .withAmount(amount)
                .withCurrentBalance(balance)
                .withOperation(typeOfOperation)
                .build();
        statements.add(statement);
    }

    public Balance getBalance() {
        return balance;
    }
}