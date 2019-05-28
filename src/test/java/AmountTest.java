import bank_account_kata.Amount;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AmountTest {

    @Test
    public void adding_a_amount_to_an_other()  {
        Amount amount = new Amount(200);
        amount = amount.add(new Amount(200));

        Amount expectedAmount = new Amount(400);

        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }

    @Test
    public void subtract_a_amount_to_an_other() {
        Amount amount = new Amount(200);
        amount = amount.subtract(new Amount(200));

        Amount expectedAmount = new Amount(0);

        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }
}
