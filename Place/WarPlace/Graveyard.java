package Place.WarPlace;

import java.util.ArrayList;
import Being.Monster.Zombie;
import Reward.Steel;

public class Graveyard extends WarPlace {


    public Graveyard(){

        setNumberOfMonsters(2,5);

        setMonsters(new ArrayList<>());

        for(int i = 0; i < getNumberOfMonsters(); i++){
            getMonsters().add(new Zombie());
        }

        setName("Greaveyard");

        setReward(new Steel());

    }
}
