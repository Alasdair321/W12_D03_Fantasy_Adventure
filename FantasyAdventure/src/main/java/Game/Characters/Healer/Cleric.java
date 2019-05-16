package Game.Characters.Healer;

import Game.Interfaces.IRestore;

public class Cleric extends Healer {
    public Cleric(int health, int armourClass, IRestore healingTool) {
        super(health, armourClass, healingTool);
    }
}
