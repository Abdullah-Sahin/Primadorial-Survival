package Being.Individual;

import java.util.ArrayList;

import Item.Armor.Tshirt;
import Item.Weapon.Knife;

public class English extends Individual{

    public English(){

        setName("English");
        setAttack(15);
        setInitialAttack(15);
        setDefense(15);
        setInitialDefense(15);
        setMoney(100);
        setHealth(100);
        setWornArmor(new Tshirt());
        setWornWeapon(new Knife());
        setArmors(new ArrayList<>());
        getArmors().add(getWornArmor());
        setWeapons(new ArrayList<>());
        getWeapons().add(getWornWeapon());
        setAllItems(new ArrayList<>());
        setAllItems();
        setAttackAndDefense();
    }
    
}
