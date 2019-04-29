import bank_account_kata.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.time.LocalDateTime;

import static bank_account_kata.TypeOfOperation.DEPOSIT_OPERATION;
import static bank_account_kata.TypeOfOperation.REMOVE_OPERATION;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {
    @Mock
    private
    Printer printer;


    @Test
    public void should_subtract_zero_to_my_account() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);

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


}
