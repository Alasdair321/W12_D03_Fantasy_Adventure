package Game.Characters.Melee;

import Game.Interfaces.IDamage;
import Game.Interfaces.IShield;

public class Knight extends Melee{
    private IShield armour;


    public Knight(int health, int armourClass, IDamage weapon, int strength, IShield armour) {
        super(health, armourClass, weapon, strength);
        this.armour = armour;
    }

    @Override
    public void defend(int damage) {
        int damageTaken = damage - (armourClass+armour.mitigation());
        if (damageTaken > 0) {
            health -= damageTaken;
        }
    }

    public IShield getArmour() {
        return armour;
    }
}
