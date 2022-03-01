package Item.Weapon;

import Item.Item;

public abstract class Weapon extends Item {

    private int initialAttack;
    private int attack;

    public void setAttack() {
        this.attack = getInitialAttack() + (getUpgradeLevel() * 5);
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setInitialAttack(int initialAttack){
        this.initialAttack = initialAttack;
    }

    public int getInitialAttack(){
        return initialAttack;
    }
}
