package projlab.skeleton.entities;

import projlab.skeleton.utils.ObjectCatalog;

public class Ufo extends MovingEntity implements MiningEntity {

    private boolean alive = true;

    @Override
    public void dig() {

    }

    @Override
    public void mine() {
        // Bányásszuk ki az aszteroida nyersanyagát
        location.mineResource();
    }

    @Override
    public void die() {
        super.die();
        alive = false;
    }

    @Override
    public void explode() {
        die();
    }

    @Override
    public String toString() {
        return "type: Ufo\n" +
                "name: " + ObjectCatalog.getName(this) + "\n" +
                "alive: " + alive;
    }
}
