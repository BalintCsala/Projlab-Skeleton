package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Asteroid extends Field {

    private Resource resource;
    private final ArrayList<Entity> entities = new ArrayList<>();

    @Override
    public void solarFlare() {
        FunctionPrinter.enter("Asteroid", "solarFlare", this);
        FunctionPrinter.ask("El lehet rajtam bujni? (I/N)");
        boolean hollow = new Scanner(System.in).next().equals("I");
        if (!hollow) {
            ArrayList<Entity> temp = new ArrayList<>(entities);
            for (Entity entity : temp) {
                entity.die();
                entities.remove(entity);
            }
        }

        FunctionPrinter.exit();
    }

    public void explode() {
        FunctionPrinter.enter("Asteroid", "explode", this);

        ArrayList<Entity> temp = new ArrayList<>(entities);
        for (Entity entity : temp) {
            entity.explode();
        }

        for (Field neighbor : neighbors) {
            neighbor.removeNeighbor(this);
            neighbor.explodeReaction();
        }

        FunctionPrinter.exit();
    }

    public Resource mineResource() {
        FunctionPrinter.enter("Asteroid", "mineResource", this);
        if (getLayerDepth() != 0)
            return null;

        Resource res = resource;
        setResource(null);
        FunctionPrinter.exit();
        return res;
    }

    public void digLayer() {  //if
        FunctionPrinter.enter("Asteroid", "diglayer", this);
        FunctionPrinter.ask("Napkozelben vagyunk es a reteg 0? (I/N)");
        String choice = new Scanner(System.in).next();
        if (choice.equals("I")) {
            resource.reaction(this);
        }

        FunctionPrinter.exit();
    }

    public boolean checkEnoughResources(BillOfResources winBill) {
        FunctionPrinter.enter("Asteroid", "checkEnoughResources", this, winBill);
        FunctionPrinter.ask("Van eleg nyersanyag az aszteroidan? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }

    public void removeEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "removeEntity", this, entity);
        entities.remove(entity);
        FunctionPrinter.exit();
    }

    @Override
    public void addEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "addEntity", this, entity);
        entities.add(entity);
        entity.setLocation(this);
        FunctionPrinter.exit();
    }

    public Resource getResource() {
        FunctionPrinter.enter("Asteroid", "getResource", this);
        FunctionPrinter.exit();
        return resource;
    }

    public void setResource(Resource res) {
        FunctionPrinter.enter("Asteroid", "setResource", this, res);
        resource = res;
        FunctionPrinter.exit();
    }

    public int getLayerDepth() {
        FunctionPrinter.enter("Asteroid", "getLayerDepth", this);
        FunctionPrinter.ask("Milyen vastag legyen az aszteroida kerge?");
        int depth = (new Scanner(System.in)).nextInt();
        FunctionPrinter.exit();
        return depth;
    }

    public boolean getIsNearSun() {
        FunctionPrinter.enter("Asteroid", "getIsNearSun", this);
        FunctionPrinter.ask("Kozel van az aszteroida a naphoz? (I/N)");
        boolean nearSun = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return nearSun;
    }
}
