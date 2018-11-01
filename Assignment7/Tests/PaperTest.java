import org.junit.Test;

import static org.junit.Assert.*;

public class PaperTest {
    Rock r = new Rock(15);
    Scissors s = new Scissors(7);
    Paper p = new Paper(4);
    @Test
    public void fight() {
        boolean result1 = p.fight(s);
        boolean result2 = p.fight(r);
        boolean result3 = p.fight(p);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }
}