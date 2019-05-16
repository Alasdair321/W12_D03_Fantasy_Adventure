import Game.Characters.Melee.Knight;
import Game.Interfaces.IDamage;
import Game.Interfaces.IShield;
import Game.Items.Armour;
import Game.Items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    IDamage weapon;
    IShield armour;

    @Before
    public void setUp() {
        armour = new Armour(5);
        weapon = new Weapon(5);
        knight = new Knight(100,10, weapon, 5, armour);
    }

    @Test
    public void hasInfo() {
        assertEquals(100, knight.getHealth());
        assertEquals(10, knight.getArmourClass());
        assertEquals(weapon, knight.getWeapon());
        assertEquals(5, knight.getStrength());
        assertEquals(armour, knight.getArmour());
    }

    @Test
    public void takesDamage() {
        knight.defend(20);
        assertEquals(95, knight.getHealth());
    }

    @Test
    public void doesDamage() {
        knight.attack(knight);
        assertEquals(90, knight.getHealth());

    }

    @Test
    public void canHeal() {
        knight.heal(5);
        assertEquals(105, knight.getHealth());

    }
}
