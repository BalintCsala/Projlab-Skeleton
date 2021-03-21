package projlab.skeleton;

import projlab.skeleton.Asteroid;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.Resource;

public class Skeleton {

    public void settlerMines (){
        Settler settler= new Settler();
        Iron resource= new Iron();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(resource);
    }
    public void placeDownNotRadioactiveOrWatericeResource(){
        Iron resource= new Iron();
        Settler settler= new Settler();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);

    }
}
