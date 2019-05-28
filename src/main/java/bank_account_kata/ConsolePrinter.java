package bank_account_kata;

public class ConsolePrinter implements Printer{

    @Override
    public void print(String stringToPrint) {
        System.out.println(stringToPrint);
    }
}
