package Place.WarPlace;

import java.util.ArrayList;
import java.util.Random;

import Being.Monster.Monster;
import Place.Place;
import Reward.Reward; 

public abstract class WarPlace extends Place {
    
    private ArrayList<Monster> monsters;
    private int numberOfMonsters;
    private Reward reward;
    private static final Random random = new Random();

    public ArrayList<Monster> getMonsters(){
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters){
        this.monsters = monsters;
    }

    public int getNumberOfMonsters(){
        return numberOfMonsters;
    }

    public void setNumberOfMonsters(int origin, int bound){
        this.numberOfMonsters = random.nextInt(origin ,bound);
    }

    public Reward getReward(){
        return reward;
    }

    public void setReward(Reward reward){
        this.reward = reward;
    }

    public static Random getRandom(){
        return random;
    }

}
