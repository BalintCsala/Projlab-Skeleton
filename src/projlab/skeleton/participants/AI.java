package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Ufo;
import projlab.skeleton.map.Field;

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

    /**
     * Az AI ufói
     */
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
        robots.add(robot);
    }


    public void addUfo(Ufo ufo) {
        ufos.add(ufo);
    }

    /**
     * Eltávolít egy robotot a robotok listájából
     *
     * @param robot Az eltávolítandó robot
     */
    public void removeRobot(Robot robot) {
        robots.remove(robot);
    }

    /**
     * Eltávoliít egy ufót az ufók listájából
     * @param ufo az eltávolítandó ufó
     */
    public void removeUfo(Ufo ufo) {
        ufos.remove(ufo);
    }

    /**
     * Az összes roboton és ufón lefuttat egy kört
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

    /**
     * A robotok körét kezeli, eldönti, hogy az adott körben mit fog csinálni az adott robot(mozogni/fúrni)
     * @param robot az adott robot, aminek a körét kezeljük
     */
    public void robotround(Robot robot) {
        Random random = new Random();
        int scenario = random.nextInt(2);

        switch (scenario) {
            case 0:
                List<Field> neighbors = robot.getLocation().getNeighbors();
                robot.move(neighbors.get(random.nextInt(neighbors.size())));
            break;
            case 1:
                robot.dig();
                break;
        }
    }

    /**
     * Az ufók körét kezeli, eldönti, hogy az adott körben mit fog csinálni az adott ufó(bányászni/mozogni)
     * @param ufo az adott ufó, aminek a körét kezeljük
     */
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

}
