package Game.Monster.Enemies;

import Game.Character;
import Game.Interfaces.IDefend;

public class Kobold extends Character {

    private int biteStrength;

    public int getBiteStrength() {
        return biteStrength;
    }

    public Kobold(int health, int armourClass, int biteStrength) {
        super(health, armourClass);
        this.biteStrength = biteStrength;
    }

    @Override
    public void attack(IDefend victim) {
        victim.defend(biteStrength);
        victim.defend(biteStrength);
        victim.defend(biteStrength);
    }

}
