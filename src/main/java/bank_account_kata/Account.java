package bank_account_kata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static bank_account_kata.TypeOfOperation.DEPOSIT_OPERATION;
import static bank_account_kata.TypeOfOperation.REMOVE_OPERATION;

public class Account {

    private Balance balance;
    private final List<Statement> statements = new ArrayList<>();

    @Override
    public String toString() {
        return  statements +" | " + balance +" | "  ;
    }

    public Account(Balance balance) {
        this.balance = balance;
    }

    public void deposit(Amount amount) {
        CreateStatement(amount, DEPOSIT_OPERATION);
        balance = balance.deposit(amount);
    }


    public void remove(Amount amount) {
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
                .withLocalDate(LocalDate.now())
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
