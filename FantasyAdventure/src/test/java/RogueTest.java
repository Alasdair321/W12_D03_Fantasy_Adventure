import Game.Characters.Melee.Rogue;
import Game.Items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RogueTest {

    Weapon dagger;
    Rogue rogue;

    @Before
    public void setUp() {
        dagger = new Weapon(5);
        rogue = new Rogue(100,2,dagger, 3);
    }

    @Test
    public void hasAvoidance() {
        assertEquals(0.5, rogue.getAvoidance(),0);
    }

    @Test
    public void canHit() {
        rogue.attack(rogue);
        assertEquals(87, rogue.getHealth());

    }
}
