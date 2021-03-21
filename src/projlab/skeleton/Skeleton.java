package projlab.skeleton;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;

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
        settler.addResource(resource);
    }

    public void placeDownTeleportGate(){

    }
    
    public void robotDiggingNotRadioactiveOrWatericeAsteroid() {
    	Robot robot= new Robot();
        Coal coal= new Coal();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(robot);
        asteroid.setResource(coal);
    }
    
    public void robotDiggingRadioactiveAsteroid() {
    	Robot robot= new Robot();
        Uran uran= new Uran();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(robot);
        asteroid.setResource(uran);
    }
    
    public void robotDiggingWatericeAsteroid() {
    	Robot robot= new Robot();
        WaterIce waterice= new WaterIce();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(robot);
        asteroid.setResource(waterice);
    }
    
    public void settlerDiggingNotRadioactiveOrWatericeAsteroid() {
    	Settler settler= new Settler();
        Coal coal= new Coal();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(coal);
    }
    
    public void settlerDiggingRadioactiveAsteroid() {
    	Settler settler= new Settler();
        Uran uran= new Uran();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(uran);
    }
    
    public void settlerDiggingWatericeAsteroid() {
    	Settler settler= new Settler();
        WaterIce waterice= new WaterIce();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(waterice);
    }
}
