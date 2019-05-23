import bank_account_kata.Account;
import bank_account_kata.Amount;
import bank_account_kata.Balance;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class withdrawMoneyTest {


    private Account account;

    @Before
    public void setUp() {
        account = new Account(new Balance(new Amount(1000 )));
    }

    @Test
    public void should_subtract_zero_to_my_account() {
        account.remove(new Amount(0  ));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(1000)));
    }

    @Test
    public void should_subtract_200_to_my_account() {
        account.remove(new Amount(200));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(800)));
    }

    @Test
    public void should_subtract_200_twice_to_my_account() {
        account.remove(new Amount(200));
        account.remove(new Amount(200));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(600)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_removing_negative_value() {
        account.remove(new Amount(-100));
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_authorize_withdrawal_an_amount_which_is_not_present_in_an_account() {
        account.remove(new Amount(200000));
    }

}
