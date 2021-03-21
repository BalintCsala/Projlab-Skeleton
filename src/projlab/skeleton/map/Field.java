package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

public abstract class Field {

    private final ArrayList<Field> neighbors= new ArrayList<>();

    public void addNeighbor(Field f) {
        FunctionPrinter.enter("Field", "addNeighbor");
        neighbors.add(f);
        FunctionPrinter.exit();
    }

    public void removeNeighbor(Field f) {
        FunctionPrinter.enter("Field", "removeNeighbor");
        neighbors.remove(f);
        FunctionPrinter.exit();
    }

    public abstract void addEntity(Entity entity);

    public void solarFlare() {
        FunctionPrinter.enter("Field", "solarFlare");
        FunctionPrinter.exit();
    }

    public void explodeReaction() {
        FunctionPrinter.enter("Field", "explodeReaction");
        FunctionPrinter.exit();
    }

    public ArrayList<Field> getNeighbors() {
        FunctionPrinter.enter("Field", "getNeighbors");
        FunctionPrinter.exit();
        return neighbors;
    }


}
