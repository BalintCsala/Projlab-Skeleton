package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
/**
 * 
 * Az entitások által tartózkodásra használható objektumok összefogása
 *
 */
public abstract class Field {
/**
 * szomszédos Fieldek
 */
    private final ArrayList<Field> neighbors= new ArrayList<>();

    /**
     * szomszédos Field hozzáadása
     * @param f a szomszéd
     */
    public void addNeighbor(Field f) {
        FunctionPrinter.enter("Field", "addNeighbor");
        neighbors.add(f);
        FunctionPrinter.exit();
    }
/**
 *  szomszédos Field kivétele a szomszédok közül
 * @param f a szomszéd
 */
    public void removeNeighbor(Field f) {
        FunctionPrinter.enter("Field", "removeNeighbor");
        neighbors.remove(f);
        FunctionPrinter.exit();
    }
/**
 * Entitások érkezése
 * @param entity az érkezõ entitás
 */
    public abstract void addEntity(Entity entity);
/**
 * Napvihar hatása a Fieldekre
 */
    public void solarFlare() {
        FunctionPrinter.enter("Field", "solarFlare");
        FunctionPrinter.exit();
    }
/**
 * Szomszédos robbanás hatása a Fieldekre
 */
    public void explodeReaction() {
        FunctionPrinter.enter("Field", "explodeReaction");
        FunctionPrinter.exit();
    }
/**
 * Visszaadja a Field szomszédjait
 * @return a szomszédok
 */
    public ArrayList<Field> getNeighbors() {
        FunctionPrinter.enter("Field", "getNeighbors");
        FunctionPrinter.exit();
        return neighbors;
    }


}
