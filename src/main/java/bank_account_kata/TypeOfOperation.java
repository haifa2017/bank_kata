package bank_account_kata;

enum TypeOfOperation {

    DEPOSIT_OPERATION("+"), REMOVE_OPERATION("-");

    private final String operation;

    TypeOfOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}

