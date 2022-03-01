package Being.Monster;

import java.util.Random;

import Item.Armor.HeavyArmor;
import Item.Weapon.Sword;

public class Zombie extends Monster{

    public Zombie() {
        setAttack(40);
        setDefense(40);
        setHealth(95);
        setMoneyToEarn(25);
        setType("Zombie");
        setChanceOfItem(new Random().nextDouble());
        if(getChanceOfItem() > 0.85){
            setArmorToEarn(new HeavyArmor());
        }
        if(getChanceOfItem() < 0.15){
            setWeaponToEarn(new Sword());
        }
        if(getChanceOfItem() > 0.45 && getChanceOfItem() < 0.55){
            setArmorToEarn(new HeavyArmor());
            setWeaponToEarn(new Sword());
        }
    }
    
}
