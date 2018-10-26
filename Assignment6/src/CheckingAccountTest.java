import org.junit.Assert;

public class CheckingAccountTest {

    @org.junit.Test
    public void debitTransaction() {
        CheckingAccount ca = new CheckingAccount("Yiwei","Chen", 150);
        double result = ca.DebitTransaction(50);
        Assert.assertTrue(result == 100);
        result = ca.DebitTransaction(50);
        Assert.assertTrue(result == 45);
    }

    @org.junit.Test
    public void creditTransaction() {
        CheckingAccount ca = new CheckingAccount("Yiwei","Chen", 50);
        double result = ca.CreditTransaction(40);
        Assert.assertTrue(result == 85);
        result = ca.CreditTransaction(50);
        Assert.assertTrue(result == 135);
    }
}