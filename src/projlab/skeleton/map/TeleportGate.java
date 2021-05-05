package projlab.skeleton.map;

import projlab.skeleton.entities.MovingEntity;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * Teleportkapuk megtestesítése
 */
public class TeleportGate extends Field {
    /**
     * A teleportkapu párja
     */
    private TeleportGate pair;
    private boolean active = false;
    private boolean crazy = false;
    private Asteroid asteroid;

    /**
     * Mmegszűnik létezni a teleportkapu
     */
    public void die() {
        active = false;
        for (Field neighbor : neighbors) {
            neighbor.removeNeighbor(this);
        }
    }

    /**
     * Reagálás az aszteroidájának felrobbanására
     */
    @Override
    public void explodeReaction() {
        pair.die();
        this.die();
    }

    /**
     * Az teleportkapura entitás érkezik
     *
     * @param entity az érkező entitás
     */
    @Override
    public void addEntity(MovingEntity entity) {
        if (active) {
            pair.teleportToPair(entity);
        }
    }

    /**
     * A teleportkapu párjára való átteleportálás
     *
     * @param entity a teleportkaput használó entitás
     */
    private void teleportToPair(MovingEntity entity) {
        asteroid.addEntity(entity);
    }

    /**
     * Beállítja a teleportkapu párját
     *
     * @param teleport a teleportkapu párja
     */
    public void setPair(TeleportGate teleport) {
        pair = teleport;
    }

    /**
     * Megadja, hogy aktiv-e a teleportkapu
     *
     * @return aktívság
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Beállítjuk a teleportkapu aktívságát
     *
     * @param active a teleportkapu aktívsága
     */
    public void setActive(boolean active) {
        // Eggyezzen meg a pár aktivitása is
        this.active = active;
        if (active) {
            if (!pair.isActive())
                pair.setActive(true);
        } else {
            if (pair.isActive())
                pair.setActive(false);
        }
    }

    @Override
    public void solarFlare() {
        crazy = true;
    }

    /**
     * Megmozgatja a teleportot, ha az megőrült
     */
    @Override
    public void round() {
        if (crazy) {
            for (Field f : asteroid.getNeighbors()) {
                if (f instanceof Asteroid) {
                    asteroid.removeNeighbor(this);
                    asteroid = (Asteroid) f;
                    asteroid.addNeighbor(this);
                    return;
                }
            }
        }
    }

    public void setAsteroid(Asteroid asteroid) {
        this.asteroid = asteroid;
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }
<<<<<<< HEAD
    public void setAsteroid(Asteroid a) {
        asteroid = a;
    }
    public TeleportGate getPair() {
        return pair;
=======

    @Override
    public String toString() {
        return "type: TeleportGate\n" +
                "name: " + ObjectCatalog.getName(this) + "\n" +
                "pair: " + ObjectCatalog.getName(pair) + "\n" +
                "asteroid name: " + ObjectCatalog.getName(asteroid) + "\n" +
                "isActive: " + active + "\n" +
                "isCrazy: " + crazy;
>>>>>>> refs/remotes/origin/main
    }
}
