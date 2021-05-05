package projlab.skeleton.entities;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

import java.util.ArrayList;

/**
 * A robot entitást jelképező
 */
public class Robot extends MovingEntity {

    /**
     * A robot konstruktora
     */
    public Robot() {
        // Automatikusan adjuk hozzá a robotot az AI-hoz
        AI.getInstance().addRobot(this);
    }

    /**
     * Lekezeli a robot felrobbanását
     */
    public void explode() {
        ArrayList<Field> neighbors = location.getNeighbors();
        // Ha van szomszédos aszteroida, rakjuk át rá a robotot, egyébként haljon meg
        if (neighbors.isEmpty()) {
            die();
        } else {
            move(neighbors.get(0));
        }
    }

    /**
     * A robot halálát implementáló metódus
     */
    @Override
    public void die() {
        super.die();
        AI.getInstance().removeRobot(this);
    }

    @Override
    public String toString() {
        return "type: Robot\n" +
                "name: " + ObjectCatalog.getName(this);
    }
}
