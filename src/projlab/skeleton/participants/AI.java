package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Ufo;
<<<<<<< HEAD

=======
import projlab.skeleton.map.Field;
>>>>>>> refs/remotes/origin/main

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

<<<<<<< HEAD
    /**
     * Az AI ufoi
     */
    
=======

>>>>>>> refs/remotes/origin/main
    private final ArrayList<Ufo> ufos = new ArrayList<>();

    /**
     * Priv√°t konstruktor a singletons√°g kedv√©√©rt
     */
    private AI() {
    }

    /**
     * A singleton design pattern getInstance met√≥dusa
     *
     * @return Az oszt√°ly singleton instance-e
     */
    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    /**
     * Hozz√°ad egy robotot a robotok list√°j√°hoz
     *
     * @param robot A hozz√°adand√≥ robot
     */
    public void addRobot(Robot robot) {
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
        robots.add(robot);
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }
<<<<<<< HEAD
    /**
     * Hozz√°ad egy ufot a ufok list√°j√°hoz
     * @param ufo A hozz√°adand√≥ ufo
     */
    
=======


>>>>>>> refs/remotes/origin/main
    public void addUfo(Ufo ufo) {

        ufos.add(ufo);

    }

    /**
     * Elt√°vol√≠t egy robotot a robotok list√°j√°b√≥l
     *
     * @param robot Az elt√°vol√≠tand√≥ robot
     */
    public void removeRobot(Robot robot) {
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
        robots.remove(robot);
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }
<<<<<<< HEAD
    /**
     * Elt√°vol√≠t egy ufot a ufok list√°j√°b√≥l
     * @param ufo Az elt√°vol√≠tand√≥ ufo
     */
=======

>>>>>>> refs/remotes/origin/main
    public void removeUfo(Ufo ufo) {
        ufos.remove(ufo);
    }
<<<<<<< HEAD
    /**
     * A robot lehetsÈges lÈpÈsei kˆz¸l lefuttat egyet
     * @param robot a robot melynek a kˆre vÈgrehajtÛdik
     */


	public void robotround(Robot robot) {
    	int scenario= 1;  // majd valahogy kisorsoljuk
    	
    	switch (scenario) {
        case 1:
        	robot.move(robot.getLocation().getNeighbors().get(0));//ezt lehet m·shogy kellene
=======

    @Override
    public void round() {
        for (Robot robot : robots) {
            robotround(robot);
        }
        for (Ufo ufo : ufos) {
            uforound(ufo);
        }
    }

    public void robotround(Robot robot) {
        Random random = new Random();
        int scenario = random.nextInt(2);

        switch (scenario) {
            case 0:
                List<Field> neighbors = robot.getLocation().getNeighbors();
                robot.move(neighbors.get(random.nextInt(neighbors.size())));
>>>>>>> refs/remotes/origin/main
            break;
            case 1:
                robot.dig();
                break;
        }
    }
<<<<<<< HEAD
    }
	/**
     * Az ufo lehetsÈges lÈpÈsei kˆz¸l lefuttat egyet
     * @param ufo az ufo melynek a kˆre vÈgrehajtÛdik
     */
=======

>>>>>>> refs/remotes/origin/main
    public void uforound(Ufo ufo) {
        Random random = new Random();
        int scenario = random.nextInt(2);
        switch (scenario) {
            case 0:
                ufo.mine();
                break;
            case 1:
                List<Field> neighbors = ufo.getLocation().getNeighbors();
                ufo.move(neighbors.get(random.nextInt(neighbors.size())));
                break;
        }
    }
<<<<<<< HEAD
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
    
=======
>>>>>>> refs/remotes/origin/main

}
