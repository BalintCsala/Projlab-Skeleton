package projlab.skeleton.entities;

import projlab.skeleton.participants.AI;

public class Ufo extends MovingEntity implements MiningEntity {

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

}
