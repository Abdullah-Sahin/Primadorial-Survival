package Place.Town;

import Item.Armor.Armor;
import Item.Weapon.Weapon;
import Place.Place;

public abstract class BlackSmith extends Place{

    public static void ask() {
        System.out.println("""
                You are in Blacksmith. 
                1. To Upgrade Armor
                2. To Upgrade Weapon
                Q to return previous menu
                ----------""");
        System.out.print("Press: ");
    }

    public static void upgradeArmor(Armor armor) {

        armor.setUpgradeLevel(armor.getUpgradeLevel() + 1);
        armor.setDefense();

    }

    public static void upgradeWeapon(Weapon weapon) {

        weapon.setUpgradeLevel(weapon.getUpgradeLevel() + 1);
        weapon.setAttack();

    }

}
