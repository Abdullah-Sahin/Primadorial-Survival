package Being.Monster;

import java.util.Random;

import Action.IMonsterAction;
import Being.Being;
import Being.Individual.Individual;
import Item.Armor.Armor;
import Item.Weapon.Weapon;

public abstract class Monster extends Being implements IMonsterAction{

    private double moneyToEarn;
    private String type;
    private Armor armorToEarn;
    private Weapon weaponToEarn;
    private double chanceOfItem = new Random().nextDouble();

    public double getMoneyToEarn() {
        return moneyToEarn;
    }

    public void setMoneyToEarn(double moneyToEarn) {
        this.moneyToEarn = moneyToEarn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Armor getArmorToEarn() {
        return armorToEarn;
    }

    public void setArmorToEarn(Armor armorToEarn) {
        this.armorToEarn = armorToEarn;
    }

    public Weapon getWeaponToEarn() {
        return weaponToEarn;
    }

    public void setWeaponToEarn(Weapon weaponToEarn) {
        this.weaponToEarn = weaponToEarn;
    }

    public double getChanceOfItem() {
        return chanceOfItem;
    }

    public void setChanceOfItem(Double chanceOfItem) {
        this.chanceOfItem = chanceOfItem;
    }

    @Override
    public void hit(Individual individual) {
        if(this.getAttack() > individual.getDefense()){
            individual.setHealth(individual.getHealth() - (this.getAttack() - individual.getDefense()));
        }
    }
    
}
