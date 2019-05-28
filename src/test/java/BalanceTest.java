import bank_account_kata.Amount;
import bank_account_kata.Balance;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

public class BalanceTest {

    @Test
    public void should_adding_ten_to_my_balance() {
        Balance balance = new Balance(new Amount(0));
        balance = balance.deposit(new Amount(3000));

        Balance expectedBalance = new Balance(new Amount(3000));

        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_subtract_50_to_my_balance() {
        Balance balance = new Balance(new Amount(250));
        balance = balance.removeMoney(new Amount(50));

        Balance expectedBalance = new Balance(new Amount(200));

        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_return_false_when_the_result_is_negative()  {
        Balance balance = new Balance(new Amount(300));

        boolean isWithDrawNegative = balance.removeNegativeResult(new Amount(400));

        Assertions.assertThat(isWithDrawNegative).isTrue();
    }

    @Test
    public void should_return_true_when_the_result_is_positive()   {
        Balance balance = new Balance(new Amount(20));

        boolean isWithDrawNegative = balance.removeNegativeResult(new Amount(10));

        Assertions.assertThat(isWithDrawNegative).isFalse();
    }
}
