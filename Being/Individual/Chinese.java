package Being.Individual;

import java.util.ArrayList;

import Item.Armor.Tshirt;
import Item.Weapon.Knife;

public class Chinese extends Individual{

    public Chinese(){
        setName("Chinese");
        setAttack(10);
        setInitialAttack(10);
        setDefense(30);
        setInitialDefense(30);
        setMoney(20);
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
