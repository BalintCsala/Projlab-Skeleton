package projlab.skeleton.map;

import projlab.skeleton.Game;
import projlab.skeleton.entities.MovingEntity;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ez az osztály az Aszteroidákat testesíti meg
 */
public class Asteroid extends Field {
    /**
     * az aszteroidán tartózkodó entitások
     */
    private final ArrayList<MovingEntity> entities = new ArrayList<>();


    /**
     * az aszteroida nyersanyaga
     */
    private Resource resource;
    /**
     * Napvihar hatása az aszteroidára, amennyiben nem lehet elbújni az aszteroidán,
     * a rajta tartózkodó entitások meghalnak
     */
    private final boolean nearSun;
    private int depth;
    private boolean hasBeenDug = false;

    /**
     * Konstruktor
     */
    public Asteroid() {
        depth = new Random().nextInt(8) + 2;
        nearSun = new Random().nextBoolean();
    }

    /**
     * Override a Field solarFlare-re. Ha nem üres, akkor mindenki meghal rajta
     */

    @Override
    public void solarFlare() {
        boolean hollow = resource == null && depth == 0;
        if (!hollow) {
            ArrayList<MovingEntity> temp = new ArrayList<>(entities);
            for (MovingEntity entity : temp) {
                entity.die();
                entities.remove(entity);
            }
        }
    }

    /**
     * az aszteroida felrobban, a rajta tartózkodó entitások meghalnak,
     * az aszteroida szomszédjai reagálnak a robbanásra és megszüntetik szomszédságukat az aszteroidával
     */
    public void explode() {
        ArrayList<MovingEntity> temp = new ArrayList<>(entities);
        for (MovingEntity entity : temp) {
            entity.explode();
        }

        for (Field neighbor : neighbors) {
            neighbor.removeNeighbor(this);
            neighbor.explodeReaction();
        }
    }

    /**
     * Az aszteroida bányászása, amennyiben nincs több rétege,
     * bányászható és visszaadja az aszteroida nyersanyagát
     *
     * @return Resource
     */
    public Resource mineResource() {
        if (depth != 0)
            return null;

        Resource res = resource;
        setResource(null);
        return res;
    }

    /**
     * Aszteroida rétegének csökkentése, amennyiben Napközelben vagyunk és a réteg 0,
     * az aszteroida nyersanyaga reagál
     *
     */
    public void digLayer() {
        hasBeenDug = true;
        if (depth > 0) {
            depth--;

            if (depth == 0 && resource != null && nearSun) {
                resource.reaction(this);
            }
        }

    }

    /**
     * Győzelem vizsgálata aszteroidán
     *
     * @param winBill a győzelemhez szükséges nyersanyagok
     * @return visszaadja, hogy van-e elég nyersanyag az aszteroidán a győzelemhez
     */
    public boolean checkEnoughResources(BillOfResources winBill) {
        ArrayList<Resource> resources = new ArrayList<>();
        for (MovingEntity entity : entities) {
            if (entity instanceof Settler)
                resources.addAll(((Settler)entity).getInventory());
        }
        return winBill.isCompleted(resources);
    }

    /**
     * Egy entitás eltávozása az aszteroidáról
     *
     * @param entity az eltávozó entitás
     */
    public void removeEntity(MovingEntity entity) {
        entities.remove(entity);
    }

    /**
     * Az aszteroidára entitás érkezik
     *
     * @param entity az érkező entitás
     */
    @Override
    public void addEntity(MovingEntity entity) {
        entities.add(entity);
        entity.setLocation(this);
    }

    /**
     * Visszaadja az aszteroida nyersanyagát
     *
     * @return resource az aszteroida nyersanyaga
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Az aszteroida nyersanyagának beállítása
     *
     * @param res a beállítandó nyersanyag
     */
    public void setResource(Resource res) {
        resource = res;
    }

    /**
     * az aszteroida rétegének visszaadása
     *
     * @return az aszteroida rétege
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Visszaadja azt, hogy az aszteroida Napközelben van-e
     *
     * @return napközelben vagy sem
     */
    public boolean isNearSun() {
        return nearSun;
    }

    public void addTeleport(TeleportGate teleport) {
        neighbors.add(teleport);
        teleport.setAsteroid(this);
    }

    @Override
    public void draw() {
        for (MovingEntity entity : entities) {
            entity.draw();
        }
    }

    public ArrayList<MovingEntity> getEntities() {
        return entities;
    }

    public boolean getHasBeenDug() {
        return hasBeenDug;
    }

    @Override
    public void drawAsNeighbor(int x, int y) {
        Game.neighborAsteroidDrawer.draw(this, x, y);
    }
}
