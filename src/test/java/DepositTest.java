import bank_account_kata.Account;
import bank_account_kata.Amount;
import bank_account_kata.Balance;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class DepositTest {


    private Account account;


    @Before
    public void setUp()  {
        account = new Account(new Balance(new Amount(0)));
    }

    @Test
    public void should_adding_zero_to_my_account() {
        account.deposit(new Amount(0));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(0)));
    }

    @Test
    public void should_adding_50_to_my_account()  {
        account.deposit(new Amount(50));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(50)));
    }

    @Test
    public void should_adding_50_twice_to_my_account()  {
        account.deposit(new Amount(50));
        account.deposit(new Amount(50));

        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(100)));
    }
}
