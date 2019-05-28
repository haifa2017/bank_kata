import bank_account_kata.Amount;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;



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


    @Test
    public void return_false_when_the_result_is_negative() {
        Amount amount = new Amount(200);

        Assertions.assertThat(amount.negativeResult(new Amount(300))).isTrue();
    }

    @Test
    public void return_true_when_the_result_is_positive() {
        Amount amount = new Amount(200);

        Assertions.assertThat(amount.negativeResult(new Amount(100))).isFalse();
    }
}
