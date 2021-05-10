package projlab.skeleton.entities;

import projlab.skeleton.Game;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;

import java.util.ArrayList;
import java.util.Random;

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
    public void draw() {
        Random random = new Random();
        int x = random.nextInt(200) - 100 + 480;
        int y = random.nextInt(200) - 100 + 250;
        Game.robotDrawer.draw(this, x, y);
    }
}
