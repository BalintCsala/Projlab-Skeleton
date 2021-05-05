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

<<<<<<< HEAD
    /**
     * Az AI ufoi
     */
    
=======

>>>>>>> refs/remotes/origin/main
    private final ArrayList<Ufo> ufos = new ArrayList<>();

    /**
     * Privát konstruktor a singletonság kedvéért
     */
    private AI() {
    }

    /**
     * A singleton design pattern getInstance metódusa
     *
     * @return Az osztály singleton instance-e
     */
    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    /**
     * Hozzáad egy robotot a robotok listájához
     *
     * @param robot A hozzáadandó robot
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
     * Hozzáad egy ufot a ufok listájához
     * @param ufo A hozzáadandó ufo
     */
    
=======


>>>>>>> refs/remotes/origin/main
    public void addUfo(Ufo ufo) {

        ufos.add(ufo);

    }

    /**
     * Eltávolít egy robotot a robotok listájából
     *
     * @param robot Az eltávolítandó robot
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
     * Eltávolít egy ufot a ufok listájából
     * @param ufo Az eltávolítandó ufo
     */
=======

>>>>>>> refs/remotes/origin/main
    public void removeUfo(Ufo ufo) {
        ufos.remove(ufo);
    }
<<<<<<< HEAD
    /**
     * A robot lehets�ges l�p�sei k�z�l lefuttat egyet
     * @param robot a robot melynek a k�re v�grehajt�dik
     */


	public void robotround(Robot robot) {
    	int scenario= 1;  // majd valahogy kisorsoljuk
    	
    	switch (scenario) {
        case 1:
        	robot.move(robot.getLocation().getNeighbors().get(0));//ezt lehet m�shogy kellene
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
     * Az ufo lehets�ges l�p�sei k�z�l lefuttat egyet
     * @param ufo az ufo melynek a k�re v�grehajt�dik
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
    
=======
>>>>>>> refs/remotes/origin/main

}
