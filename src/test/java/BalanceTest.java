import bank_account_kata.Amount;
import bank_account_kata.Balance;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(JUnitParamsRunner.class)
public class BalanceTest {

    @Test
    public void should_adding_ten_to_my_balance() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Balance balance = new Balance(new Amount(0, date));
        balance = balance.deposit(new Amount(3000 , date));

        Balance expectedBalance = new Balance(new Amount(3000 , date));

        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_subtract_50_to_my_balance() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Balance balance = new Balance(new Amount(250 , date));
        balance = balance.removeMoney(new Amount(50 , date));

        Balance expectedBalance = new Balance(new Amount(200 , date));

        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_return_false_when_the_result_is_negative() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Balance balance = new Balance(new Amount(300 , date));

        boolean isWithDrawNegative = balance.removeNegativeResult(new Amount(400 , date));

        Assertions.assertThat(isWithDrawNegative).isTrue();
    }

    @Test
    public void should_return_true_when_the_result_is_positive() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        Balance balance = new Balance(new Amount(20, date));

        boolean isWithDrawNegative = balance.removeNegativeResult(new Amount(10 , date));

        Assertions.assertThat(isWithDrawNegative).isFalse();
    }
}
