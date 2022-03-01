package Item.Armor;

import Item.Item;

public abstract class Armor extends Item {

    private int initialDefense;
    private int defense;

    public int getDefense() {
        return defense;
    }

    public void setDefense() {
        this.defense = getInitialDefense() + (getUpgradeLevel() * 3);
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getInitialDefense(){
        return initialDefense;
    }

    public void setInitialDefense(int initialDefense){
        this.initialDefense = initialDefense;
    }
}
