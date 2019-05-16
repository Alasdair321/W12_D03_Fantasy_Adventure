import Game.Characters.Melee.Barbarian;
import Game.Characters.Melee.Knight;
import Game.Items.Armour;
import Game.Items.Weapon;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    Weapon weapon;
    Barbarian barbarian;
    Armour armour;
    Knight knight;

    @Before
    public void setUp() throws Exception {
        weapon = new Weapon(5);
        barbarian = new Barbarian(100, 5,weapon, 10);
        armour = new Armour(5);
        weapon = new Weapon(5);
        knight = new Knight(100,10, weapon, 5, armour);
    }


    @Test
    public void startsUnRaged() {
        assertEquals(false, barbarian.isRage());
    }


    @Test
    public void goRage() {
        barbarian.setRage(true);
        assertEquals(true, barbarian.isRage());
    }

    @Test
    public void rageDamagex2() {
        barbarian.setRage(true);
        barbarian.attack(knight);
        assertEquals(15, knight.getHealth());
    }

    @Test
    public void rageTakeDamagex2() {
        barbarian.setRage(true);
        knight.attack(barbarian);
        assertEquals(55, barbarian.getHealth());
    }
}
