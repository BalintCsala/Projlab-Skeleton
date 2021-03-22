package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

public abstract class Field {

    protected final ArrayList<Field> neighbors = new ArrayList<>();

    public void addNeighbor(Field f) {
        FunctionPrinter.enter("Field", "addNeighbor", this, f);
        neighbors.add(f);
        FunctionPrinter.exit();
    }

    public void removeNeighbor(Field f) {
        FunctionPrinter.enter("Field", "removeNeighbor", this, f);
        neighbors.remove(f);
        FunctionPrinter.exit();
    }

    public abstract void addEntity(Entity entity);

    public void solarFlare() {
        FunctionPrinter.enter("Field", "solarFlare", this);
        FunctionPrinter.exit();
    }

    public void explodeReaction() {
        FunctionPrinter.enter("Field", "explodeReaction", this);
        FunctionPrinter.exit();
    }

    public ArrayList<Field> getNeighbors() {
        FunctionPrinter.enter("Field", "getNeighbors", this);
        FunctionPrinter.exit();
        return neighbors;
    }


}
