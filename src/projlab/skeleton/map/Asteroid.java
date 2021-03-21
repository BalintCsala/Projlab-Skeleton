package projlab.skeleton;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.map.Field;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class Asteroid extends Field {

    private Resource resource;
    private final ArrayList<Entity> entities = new ArrayList<>();

    @Override
    public void solarFlare() {
        FunctionPrinter.enter("Asteroid", "solarFlare");
        FunctionPrinter.msg("El lehet rajtam bujni? (I/N)");
        boolean hollow = new Scanner(System.in).next().equals("I");
        if (!hollow) {
            for (Entity entity : entities) {
                entity.die();
            }
        }

        FunctionPrinter.exit();
    }

    public void explode() {
        FunctionPrinter.enter("Asteroid", "explode");

        for (Entity entity : entities) {
            entity.explode();
            removeEntity(entity);
        }

        for (Field neighbor : getNeighbors()) {
            neighbor.removeNeighbor(this);
            neighbor.explodeReaction();
        }

        FunctionPrinter.exit();
    }

    public Resource mineResource() {
        FunctionPrinter.enter("Asteroid", "mineResource");
        if (getLayerDepth() != 0)
            return null;

        Resource res = resource;
        setResource(null);
        FunctionPrinter.exit();
        return res;
    }

    public void digLayer() {  //if
        FunctionPrinter.enter("Asteroid", "diglayer");
        FunctionPrinter.msg("Napközelben vagyunk és a réteg 0? (I/N)");
        String choice = new Scanner(System.in).next();
        if (choice.equals("I")) {
            resource.reaction(this);
        }

        FunctionPrinter.exit();
    }

    public boolean checkEnoughResources(BillOfResources winBill) {
        FunctionPrinter.enter("Asteroid", "checkEnoughResources");
        FunctionPrinter.msg("Van eleg nyersanyag az aszteroidan? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }

    public void removeEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "removeEntity");
        entities.remove(entity);
        FunctionPrinter.exit();
    }

    @Override
    public void addEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "addEntity");
        entities.add(entity);
        entity.setLocation(this);
        FunctionPrinter.exit();
    }

    public Resource getResource() {
        FunctionPrinter.enter("Asteroid", "getResource");
        FunctionPrinter.exit();
        return resource;
    }

    public void setResource(Resource res) {
        FunctionPrinter.enter("Asteroid", "setResource");
        resource = res;
        FunctionPrinter.exit();
    }

    public int getLayerDepth() {
        FunctionPrinter.enter("Asteroid", "getLayerDepth");
        FunctionPrinter.msg("Milyen vastag legyen az aszteroida kerge?");
        int depth = (new Scanner(System.in)).nextInt();
        FunctionPrinter.exit();
        return depth;
    }

    public boolean getIsNearSun() {
        FunctionPrinter.enter("Asteroid", "getIsNearSun");
        boolean nearSun = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return nearSun;
    }
}
