import Game.Characters.Healer.Cleric;
import Game.Characters.Healer.Healer;
import Game.Interfaces.IHeal;
import Game.Items.HealingItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    HealingItem orbOfHealing;
    Cleric cleric;

    @Before
    public void setUp() throws Exception {
        orbOfHealing = new HealingItem(2);
        cleric = new Cleric(50,1, orbOfHealing);
    }

    @Test
    public void hasHealingTool() {
        assertEquals(orbOfHealing, cleric.getHealingTool());
    }

    @Test
    public void canAttack() {
        cleric.attack(cleric);
        assertEquals(49, cleric.getHealth());
    }

    @Test
    public void canHeal() {
        cleric.healCharacter(cleric);
        assertEquals(52, cleric.getHealth());

    }
}
