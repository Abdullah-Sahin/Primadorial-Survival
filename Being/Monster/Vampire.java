package Being.Monster;

import java.util.Random;

import Item.Armor.StandardArmor;
import Item.Weapon.Bow;

public class Vampire extends Monster{
    public Vampire() {
        setAttack(20);
        setDefense(20);
        setHealth(50);
        setMoneyToEarn(15);
        setType("Vampire");
        setChanceOfItem(new Random().nextDouble());
        if(getChanceOfItem() > 0.85){
            setArmorToEarn(new StandardArmor());
        }
        if(getChanceOfItem() < 0.15){
            setWeaponToEarn(new Bow());
        }
        if(getChanceOfItem() > 0.45 && getChanceOfItem() < 0.55){
            setArmorToEarn(new StandardArmor());
            setWeaponToEarn(new Bow());
        }
    }
}
