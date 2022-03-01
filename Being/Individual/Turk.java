package Being.Individual;

import java.util.ArrayList;

import Item.Armor.Tshirt;
import Item.Weapon.Knife;

public class Turk extends Individual{

    public Turk(){
        setName("Turk");
        setAttack(30);
        setInitialAttack(30);
        setDefense(15);
        setInitialDefense(15);
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
