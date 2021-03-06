package projlab.skeleton.map;

import projlab.skeleton.Game;
import projlab.skeleton.entities.MovingEntity;

/**
 * Teleportkapuk megtestesítése
 */
public class TeleportGate extends Field {
    /**
     * A teleportkapu párja
     */
    private TeleportGate pair;
    /**
     * Teleportkapu aktív-e
     */
    private boolean active = false;
    /**
     * Teleportkapu megkergült-e vagy sem
     */
    private boolean crazy = false;
    /**
     * Teleportkapuhoz tartozó aszteroida
     */
    private Asteroid asteroid;

    /**
     * Megszűnik létezni a teleportkapu
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

    /**
     * Teleportkapu aszteroidájának beállítása
     * 
     * @param asteroid teleportkapu aszteroidája
     */
    public void setAsteroid(Asteroid asteroid) {
        this.asteroid = asteroid;
    }

    /**
     * Teleportkapu aszteroidájának lekérdezése
     * 
     * @return teleportkapu aszteroidája
     */
    public Asteroid getAsteroid() {
        return asteroid;
    }

    /**
     * Teleportkapu párjának lekérdezése
     * 
     * @return teleportkapu párja
     */
    public TeleportGate getPair() {
        return pair;
    }

    /**
     * Rajzoló metódus
     */
    @Override
    public void draw() {

    }

    /**
     * Visszaadja, hogy megkergült-e a teleportkapu
     * 
     * @return megkergült-e a teleportkapu vagy sem
     */
    public boolean isCrazy() {
        return crazy;
    }

    @Override
    public void drawAsNeighbor(int x, int y) {
        Game.neighborTeleportDrawer.draw(this, x, y);
    }
}
