package Place.WarPlace;

import java.util.ArrayList;
import Being.Monster.Vampire;
import Reward.Wood;

public class Forest extends WarPlace{


    public Forest(){

        setMonsters(new ArrayList<>());
        setNumberOfMonsters(1,4);
        
        for(int i = 0; i < getNumberOfMonsters(); i++){
            getMonsters().add(new Vampire());
        }

        setName("Forest");
        setReward(new Wood());

    }
    
}
