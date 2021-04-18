package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Ufo;


import java.util.ArrayList;

/**
 * A mesters√©ges intelligenci√°t kezel≈ë, singleton oszt√°ly
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
     * Priv√°t konstruktor a singletons√°g kedv√©√©rt
     */
    private AI() { }

    /**
     * A singleton design pattern getInstance met√≥dusa
     * @return Az oszt√°ly singleton instance-e
     */
    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    /**
     * Hozz√°ad egy robotot a robotok list√°j√°hoz
     * @param robot A hozz√°adand√≥ robot
     */
    public void addRobot(Robot robot) {
       
        robots.add(robot);
       
    }
    /**
     * Hozz√°ad egy ufot a ufok list√°j√°hoz
     * @param ufo A hozz√°adand√≥ ufo
     */
    
    public void addUfo(Ufo ufo) {
        
        ufos.add(ufo);
        
    }
    
    /**
     * Elt√°vol√≠t egy robotot a robotok list√°j√°b√≥l
     * @param robot Az elt√°vol√≠tand√≥ robot
     */
    public void removeRobot(Robot robot) {
       
        robots.remove(robot);
       
    }
    /**
     * Elt√°vol√≠t egy ufot a ufok list√°j√°b√≥l
     * @param ufo Az elt√°vol√≠tand√≥ ufo
     */
    public void removeUfo(Ufo ufo) {
        
        ufos.remove(ufo);
        
    }
    /**
     * A robot lehetsÈges lÈpÈsei kˆz¸l lefuttat egyet
     * @param robot a robot melynek a kˆre vÈgrehajtÛdik
     */


	public void robotround(Robot robot) {
    	int scenario= 1;  // majd valahogy kisorsoljuk
    	
    	switch (scenario) {
        case 1:
        	robot.move(robot.getLocation().getNeighbors().get(0));//ezt lehet m·shogy kellene
            break;
        case 2:
            robot.dig();
            break;
        
      
    }
    }
	/**
     * Az ufo lehetsÈges lÈpÈsei kˆz¸l lefuttat egyet
     * @param ufo az ufo melynek a kˆre vÈgrehajtÛdik
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
     * Lefuttatja a robots lista elemein  a robotok kˆrÈt
     * Lefuttatja a ufos lista elemein  a ufok kˆrÈt
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
