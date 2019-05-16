package Game.Characters.Melee;

import Game.Character;
import Game.Interfaces.IDamage;
import Game.Interfaces.IDefend;

public class Melee extends Character {

    private IDamage weapon;
    private int strength;

    public Melee(int health, int armourClass, IDamage weapon, int strength) {
        super(health, armourClass);
        this.weapon = weapon;
        this.strength = strength;
    }

    private int damage(){
        return weapon.getDamage()*strength;
    }

    @Override
    public void attack(IDefend victim) {
        victim.defend(damage());
    }

    @Override
    public void defend(int damage) {
        int damageTaken = damage - armourClass;
        if (damageTaken > 0) {
            health -= damageTaken;
        }
    }

    public IDamage getWeapon() {
        return weapon;
    }

    public int getStrength() {
        return strength;
    }
}
