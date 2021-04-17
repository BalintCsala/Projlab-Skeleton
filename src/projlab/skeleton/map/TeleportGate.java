package projlab.skeleton.map;

import projlab.skeleton.entities.MovingEntity;

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
     * @param entity az érkező entitás
     */
    @Override
    public void addEntity(MovingEntity entity) {
        if (active) {
            teleportToPair(entity);
        }
    }

    /**
     * A teleportkapu párjára való átteleportálás
     * @param entity a teleportkaput használó entitás
     */
    private void teleportToPair(MovingEntity entity) {
        //TODO ezt már nem így működtetjük, nem stimmel. Honnét tudjuk mikor adjuk asteroidának és mikor a teleportpárnak
        neighbors.get(0).addEntity(entity);
    }

    /**
     * Beállítja a teleportkapu párját
     * @param teleport a teleportkapu párja
     */
    public void setPair(TeleportGate teleport) {
        pair = teleport;
    }

    /**
     * Megadja, hogy aktiv-e a teleportkapu
     * @return aktívság
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Beállítjuk a teleportkapu aktívságát
     * @param active a teleportkapu aktívsága
     */
    public void setActive(boolean active) {
        // Eggyezzen meg a pár aktivitása is
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
    public void crazyMove() {
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

    public Asteroid getAsteroid() {
        return asteroid;
    }
}
