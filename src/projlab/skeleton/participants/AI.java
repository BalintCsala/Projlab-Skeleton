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
    private final ArrayList<Ufo> ufos = new ArrayList<>();

    /**
     * Privát konstruktor a singletonság kedvéért
     */
    private AI() {
    }

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
     * Eltávolít egy robotot a robotok listájából
     * @param robot Az eltávolítandó robot
     */
    public void removeRobot(Robot robot) {
        robots.remove(robot);
    }

    /**
     * Hozzáad egy ufot az AI-hoz
     * @param ufo A hozzáadandó ufo
     */
    public void addUfo(Ufo ufo) {
        ufos.add(ufo);
    }

    /**
     * Eltávolít egy ufo-t az AI-ból
     * @param ufo Az eltávolítandó ufo
     */
    public void removeUfo(Ufo ufo) {
        ufos.remove(ufo);
    }

}
