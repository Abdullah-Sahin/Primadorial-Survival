package Test;

import Being.Individual.Individual;
import Place.Town.BlackSmith;
import Place.Town.Shop;

import java.util.Scanner;

public class Game {

    public static void play(Individual individual){
            Scanner in = new Scanner(System.in);
            String answer;
            while(true){
                if(individual.getHealth() <= 0){
                    System.out.println("You died\n GAME OVER");
                    break;
                }
                if(individual.getFoodFound() && individual.getWoodFound() && individual.getSteelFound()){
                    System.out.println("All necessary materials accumulated.\n YOU WIN");
                    break;
                }
                System.out.println("----------\nHey " +individual.getName() + "! You are in town centre\nWhat would you like to do?\n----------");
                System.out.println("""
                        1. See individual details
                        2. Town actions
                        3. Go on an adventure
                        4. Wear Armor
                        5. Wear Weapon
                        Q to quit game
                        ----------""");
                System.out.print("Press: "); 
                answer = in.next();
                System.out.println("----------");
                if(answer.equals("1")){
                    individual.showAllDetails();
                }
                else if(answer.equals("2")){
                    while(true){
                        System.out.println("""
                                    1. To go Shop
                                    2. To go BlackSmith
                                    3. To go home and rest
                                    Q  To return Town Centre
                                    ----------""");
                        System.out.print("Press: ");
                        answer = in.next();
                        System.out.println("-----------");
                        if (answer.equalsIgnoreCase("q")) {
                            break;
                        }
                        else if(answer.equals("1")){
                            Shop.shopping(individual);
                        }
                        else if(answer.equals("2")){
                            while(true){
                                BlackSmith.ask();
                                answer = in.next();
                                if(answer.equalsIgnoreCase("q")){
                                    break;
                                }
                                switch(answer){
                                    case "1" -> individual.upgradeArmor();
                                    case "2" -> individual.upgradeWeapon();                                    
                                    default -> System.out.println("*****INVALID INPUT*****");
                                }
                            }
                        }
                        else if(answer.equals("3")){
                            individual.rest();
                        }
                        else{
                            System.out.println("*****INVALID INPUT*****");
                        }
                    }
                }
                else if(answer.equals("3")){
                    individual.goOnAdventure();
                }
                else if(answer.equals("4")){
                    individual.wearArmor();
                }
                else if(answer.equals("5")){
                    individual.wearWeapon();
                }
                else if(answer.equalsIgnoreCase("q")) {
                    System.out.println("Game was ended by user");
                    break;
                }
                else{
                    System.out.println("*****INVALID INPUT*****");
                }
                              
            }
            in.close();   
    }
}
