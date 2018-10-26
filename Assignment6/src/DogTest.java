import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {
    Dog dog = new Dog("Candy","Mike","White","Large");
    @Test
    public void boarding() {
        dog.setBoardStart(10,12,2000);
        dog.setBoardEnd(10,12,2001);
        Assert.assertTrue(dog.boarding(10,10,2001));
        Assert.assertFalse(dog.boarding(10,13,2001));
        Assert.assertFalse(dog.boarding(10,11,2000));
        Assert.assertTrue(dog.boarding(10,12,2000));
    }
}