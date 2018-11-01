import org.junit.Test;

import static org.junit.Assert.*;

public class ScissorsTest {
    Rock r = new Rock(15);
    Scissors s = new Scissors(7);
    Paper p = new Paper(4);
    @Test
    public void fight() {
        boolean result1 = s.fight(s);
        boolean result2 = s.fight(r);
        boolean result3 = s.fight(p);
        assertFalse(result1);
        assertFalse(result2);
        assertTrue(result3);
    }
}