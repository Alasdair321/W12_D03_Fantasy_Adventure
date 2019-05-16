package Game.Items;

import Game.Interfaces.IRestore;

public class HealingItem implements IRestore {
    int restore;

    public HealingItem(int restore) {
        this.restore = restore;
    }


    @Override
    public int restore() {
        return restore;
    }
}
