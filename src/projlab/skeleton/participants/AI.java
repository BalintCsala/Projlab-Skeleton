package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Ufo;


import java.util.ArrayList;

/**
 * A mesterséges intelligenciát kezelő, singleton osztály
 */
public class AI extends Participant {

    /**
     * Az AI singleton instance-e
     */
    private static AI instance;

    /**
     * Az AI robotjai
     */
    private final ArrayList<Robot> robots = new ArrayList<>();

    /**
     * Az AI ufoi
     */
    
    private final ArrayList<Ufo> ufos = new ArrayList<>();
    /**
     * Privát konstruktor a singletonság kedvéért
     */
    private AI() { }

    /**
     * A singleton design pattern getInstance metódusa
     * @return Az osztály singleton instance-e
     */
    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    /**
     * Hozzáad egy robotot a robotok listájához
     * @param robot A hozzáadandó robot
     */
    public void addRobot(Robot robot) {
       
        robots.add(robot);
       
    }
    /**
     * Hozzáad egy ufot a ufok listájához
     * @param ufo A hozzáadandó ufo
     */
    
    public void addUfo(Ufo ufo) {
        
        ufos.add(ufo);
        
    }
    
    /**
     * Eltávolít egy robotot a robotok listájából
     * @param robot Az eltávolítandó robot
     */
    public void removeRobot(Robot robot) {
       
        robots.remove(robot);
       
    }
    /**
     * Eltávolít egy ufot a ufok listájából
     * @param ufo Az eltávolítandó ufo
     */
    public void removeUfo(Ufo ufo) {
        
        ufos.remove(ufo);
        
    }
    /**
     * A robot lehets�ges l�p�sei k�z�l lefuttat egyet
     * @param robot a robot melynek a k�re v�grehajt�dik
     */


	public void robotround(Robot robot) {
    	int scenario= 1;  // majd valahogy kisorsoljuk
    	
    	switch (scenario) {
        case 1:
        	robot.move(robot.getLocation().getNeighbors().get(0));//ezt lehet m�shogy kellene
            break;
        case 2:
            robot.dig();
            break;
        
      
    }
    }
	/**
     * Az ufo lehets�ges l�p�sei k�z�l lefuttat egyet
     * @param ufo az ufo melynek a k�re v�grehajt�dik
     */
    public void uforound(Ufo ufo) {
    	int scenario=1;// majd valahogy kisorsoljuk
    switch (scenario) {
    case 1:
       ufo.mine();
        break;
    case 2:
        ufo.move(ufo.getLocation().getNeighbors().get(0));
        break;
    
  
    }
}
    
    
    /**
     * Lefuttatja a robots lista elemein  a robotok k�r�t
     * Lefuttatja a ufos lista elemein  a ufok k�r�t
     */
    @Override
    public void round() {
    	for (Robot robot : robots) {
            robotround(robot);
        }
    	for (Ufo ufo : ufos) {
            uforound(ufo);
        }
    	
    	
    }
    

}
