package projlab.skeleton.entities;

import projlab.skeleton.Game;
import projlab.skeleton.participants.AI;

import java.util.Random;

/**
 * Az ufókat jelképező osztály
 *
 */
public class Ufo extends MovingEntity implements MiningEntity {

    /**
     * Az ufo életben van-e vagy sem
     */
    private boolean alive = true;

    /**
     * Ufo konstruktora
     */
    public Ufo() {
        // Automatikusan adjuk hozzá az ufót az AI-hoz
        AI.getInstance().addUfo(this);
    }
    /**
     * Felülírja a MovingEntity dig() metódusát, nem csinál semmit, mivel az ufó nem tud fúrni
     */
    @Override
    public void dig() {
    }

    /**
     * Implementálja a MiningEntity mine() metódusát, kibányássza annak az aszteroidának
     * a nyersanyagát, ahol éppen tartózkodik az ufó
     */
    @Override
    public void mine() {
        // Bányásszuk ki az aszteroida nyersanyagát
        location.mineResource();
    }

    /**
     * Felülírja a MovingEntity die() metódusát, megöli(eltávolítja) az ufót
     */
    @Override
    public void die() {
        super.die();
        alive = false;
        AI.getInstance().removeUfo(this);
    }

    /**
     * Felülírja a MovingEntity explode() metódusát, megöli(eltávolítja) az ufót
     */
    @Override
    public void explode() {
        die();
    }

    @Override
    public void draw() {
        Random random = new Random();
        int x = random.nextInt(200) - 100 + 480;
        int y = random.nextInt(200) - 100 + 250;
        Game.ufoDrawer.draw(this, x, y);
    }
}
