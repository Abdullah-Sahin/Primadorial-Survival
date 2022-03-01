package Action;

import Item.Armor.Armor;
import Item.Weapon.Weapon;

public interface IIndividualAction{

    public void showAllDetails();
    public void showAllItems();
    public void showAllArmors();
    public void showAllWeapons();
    public void wearArmor();
    public void wearWeapon();
    public void showWornArmor();
    public void showWornWeapon();
    public void rest();
    public Weapon chooseWeapon();
    public Armor chooseArmor();
    public void upgradeArmor();
    public void upgradeWeapon();
    
}