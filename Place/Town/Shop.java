package Place.Town;

import Being.Individual.Individual;
import Item.Armor.*;
import Item.Weapon.*;

import java.util.Scanner;

public abstract class Shop {

    private static final Scanner in = new Scanner(System.in);
    private static final Armor[] armors = {new Tshirt(), new LightArmor(), new StandardArmor(), new HeavyArmor()};
    private static final Weapon[] weapons = {new Knife(), new Dagger(), new Bow(), new Sword()};

    public static void shopping(Individual individual){
        
        System.out.println("Welcome to Shop Centre");
        while(true){
            System.out.println("""
                    1. To buy Armor
                    2. To buy Weapon
                    3. To sell Item
                    Q for previous menu
                    ----------""");
            System.out.print("Press: ");
            String answer = in.next();
            System.out.println("----------");
            if(answer.equalsIgnoreCase("q")){
                System.out.println("Shop Owner: Goodbye.\n---------");
                break;
            }
            else{

                switch (answer) {
                    case "1" ->
                        individual.buyArmor();
                    case "2" ->
                        individual.buyWeapon();
                    case "3" ->
                        individual.sell();
                    default -> System.out.println("*****INVALID INPUT*****");
                }
            }
        }    
    }

    public static void showArmorTypes(){
        for (int i = 1; i <= armors.length; i++) {
            System.out.println(i + ". " + armors[i-1].getName() + " " + armors[i-1].getPrice() + " golds");
        }
        System.out.println("Q to return shop menu\n----------");
    }

    public static void showWeaponTypes(){
        for(int i = 1; i <= weapons.length; i++){
            System.out.println(i + ". "+ weapons[i-1].getName() + " " + weapons[i-1].getPrice() + " golds");
        }
        System.out.println("Q to return shop menu\n----------");
    }

    public static Armor[] getArmors() {
        return armors;
    }

    public static Weapon[] getWeapons() {
        return weapons;
    }

}

