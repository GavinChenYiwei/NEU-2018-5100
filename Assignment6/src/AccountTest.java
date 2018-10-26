import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account ac = new Account("John", "Smith",1000);
    @Test
    public void getAccType() {
        String s = ac.getAcctType();
        Assert.assertEquals(s,"Account");
    }

    @Test
    public void debitTransaction() {
        double result = ac.DebitTransaction(500);
        assertTrue(result == 500.0);
    }

    @Test
    public void creditTransaction() {
        double result = ac.CreditTransaction(500);
        assertTrue(result == 1500);
    }


}