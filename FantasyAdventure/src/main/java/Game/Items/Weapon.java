package Game.Items;

import Game.Interfaces.IDamage;

public class Weapon implements IDamage {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
