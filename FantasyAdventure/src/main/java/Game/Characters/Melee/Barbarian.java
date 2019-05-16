package Game.Characters.Melee;

import Game.Interfaces.IDamage;
import Game.Interfaces.IDefend;

public class Barbarian extends Melee {
    private boolean rage;

    public Barbarian(int health, int armourClass, IDamage weapon, int strength) {
        super(health, armourClass, weapon, strength);
        this.rage = false;
    }
    public boolean isRage() {
        return rage;
    }

    public void setRage(boolean rage) {
        this.rage = rage;
    }



    @Override
    public void attack(IDefend victim) {
        if (rage == false) {
        super.attack(victim);
        } else {
            victim.defend(damage()*2);
        }
    }

    @Override
    public void defend(int damage) {
        if (rage == false) {
            super.defend(damage);
        } else {
            super.defend(damage*2);
        }
    }
}
