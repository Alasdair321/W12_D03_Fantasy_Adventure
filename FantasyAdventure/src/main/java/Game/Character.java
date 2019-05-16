package Game;

import Game.Interfaces.IAttack;
import Game.Interfaces.IDefend;

public abstract class Character implements IAttack, IDefend {

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


}
