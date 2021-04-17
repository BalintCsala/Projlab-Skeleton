package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Random;
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
    private boolean nearSun;
    private int depth;


    public Asteroid(){
        depth=new Random().nextInt(10);
        nearSun=new Random().nextBoolean();
    }
    @Override
    public void solarFlare() {

        boolean hollow = depth==0;
        if (!hollow) {
            ArrayList<Entity> temp = new ArrayList<>(entities);
            for (Entity entity : temp) {
                entity.die();
                entities.remove(entity);
            }
        }
    }
    /**
     * az aszteroida felrobban, a rajta tartózkodó entitások meghalnak,
     * az aszteroida szomszédjai reagálnak a robbanásra és megszûntetik szomszédságukat az aszteroidával
     * 
     */
    public void explode() {

        ArrayList<Entity> temp = new ArrayList<>(entities);
        for (Entity entity : temp) {
            entity.explode();
        }

        for (Field neighbor : neighbors) {
            neighbor.removeNeighbor(this);
            neighbor.explodeReaction();
        }

    }
    /**
     * Az aszteroida bányászása amennyiben nincs több rétege,
     *  bányászható és visszaadja az aszteroida nyersanyagát
     * @return Resource 
     */
    public Resource mineResource() {

        if (depth != 0)
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

        if (depth>0) {
            depth--;

            if (depth == 0 && nearSun) {
                resource.reaction(this);
            }
        }

    }
/**
 * Gyõzelem  vizsgálata aszteroidán
 * @param winBill a gyõzelemhez szükséges nyersanyagok
 * @return visszaadja, hogy van-e elég nyersanyag az aszteroidán a gyõzelemhez
 */
    public boolean checkEnoughResources(BillOfResources winBill) {

        //TODO: billofresources nem stimmel

        boolean enough = winBill.isCompleted();
        return enough;
    }
/**
 * Egy entitás eltávozása az aszteroidáról
 * @param entity az eltávozó entitás
 */
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
/**
 * Az aszteroidára entitás érkezik
 * @param entity  az érkezõ entitás
 */
    @Override
    public void addEntity(Entity entity) {
        entities.add(entity);
        entity.setLocation(this);
    }
/**
 *  Visszaadja az aszteroida nyersanyagát
 * @return resource az aszteroida nyersanyaga
 */
    public Resource getResource() {
        return resource;
    }
/**
 * Az aszteroida nyersanyagának beállítása
 * @param res a beállítandó nyersanyag
 */
    public void setResource(Resource res) {
        resource = res;
    }
/**
 * az aszteroida rétegének visszaadása
 * @return  az aszteroida rétege
 */
    public int getDepth() {
        return depth;
    }

/**
 * Visszaadja azt, hogy az aszteroida Napközelben van-e
 * @return napközelben vagy sem
 */
    public boolean getIsNearSun() {
        return nearSun;
    }
}
