package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
/**
 * 
 * Az entit�sok �ltal tart�zkod�sra haszn�lhat� objektumok �sszefog�sa
 *
 */
public abstract class Field {
/**
 * szomsz�dos Fieldek
 */
    private final ArrayList<Field> neighbors= new ArrayList<>();

    /**
     * szomsz�dos Field hozz�ad�sa
     * @param f a szomsz�d
     */
    public void addNeighbor(Field f) {
        FunctionPrinter.enter("Field", "addNeighbor");
        neighbors.add(f);
        FunctionPrinter.exit();
    }
/**
 *  szomsz�dos Field kiv�tele a szomsz�dok k�z�l
 * @param f a szomsz�d
 */
    public void removeNeighbor(Field f) {
        FunctionPrinter.enter("Field", "removeNeighbor");
        neighbors.remove(f);
        FunctionPrinter.exit();
    }
/**
 * Entit�sok �rkez�se
 * @param entity az �rkez� entit�s
 */
    public abstract void addEntity(Entity entity);
/**
 * Napvihar hat�sa a Fieldekre
 */
    public void solarFlare() {
        FunctionPrinter.enter("Field", "solarFlare");
        FunctionPrinter.exit();
    }
/**
 * Szomsz�dos robban�s hat�sa a Fieldekre
 */
    public void explodeReaction() {
        FunctionPrinter.enter("Field", "explodeReaction");
        FunctionPrinter.exit();
    }
/**
 * Visszaadja a Field szomsz�djait
 * @return a szomsz�dok
 */
    public ArrayList<Field> getNeighbors() {
        FunctionPrinter.enter("Field", "getNeighbors");
        FunctionPrinter.exit();
        return neighbors;
    }


}
