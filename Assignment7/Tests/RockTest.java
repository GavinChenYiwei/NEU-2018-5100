import org.junit.Test;

import static org.junit.Assert.*;

public class RockTest {
    Rock r = new Rock(15);
    Scissors s = new Scissors(7);
    Paper p = new Paper(4);
    @Test
    public void fight() {
        boolean result1 = r.fight(s);
        boolean result2 = r.fight(r);
        boolean result3 = r.fight(p);
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }
}