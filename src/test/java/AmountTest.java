import bank_account_kata.Amount;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(JUnitParamsRunner.class)
public class AmountTest {

    @Test
    public void adding_a_amount_to_an_other() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Amount amount = new Amount(200, date);
        amount = amount.add(new Amount(200, date));

        Amount expectedAmount = new Amount(400, date);

        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }

    @Test
    public void subtract_a_amount_to_an_other() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Amount amount = new Amount(200, date);
        amount = amount.subtract(new Amount(200, date));

        Amount expectedAmount = new Amount(0, date);

        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }


    @Test
    public void return_false_when_the_result_is_negative() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Amount amount = new Amount(200 , date);

        Assertions.assertThat(amount.negativeResult(new Amount(300 , date))).isTrue();
    }

    @Test
    public void return_true_when_the_result_is_positive() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Amount amount = new Amount(200 , date);

        Assertions.assertThat(amount.negativeResult(new Amount(100 , date))).isFalse();
    }
}
