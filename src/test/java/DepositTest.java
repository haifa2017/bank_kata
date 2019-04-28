import bank_account_kata.Account;
import bank_account_kata.Amount;
import bank_account_kata.Balance;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {


    private Account account;


    @Before
    public void setUp() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        account = new Account(new Balance(new Amount(0 , date)));
    }

    @Test
    public void should_adding_zero_to_my_account() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        account.deposit(new Amount(0, date));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(0 , date)));
    }

    @Test
    public void should_adding_50_to_my_account() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        account.deposit(new Amount(50 , date));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(50 , date)));
    }

    @Test
    public void should_adding_50_twice_to_my_account() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        account.deposit(new Amount(50, date));
        account.deposit(new Amount(50, date));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(100, date)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_deposit_negative_value() throws Exception {
        LocalDateTime date = LocalDateTime.of(2019, 4, 26, 12, 30);
        account.deposit(new Amount(-10000, date));
    }
}