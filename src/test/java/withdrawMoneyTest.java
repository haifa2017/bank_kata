import bank_account_kata.Account;
import bank_account_kata.Amount;
import bank_account_kata.Balance;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;



public class withdrawMoneyTest {


    private Account account;

    @Before
    public void setUp() {
        account = new Account(new Balance(new Amount(1000)));
    }

    @Test
    public void should_subtract_zero_to_my_account() {
        account.remove(new Amount(0));

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
}
