package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * Ez az osztály az Aszteroidákat testesíti meg
 *
 */
public class Asteroid extends Field {
    /**
     * az aszteroida nyersanyaga
     */
    private Resource resource;
    /**
     * az aszteroidán tartózkodó entitások
     */
    private final ArrayList<Entity> entities = new ArrayList<>();
    /**
     * Napvihar hatása az aszteroidára, amennyiben nem lehet elbújni az aszteroidán,
     *  a rajta tartózkodó entitások meghalnak
     */
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
    /**
     * az aszteroida felrobban, a rajta tartózkodó entitások meghalnak,
     * az aszteroida szomszédjai reagálnak a robbanásra és megszûntetik szomszédságukat az aszteroidával
     * 
     */
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
    /**
     * Az aszteroida bányászása amennyiben nincs több rétege,
     *  bányászható és visszaadja az aszteroida nyersanyagát
     * @return Resource 
     */
    public Resource mineResource() {
        FunctionPrinter.enter("Asteroid", "mineResource");
        if (getLayerDepth() != 0)
            return null;

        Resource res = resource;
        setResource(null);
        FunctionPrinter.exit();
        return res;
    }
/**
 * Aszteroida rétegének csökkentése, amennyiben Napközelben vagyunk és a réteg 0
 * az aszteroida nyersanyaga reagál
 * 
 */
    public void digLayer() {  //if
        FunctionPrinter.enter("Asteroid", "diglayer");
        FunctionPrinter.msg("Napközelben vagyunk és a réteg 0? (I/N)");
        String choice = new Scanner(System.in).next();
        if (choice.equals("I")) {
            resource.reaction(this);
        }

        FunctionPrinter.exit();
    }
/**
 * Gyõzele  vizsgálata aszteroidán
 * @param winBill a gyõzelemhez szükséges nyersanyagok
 * @return visszaadja, hogy van-e elég nyersanyag az aszteroidán a gyõzelemhez
 */
    public boolean checkEnoughResources(BillOfResources winBill) {
        FunctionPrinter.enter("Asteroid", "checkEnoughResources");
        FunctionPrinter.msg("Van eleg nyersanyag az aszteroidan? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }
/**
 * Egy entitás eltávozása az aszteroidáról
 * @param entity az eltávozó entitás
 */
    public void removeEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "removeEntity");
        entities.remove(entity);
        FunctionPrinter.exit();
    }
/**
 * Az aszteroidára entitás érkezik
 * @param entity  az érkezõ entitás
 */
    @Override
    public void addEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "addEntity");
        entities.add(entity);
        entity.setLocation(this);
        FunctionPrinter.exit();
    }
/**
 *  Visszaadja az aszteroida nyersanyagát
 * @return resource az aszteroida nyersanyaga
 */
    public Resource getResource() {
        FunctionPrinter.enter("Asteroid", "getResource");
        FunctionPrinter.exit();
        return resource;
    }
/**
 * Az aszteroida nyersanyagának beállítása
 * @param res a beállítandó nyersanyag
 */
    public void setResource(Resource res) {
        FunctionPrinter.enter("Asteroid", "setResource");
        resource = res;
        FunctionPrinter.exit();
    }
/**
 * az aszteroida rétegének visszaadása
 * @return  az aszteroida rétege
 */
    public int getLayerDepth() {
        FunctionPrinter.enter("Asteroid", "getLayerDepth");
        FunctionPrinter.msg("Milyen vastag legyen az aszteroida kerge?");
        int depth = (new Scanner(System.in)).nextInt();
        FunctionPrinter.exit();
        return depth;
    }
/**
 * Visszaadja azt, hogy az aszteroida Napközelben van-e
 * @return napközelben vagy sem
 */
    public boolean getIsNearSun() {
        FunctionPrinter.enter("Asteroid", "getIsNearSun");
        boolean nearSun = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return nearSun;
    }
}
