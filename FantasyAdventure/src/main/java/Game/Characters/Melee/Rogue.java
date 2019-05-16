package Game.Characters.Melee;

import Game.Interfaces.IDamage;

public class Rogue extends Melee {
    private double avoidance;

    public Rogue(int health, int armourClass, IDamage weapon, int strength) {
        super(health, armourClass, weapon, strength);
        this.avoidance = 0.5;
    }

    public double getAvoidance() {
        return avoidance;
    }

    @Override
    public void defend(int damage) {
        double dodgeChance = Math.random();
        if (dodgeChance > avoidance){
            super.defend(damage);
        }
    }
}
