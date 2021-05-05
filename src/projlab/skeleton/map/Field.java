package projlab.skeleton.map;

import projlab.skeleton.entities.MovingEntity;

import java.util.ArrayList;

/**
 * Az entitások által tartózkodásra használható objektumok összefogása
 */
public abstract class Field {
    /**
     * szomszédos mezők
     */
    protected final ArrayList<Field> neighbors = new ArrayList<>();

    /**
     * Szomszédos Field hozzáadása
     *
     * @param f a szomszéd
     */
    public void addNeighbor(Field f) {
        neighbors.add(f);
    }

    /**
     * Szomszédos Field kivétele a szomszédok közül
     *
     * @param f a szomszéd
     */
    public void removeNeighbor(Field f) {
        neighbors.remove(f);
    }

    /**
     * Entitások érkezése
     *
     * @param entity az érkező entitás
     */
    public abstract void addEntity(MovingEntity entity);

    /**
     * Napvihar hatása a Fieldekre
     */
    public abstract void solarFlare();

    /**
     * Szomszédos robbanás hatása a Fieldekre
     */
    public void explodeReaction() {
    }

    /**
     * Visszaadja a Field szomszédjait
     *
     * @return a szomszédok
     */
    public ArrayList<Field> getNeighbors() {
        return neighbors;
    }

    /**
     * Lefuttat egy kört a mezőn
     */
    public void round() {

    }

}
