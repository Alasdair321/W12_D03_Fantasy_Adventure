import Game.Monster.Enemies.Kobold;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KoboldTest {
    Kobold jeff;
    @Before
    public void setUp()  {
     jeff = new Kobold(15,2,3);
    }

    @Test
    public void hasBiteStrength() {
        assertEquals(3, jeff.getBiteStrength());
    }

    @Test
    public void canBiteVictim() {
        jeff.attack(jeff);
        assertEquals(12, jeff.getHealth());
    }
}
