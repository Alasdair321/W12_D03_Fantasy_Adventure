package Game;

import Game.Interfaces.IAttack;
import Game.Interfaces.IDefend;
import Game.Interfaces.IHeal;

public abstract class Character implements IAttack, IDefend, IHeal {

    protected int health;
    protected int armourClass;

    public Character(int health, int armourClass) {
        this.health = health;
        this.armourClass = armourClass;
    }

    public int getHealth() {
        return health;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public boolean isAlive(){
        return health>0;
    }


    @Override
    public void heal(int health) {
        this.health += health;
    }

    public void defend(int damage) {
        int damageTaken = damage - armourClass;
        if (damageTaken > 0) {
            health -= damageTaken;
        }
    }
}
