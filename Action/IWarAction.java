package Action;

import Being.Monster.Monster;
import Place.WarPlace.WarPlace;

public interface IWarAction {

    public void goOnAdventure();
    public void goTo(WarPlace warPlace);
    public void superHit(Monster monster);
    public void withdraw();
    public void hit(Monster monster);
    
}
