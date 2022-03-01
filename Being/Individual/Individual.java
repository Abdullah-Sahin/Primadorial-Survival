package Being.Individual;

import java.util.ArrayList;
import java.util.Scanner;

import Action.IIndividualAction;
import Action.IShopAction;
import Action.IWarAction;
import Being.Being;
import Being.Monster.Monster;
import Item.Item;
import Item.Armor.*;
import Item.Weapon.*;
import Place.Town.BlackSmith;
import Place.Town.Shop;
import Place.WarPlace.Cave;
import Place.WarPlace.Forest;
import Place.WarPlace.Graveyard;
import Place.WarPlace.WarPlace;

public abstract class Individual extends Being implements IIndividualAction, IShopAction, IWarAction{

        private Armor wornArmor;
        private Weapon wornWeapon;
        private ArrayList<Armor> armors;
        private ArrayList<Weapon> weapons;
        private ArrayList<Item> allItems;
        private boolean foodFound = false;
        private boolean woodFound = false;
        private boolean steelFound = false;
        private double money;
        private String name;
        private int initialAttack;
        private int initialDefense;
    
        static Scanner in = new Scanner(System.in);
        static String answer;
    
        public static Individual createIndividual() {
            while(true){
                System.out.print("""
                        1. Turk -> (Strength: Attack)
                        2. Chinese -> (Strength: Defense)
                        3. English -> (Strength: Money)
                        Press:\s""");
                answer = in.next();
                switch (answer) {
                    case "1":
                        return new Turk();
                    case "2":
                        return new Chinese();
                    case "3":
                        return new English();
                    default:
                        System.out.println("*****Invalid Input*****");
                        break;
                }
            }
        }
    
        @Override
        public void showAllDetails() {
            while(true){
                if(answer.equalsIgnoreCase("q")){
                    break;
                }
                System.out.println("""
                    1. To see Health
                    2. To see Attack
                    3. To see Defense
                    4. To see money
                    5. To see worn weapon
                    6. To see worn armor
                    7. To see all items
                    8. To see collected rewards
                    Q  To return town cenre
                    ----------""");
                System.out.print("Press: "); 
                answer = in.next();
                System.out.println("----------");
                switch(answer){
                    case "1" -> System.out.println("Your health is " + getHealth() + "/100" + "\n----------");
                    case "2" -> System.out.println("Your Attack: " + getAttack() + "\n----------");
                    case "3" -> System.out.println("Your Defense: " +getDefense() + "\n----------");
                    case "4" -> System.out.println("You have " + getMoney() + " golds" + "\n----------");
                    case "5" -> showWornWeapon();
                    case "6" -> showWornArmor();
                    case "7" -> showAllItems();
                    case "8" -> {if(getFoodFound()) System.out.println("food");
                                if(getWoodFound()) System.out.println("wood");
                                if(getSteelFound()) System.out.println("Steel");
                                if(!(getFoodFound() || getWoodFound() || getSteelFound())) System.out.println("No rewards yet" +
                                 "\n----------");}
                    default -> System.out.println("*****INVALID INPUT*****");
                }
            }    
        }
    
        @Override
        public void showAllItems() {
            if(allItems.size() == 0){
                System.out.println("You don't have any item.\n");
            }
            else{
                for(Item item: allItems){
                    System.out.println((allItems.indexOf(item)+1) + ". " + item.getName() + " +" + item.getUpgradeLevel());
                }
            }
            System.out.println("----------"); 
        }
    
        @Override
        public void showAllArmors() {
            if(armors.size() == 0){
                System.out.println("You don't have an armor yet");
            }
            else{
                for(Armor armor: armors){
                    System.out.println((armors.indexOf(armor)+1) + ". " + armor.getName() + " +" + armor.getUpgradeLevel());
                }
            }
            System.out.println("----------");
        }
    
        @Override
        public void showAllWeapons() {
            if(weapons.size() == 0){
                System.out.println("You don't have any weapons yet");
            }
            else{
                for(Weapon weapon: weapons){
                    System.out.println((weapons.indexOf(weapon)+1) + ". " + weapon.getName()+ " +" + weapon.getUpgradeLevel());
                }
            }
            System.out.println("----------");
        }
    
        @Override
        public void wearArmor() {
            while(true){
                if(armors.size() == 0){
                    System.out.println("You don't have an armor");
                    break;
                } 
                showAllArmors();
                System.out.print("Press the number of armor  or Q to exit: ");
                answer = in.next();
                if(answer.equalsIgnoreCase("q")){
                    break;
                }
                try{
                    wornArmor = armors.get(Integer.parseInt(answer) - 1);
                    setAttackAndDefense();
                    System.out.println("You wore +" + wornArmor.getUpgradeLevel() + " " + wornArmor.getName());
                    break;
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }
            }
        }
    
        @Override
        public void wearWeapon() {
            while(true){
                if(weapons.size() == 0){
                    System.out.println("You don't have a weapon");
                    break;
                } 
                showAllWeapons();
                System.out.print("Press the number of weapon or Q to quit: ");
                answer = in.next();
                if(answer.equalsIgnoreCase("q")){
                    break;
                }
                try{
                    wornWeapon = weapons.get(Integer.parseInt(answer)- 1);
                    setAttackAndDefense();
                    System.out.println("You wore +" + wornWeapon.getUpgradeLevel() + " " + wornWeapon.getName());
                    break;
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }
            }
            
            
            
            
        }
    
    
        @Override
        public void showWornArmor() {
            try{
                System.out.println("Worn armor is: " + getWornArmor().getName() + " +" + getWornArmor().getUpgradeLevel());
                System.out.println("-------");
            }
            catch(Exception e){
                System.out.println("You have no weapon in your hands");
            }
            
        }
    
        @Override
        public void showWornWeapon() {
            try{
                System.out.println("Worn weapon is: " + getWornWeapon().getName() + " +" + getWornWeapon().getUpgradeLevel());
                System.out.println("-------");
            }
            catch(Exception e){
                System.out.println("You seem to have worn no armor");
            }
            
        }
    
        @Override
        public void buyArmor() {
            while(true){
            System.out.println("You have " + getMoney() + " golds");
            Shop.showArmorTypes();
            System.out.print("Press: ");
            answer = in.next();
            System.out.println("----------");
            if(answer.equalsIgnoreCase("q")){
                System.out.println("Returning to shop menu"); 
                break;
            }
            try{
                Armor armorToBuy = Shop.getArmors()[Integer.parseInt(answer)-1];
                if (getMoney() < armorToBuy.getPrice()) {
                    System.out.println("You don't have enough money.\nMissing money: " +
                        (armorToBuy.getPrice() - getMoney()) + " golds.\n----------");
                }
                else{
                    allItems.add(armorToBuy);
                    armors.add(armorToBuy);
                    setMoney(getMoney() - armorToBuy.getPrice());
                    System.out.println("Item purchased: " + armorToBuy.getName());
                    System.out.println("Remaining money: " + getMoney() + " golds.\n----------");
                    break;
                }
            }
            catch(Exception e){
                System.out.println("*****INVALID INPUT*****");
            }
                
            }
        }
    
        @Override
        public void buyWeapon(){
            while(true){
                System.out.println("You have " + getMoney() + " golds.");
                Shop.showWeaponTypes();
                System.out.print("Press: ");
                answer = in.next();
                System.out.println("----------");
                if(answer.equalsIgnoreCase("q")) {
                    System.out.println("Returning to shop menu...");
                    break;
                }
                try{
                    Weapon weaponToBuy = Shop.getWeapons()[Integer.parseInt(answer)-1];
                    if (getMoney() < weaponToBuy.getPrice()) {
                        System.out.println("You don't have enough money.\nMissing money: " +
                            (weaponToBuy.getPrice() - getMoney()) + " golds.\n----------");
                    }
                    else{
                        allItems.add(weaponToBuy);
                        weapons.add(weaponToBuy);
                        setMoney(getMoney() - weaponToBuy.getPrice());
                        System.out.println("Item purchased: " + weaponToBuy.getName());
                        System.out.println("Remaining money: " + getMoney() + " golds.\n----------");
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }
            }    
        }
    
    
        @Override
        public void sell() {
            while(true){
                showAllItems();
                if(getAllItems().size() == 0){
                    break;
                }
                System.out.print("Press Number of item to sell\n" + 
                                "Q to return Shop Centre\n" +
                                "Press: ");
                answer = in.next();
                System.out.println("----------");
                if(answer.equalsIgnoreCase("q")){
                    break;
                }
                try{
                    Item itemToSell = allItems.get(Integer.parseInt(answer)-1);
                    setMoney(getMoney() + (itemToSell.getPrice() / 2 ) );
                    if(armors.contains(itemToSell)){
                        armors.remove(itemToSell);
                        if(itemToSell == wornArmor){
                            setWornArmor(null);
                            setAttackAndDefense();
                            System.out.println("*****You sold worn armor*****");
                        }
                    }
                    else{
                        weapons.remove(itemToSell);
                        if(itemToSell == wornWeapon){
                            setWornWeapon(null);
                            setAttackAndDefense();
                            System.out.println("*****You sold worn weapon*****");
                        }
                    }
                    allItems.remove(itemToSell);
                    System.out.println("+ " + itemToSell.getPrice() + " golds earned.\n New money: " + getMoney() + " golds.\n" +
                                                                        "----------");
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }
            }
        }    
    
        
        @Override
        public void withdraw() {
            System.out.println("Returning to Town Centre...");
        }
        
        public void setAttackAndDefense(){
            if(getWornArmor() == null && getWornWeapon() == null){
                setAttack(getInitialAttack());
                setDefense(getInitialDefense());
            }
            else if(getWornArmor() != null && getWornWeapon() == null){
                setAttack(getInitialAttack());
                setDefense(getInitialDefense() + getWornArmor().getDefense());
            }
            else if(getWornArmor() == null && getWornWeapon() != null){
                setAttack(getInitialAttack() + getWornWeapon().getAttack());
                setDefense(getInitialDefense());
            }
            else{
                setAttack(getInitialAttack() + getWornWeapon().getAttack());
                setDefense(getInitialDefense() + getWornArmor().getDefense());
            }  
        }
    
        @Override
        public void rest(){
            if(getMoney() < 5 || getHealth() == 100) {
                if (getMoney() < 5) {
                    System.out.println("You do not have enough money.\n" +
                            "Money needed: " + (5 - getMoney()));
                } else {
                    System.out.println("Your health is full.");
                }
            }
            else{
                setMoney(getMoney() - 5);
                setHealth(getHealth() + 30);
                if(getHealth() > 100){
                    setHealth(100);
                }
                System.out.println("Health: " + getHealth() + "\nMoney: " + getMoney());
            }
        }
        
        @Override
        public Weapon chooseWeapon(){
            while(true){
                if(getWeapons().size() == 0){
                    return null;
                }
                System.out.println("----------");
                showAllWeapons();
                System.out.print("Press index of weapon or Q to quit: ");
                answer = in.next();
                if(answer.equalsIgnoreCase("q")){
                    System.out.println("Returning...");
                    return null;
                }
                try{
                    int intAnswer = Integer.parseInt(answer) - 1;
                    return weapons.get(intAnswer);   
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }
            }    
        }
        
        @Override
        public Armor chooseArmor(){
            while(true){
                if(getArmors().size() == 0){
                    return null;
                }
                System.out.println("----------");
                showAllArmors();
                System.out.print("Press index of armor or Q to quit: ");
                answer = in.next();
                if(answer.equalsIgnoreCase("q")){
                    System.out.println("Returning...");
                    return null;
                }
                try{
                    int intAnswer = Integer.parseInt(answer) - 1;
                    return armors.get(intAnswer);
                }
                catch(Exception e){
                    System.out.println("*****INVALID INPUT*****");
                }    
            }
        }
        
        @Override
        public void upgradeArmor(){
            Armor armorToUpgrade = chooseArmor();
            if(armorToUpgrade == null) System.out.println("----------");
            else if((getMoney() < ((armorToUpgrade.getRuquiredMoneyToUpgrade())) || armorToUpgrade.getUpgradeLevel() == 5)){
                if(getMoney() < (armorToUpgrade.getRuquiredMoneyToUpgrade())){
                    System.out.println("You don't have enough money.\n" +
                            " Money needed: " + (armorToUpgrade.getRuquiredMoneyToUpgrade() - getMoney()));
                }
                
                if(armorToUpgrade.getUpgradeLevel() == 5)
                System.out.println("Armor can't be upgraded more");
            }
            else{
                BlackSmith.upgradeArmor(armorToUpgrade);
                setMoney(getMoney() - ((armorToUpgrade.getUpgradeLevel() * 3)));
            }
            try{
                System.out.println(armorToUpgrade.getName() + " + " + armorToUpgrade.getUpgradeLevel());
                setAttackAndDefense();
            }
            catch(Exception e){
                System.out.println("No upgrade has been made");
            }
    
            
        }
    
        @Override
        public void upgradeWeapon(){
            Weapon weaponToUpgrade = chooseWeapon();
            if(weaponToUpgrade == null) System.out.println("----------");
            else if(getMoney() < weaponToUpgrade.getRuquiredMoneyToUpgrade() || weaponToUpgrade.getUpgradeLevel() == 5) {
                if (getMoney() < weaponToUpgrade.getRuquiredMoneyToUpgrade()){
                    System.out.println("You don't have enough money.\n" +
                    " Money needed: " + (weaponToUpgrade.getRuquiredMoneyToUpgrade() - getMoney()));
                }
                if (weaponToUpgrade.getUpgradeLevel() == 5)
                    System.out.println("Weapon can't be upgraded more");
            }
            else{
                BlackSmith.upgradeWeapon(weaponToUpgrade);
                setMoney(getMoney() - (weaponToUpgrade.getUpgradeLevel()* 5));
            }
            try{
                System.out.println(weaponToUpgrade.getName() + " + " + weaponToUpgrade.getUpgradeLevel());
                setAttackAndDefense();
            }
            catch(Exception e){
                System.out.println("No upgrade has been made");
            }
            
        }
        @Override
        public void hit(Monster monster){
            if(this.getAttack() > monster.getDefense()) {
                monster.setHealth(monster.getHealth() - (this.getAttack() - monster.getDefense()));
                if (monster.getHealth() <= 0) {
                    monster.setHealth(0);   
                }
            }
        }
    
        @Override
        public void superHit(Monster monster) {
            this.setHealth(this.getHealth() - 5);
            monster.setHealth(monster.getHealth() - ((this.getAttack() * 2) - monster.getDefense()));
            if (monster.getHealth() <= 0) {
                monster.setHealth(0);
            }
        }
    
        public void oneToOne(Monster monster){
            while(getHealth() > 0 && monster.getHealth() > 0){
                System.out.print("""
                1. To hit 
                2. To super-hit
                3. To see health
                Q to withdraw
                Press: """);
                answer = in.next();
                if(answer.equalsIgnoreCase("q")) break;
                else if(answer.equals("1")){
                    hit(monster);
                    System.out.println("You hit" + monster.getType() + "\nRemaining " + monster.getType() + " health: " + monster.getHealth());
                    if(monster.getHealth() <= 0){
                        System.out.println(monster.getType() +" died");
                        setMoney(getMoney() + monster.getMoneyToEarn());
                        if(monster.getArmorToEarn() != null){
                            armors.add(monster.getArmorToEarn());
                            allItems.add(monster.getArmorToEarn());
                            System.out.println("Earned armor: " + monster.getArmorToEarn().getName());
                        }
                        if(monster.getWeaponToEarn() != null){
                            weapons.add(monster.getWeaponToEarn());
                            allItems.add(monster.getWeaponToEarn());
                            System.out.println("Earned armor: " + monster.getArmorToEarn().getName());
                        }
                        break;
                    }
                    else{
                        monster.hit(this);
                        System.out.println(monster.getType() + " hit you\nRemainin health: " + getHealth());
                    }
                }
                else if(answer.equals("2")){
                    superHit(monster);
                    System.out.println("You hit" + monster.getType() + "\nRemaining " + monster.getType() + " health: " + monster.getHealth());
                    if(monster.getHealth() <= 0) {
                        System.out.println(monster.getType() +" died");
                        setMoney(getMoney() + monster.getMoneyToEarn());
                        if(monster.getArmorToEarn() != null){
                            armors.add(monster.getArmorToEarn());
                            allItems.add(monster.getArmorToEarn());
                            System.out.println("Earned armor: " + monster.getArmorToEarn().getName());
                        }
                        if(monster.getArmorToEarn() != null){
                            armors.add(monster.getArmorToEarn());
                            allItems.add(monster.getArmorToEarn());
                            System.out.println("Earned armor: " + monster.getArmorToEarn().getName());
                        }
                        break;
                    }
                    else{
                        monster.hit(this);
                        System.out.println("Monster hit you\nRemainin health: " + getHealth());
                    }
                }
                else if(answer.equals("3")) System.out.println("Your health: " + getHealth());
                else if(answer.equalsIgnoreCase("q")) {
                    System.out.println("Retreating..");
                    break;
                }
                else System.out.println("*****INVALID INPUT*****");
            }
        }
    
        @Override
        public void goTo(WarPlace warPlace){
            ArrayList<Monster> monsters = warPlace.getMonsters();
            System.out.println("You're in " + warPlace.getName() + "\n" +
                    "There are " + monsters.size() + " " + monsters.get(0).getType() + "s");
            for (int i = 1; i <= monsters.size(); i++) {
                if(monsters.get(i-1).getArmorToEarn() == null && monsters.get(i-1).getWeaponToEarn() == null){
                    System.out.println("**********\n" +
                                "Features of " + monsters.get(i-1).getType() + i + "\n" +
                                "Attack: " + monsters.get(i-1).getAttack() + "\n" +
                                "Defense: " + monsters.get(i-1).getDefense() + "\n" +
                                "Health: " + monsters.get(i-1).getHealth() + "\n" +
                                "Possible armor: None\n" +
                                "Possible weapon: None\n***************");
                    System.out.println(i + ". " + monsters.get(i-1).getType() + " has come.");
                    oneToOne(monsters.get(i-1));
                }
                else if(monsters.get(i-1).getArmorToEarn() != null && monsters.get(i-1).getWeaponToEarn() == null){
                    System.out.println("**********\n" +
                                "Features of " + monsters.get(i-1).getType() + i + "\n" +
                                "Attack: " + monsters.get(i-1).getAttack() + "\n" +
                                "Defense: " + monsters.get(i-1).getDefense() + "\n" +
                                "Health: " + monsters.get(i-1).getHealth() + "\n" +
                                "Possible armor: " + monsters.get(i-1).getArmorToEarn().getName() + "\n" +
                                "Possible weapon: None\n***************");
                    System.out.println(i + ". " + monsters.get(i-1).getType() + " has come.");
                    oneToOne(monsters.get(i-1));
                }
                else if(monsters.get(i-1).getArmorToEarn() == null && monsters.get(i-1).getWeaponToEarn() != null){
                    System.out.println("**********\n" +
                                "Features of " + monsters.get(i-1).getType() + i + "\n" +
                                "Attack: " + monsters.get(i-1).getAttack() + "\n" +
                                "Defense: " + monsters.get(i-1).getDefense() + "\n" +
                                "Health: " + monsters.get(i-1).getHealth() + "\n" +
                                "Possible armor: None\n" +
                                "Possible weapon: " + monsters.get(i-1).getWeaponToEarn().getName() + "\n***************");
                    System.out.println(i + ". " + monsters.get(i-1).getType() + " has come.");
                    oneToOne(monsters.get(i-1));
                }
                else{
                    System.out.println("**********\n" +
                                "Features of " + monsters.get(i-1).getType() + " " + i + "\n" +
                                "Attack: " + monsters.get(i-1).getAttack() + "\n" +
                                "Defense: " + monsters.get(i-1).getDefense() + "\n" +
                                "Health: " + monsters.get(i-1).getHealth() + "\n" +
                                "Possible armor: " + monsters.get(i-1).getArmorToEarn().getName() + "\n" +
                                "Possible weapon: " + monsters.get(i-1).getWeaponToEarn().getName() + "\n***************");
                    System.out.println(i + ". " + monsters.get(i-1).getType() + " has come.");
                    oneToOne(monsters.get(i-1));
                }   
            }
            if(monsters.get(monsters.size() - 1).getHealth() <= 0){
    
                String reward = warPlace.getReward().getName().toLowerCase();
    
                switch (reward) {
                    case "food" -> setFoodFound(true);
                    case "wood" -> setWoodFound(true);
                    case "steel" -> setSteelFound(true);
                }
            }
        }
    
        @Override
        public void goOnAdventure(){
            System.out.print("""
                    1. Cave
                    2. Forest
                    3. Graveyard
                    Q for previous menu
                    Press:\s""");
            answer = in.next();
            if(answer.equals("1")){
                goTo(new Cave());
            }
            else if(answer.equals("2")){
                goTo(new Forest());
            }
            else if(answer.equals("3")){
                goTo(new Graveyard());
            }
            else if(answer.equalsIgnoreCase("q")){
                System.out.println("Returning to previous menu");
            }
            else{
                System.out.println("*****Invalid input*****");
                goOnAdventure();
            } 
        }
    
        // Below is setter&getter Methods
    
    
        public Armor getWornArmor() {
            return wornArmor;
        }
    
        public void setWornArmor(Armor wornArmor) {
            this.wornArmor = wornArmor;
        }
    
        public Weapon getWornWeapon() {
            return wornWeapon;
        }
    
        public void setWornWeapon(Weapon wornWeapon) {
            this.wornWeapon = wornWeapon;
        }
    
        public ArrayList<Armor> getArmors() {
            return armors;
        }
    
        public void setArmors(ArrayList<Armor> armors) {
            this.armors = armors;
        }
    
        public ArrayList<Weapon> getWeapons() {
            return weapons;
        }
    
        public void setWeapons(ArrayList<Weapon> weapons) {
            this.weapons = weapons;
        }
    
        public void setAllItems() {
            for(Weapon weapon: weapons){
                allItems.add(weapon);
            }
            for (Armor armor: armors) {
                allItems.add(armor);
            }
        }
    
        public void setAllItems(ArrayList<Item> allItems){
            this.allItems = new ArrayList<>();
        }
    
        public ArrayList<Item> getAllItems(){
            return allItems;
        }
    
        public double getMoney() {
            return money;
        }
    
        public void setMoney(double money) {
            this.money = money;
        }
    
        public boolean getFoodFound() {
            return foodFound;
        }
    
        public void setFoodFound(boolean foodFound) {
            this.foodFound = foodFound;
        }
    
        public boolean getWoodFound() {
            return woodFound;
        }
    
        public void setWoodFound(boolean woodFound) {
            this.woodFound = woodFound;
        }
    
        public boolean getSteelFound() {
            return steelFound;
        }
    
        public void setSteelFound(boolean steelFound) {
            this.steelFound = steelFound;
        }
    
        public String getName(){
            return this.name;
        }
    
        public void setName(String name){
            this.name = name;
        }
    
        public int getInitialDefense(){
            return initialDefense;
        }
    
        public void setInitialDefense(int initialDefense){
            this.initialDefense = initialDefense;
        }
        public void setInitialAttack(int initialAttack){
            this.initialAttack = initialAttack;
        }
    
        public int getInitialAttack(){
            return initialAttack;
        }
    
}
