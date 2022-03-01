package Being.Monster;

import java.util.Random;

import Item.Armor.Armor;
import Item.Armor.LightArmor;
import Item.Weapon.Dagger;
import Item.Weapon.Weapon;

public class Snake extends Monster{

    private static Armor armorToEarn = new LightArmor();
    private static Weapon weaponToEarn = new Dagger();

    public Snake() {
        setAttack(10);
        setDefense(10);
        setHealth(20);
        setMoneyToEarn(5);
        setType("Snake");
        setChanceOfItem(new Random().nextDouble());
        if (getChanceOfItem() > 0.85) {
            setArmorToEarn(armorToEarn);
            if (getChanceOfItem() < 0.15) {
                setWeaponToEarn(weaponToEarn);
            }
            if (getChanceOfItem() > 0.45 && getChanceOfItem() < 0.55) {
                setArmorToEarn(armorToEarn);
                setWeaponToEarn(weaponToEarn);
            }
        }
    }
    
}
