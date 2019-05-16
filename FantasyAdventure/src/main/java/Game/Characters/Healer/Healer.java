package Game.Characters.Healer;

import Game.Character;
import Game.Interfaces.IDefend;
import Game.Interfaces.IHeal;
import Game.Interfaces.IRestore;

public abstract class Healer extends Character {

    protected IRestore healingTool;

    public Healer(int health, int armourClass, IRestore healingTool) {
        super(health, armourClass);
        this.healingTool = healingTool;
    }

    @Override
    public void attack(IDefend victim) {
        victim.defend(2);
    }

    public void healCharacter(IHeal patient){
        patient.heal(healingTool.restore());
    }

    public Object getHealingTool() {
        return healingTool;
    }
}
