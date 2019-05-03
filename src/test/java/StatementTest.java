import bank_account_kata.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static bank_account_kata.TypeOfOperation.DEPOSIT_OPERATION;
import static bank_account_kata.TypeOfOperation.REMOVE_OPERATION;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {
    @Mock
    private
    Printer printer;


    @Test
    public void should_subtract_zero_to_my_account() throws Exception {
        LocalDate date = LocalDate.now();

        Statement statement = Statement.StatementBuilder.aStatement()
                .withLocalDate(date)
                .withAmount(new Amount(100,date))
                .withCurrentBalance(new Balance(new Amount(0,date)))
                .withOperation(DEPOSIT_OPERATION)
                .build();

          String result = statement.toString();
          String expected = date +  " | " +  "+" + 100 +
                  " | " + 0 ;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_print_all_statement() throws Exception {
        LocalDate date1 = LocalDate.now();
        Account account = new Account(new Balance(new Amount(0, LocalDate.now())));

        account.deposit(new Amount(200, date1));
        account.remove(new Amount(100, date1));
        account.deposit(new Amount(500,date1 ));

        account.printAllStatement(printer);

        Statement statement = Statement.StatementBuilder.aStatement()
                .withLocalDate(date1)
                .withAmount(new Amount(100,date1))
                .withCurrentBalance(new Balance(new Amount(0,date1)))
                .withOperation(DEPOSIT_OPERATION)
                .build();
        String result = statement.toString();

        Statement statement2 = Statement.StatementBuilder.aStatement()
                .withLocalDate(date1)
                .withAmount(new Amount(100,date1))
                .withCurrentBalance(new Balance(new Amount(0,date1)))
                .withOperation(REMOVE_OPERATION)
                .build();
        String result2 = statement2.toString();

        String resultTotal= result + result2;

        String expectedStatement1 = date1 +  " | " +  "+" + 100 +
                " | " +  0;
        String expectedStatement2 = date1 +  " | " +  "-" + 100 +
                " | " + 0 ;

        String resultExpected = expectedStatement1 + expectedStatement2 ;

        Assertions.assertThat(resultTotal).isEqualTo(resultExpected);

    }
}
