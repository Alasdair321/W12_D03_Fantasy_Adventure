package Game.Items;

import Game.Interfaces.IShield;

public class Armour implements IShield {
    private int mitigationRating;

    public Armour(int mitigationRating) {
        this.mitigationRating = mitigationRating;
    }

    @Override
    public int mitigation() {
        return mitigationRating;
    }
}
