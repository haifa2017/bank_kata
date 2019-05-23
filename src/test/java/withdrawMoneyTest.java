import bank_account_kata.Account;
import bank_account_kata.Amount;
import bank_account_kata.Balance;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;

@RunWith(JUnitParamsRunner.class)
public class withdrawMoneyTest {


    private Account account;

    @Before
    public void setUp() {
        LocalDate date =  LocalDate.now();
        account = new Account(new Balance(new Amount(1000, date)));
    }

    @Test
    public void should_subtract_zero_to_my_account() {
        LocalDate date =  LocalDate.now();
        account.remove(new Amount(0 , date));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(1000, date)));
    }

    @Test
    public void should_subtract_200_to_my_account() {
        LocalDate date =  LocalDate.now();
        account.remove(new Amount(200, date));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(800, date)));
    }

    @Test
    public void should_subtract_200_twice_to_my_account() {
        LocalDate date =  LocalDate.now();
        account.remove(new Amount(200, date));
        account.remove(new Amount(200, date));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(600, date)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_removing_negative_value() {
        LocalDate date =  LocalDate.now();
        account.remove(new Amount(-100, date));
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_authorize_withdrawal_an_amount_which_is_not_present_in_an_account() {
        LocalDate date = LocalDate.now();
        account.remove(new Amount(200000, date));
    }

}
