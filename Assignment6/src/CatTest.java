import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {
    Cat cat = new Cat("Candy","Mike","White","short");

    @Test
    public void boarding() {
        cat.setBoardStart(10,12,2000);
        cat.setBoardEnd(10,12,2001);
        Assert.assertFalse(cat.boarding(10,10,2001));
        Assert.assertTrue(cat.boarding(10,13,2001));
        Assert.assertTrue(cat.boarding(10,11,2000));
        Assert.assertTrue(cat.boarding(10,12,2001));
    }
}