package Place.WarPlace;

import java.util.ArrayList;
import Being.Monster.Snake;
import Reward.Food;

public class Cave extends WarPlace{

    public Cave(){
        
        setNumberOfMonsters(1,3);

        setMonsters(new ArrayList<>());
        
        for(int i = 0; i < getNumberOfMonsters(); i++){
            getMonsters().add(new Snake());
        }

        setReward(new Food());

        setName("Cave");

    }
    
}
