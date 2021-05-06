package projlab.skeleton.map;

import projlab.skeleton.entities.MovingEntity;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ez az oszt�ly az Aszteroid�kat testes�ti meg
 */
public class Asteroid extends Field {
    /**
     * az aszteroid�n tart�zkod� entit�sok
     */
    private final ArrayList<MovingEntity> entities = new ArrayList<>();
    /**
     * az aszteroida nyersanyaga
     */
    private Resource resource;
    /**
     * Napvihar hat�sa az aszteroid�ra, amennyiben nem lehet elb�jni az aszteroid�n,
     * a rajta tart�zkod� entit�sok meghalnak
     */
    private boolean nearSun;
    private int depth;

    /**
     * Konstruktor
     */
    public Asteroid() {
        depth = new Random().nextInt(10);
        nearSun = new Random().nextBoolean();
    }

    /**
     * Override a Field solarFlare-re. Ha nem �res, akkor mindenki meghal rajta
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
     * az aszteroida felrobban, a rajta tart�zkod� entit�sok meghalnak,
     * az aszteroida szomsz�djai reag�lnak a robban�sra �s megsz�ntetik szomsz�ds�gukat az aszteroid�val
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
     * Az aszteroida b�ny�sz�sa amennyiben nincs t�bb r�tege,
     * b�ny�szhat� �s visszaadja az aszteroida nyersanyag�t
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
     * Aszteroida r�teg�nek cs�kkent�se, amennyiben Napk�zelben vagyunk �s a r�teg 0
     * az aszteroida nyersanyaga reag�l
     */
    public void digLayer() {
        if (depth > 0) {
            depth--;

            if (depth == 0 && resource != null && nearSun) {
                resource.reaction(this);
            }
        }

    }

    /**
     * Gy�zelem  vizsg�lata aszteroid�n
     *
     * @param winBill a gy�zelemhez sz�ks�ges nyersanyagok
     * @return visszaadja, hogy van-e el�g nyersanyag az aszteroid�n a gy�zelemhez
     */
    public boolean checkEnoughResources(BillOfResources winBill) {
        boolean enough = false; //winBill.isCompleted();
        return enough;
    }

    /**
     * Egy entit�s elt�voz�sa az aszteroid�r�l
     *
     * @param entity az elt�voz� entit�s
     */
    public void removeEntity(MovingEntity entity) {
        entities.remove(entity);
    }

    /**
     * Az aszteroid�ra entit�s �rkezik
     *
     * @param entity az �rkez� entit�s
     */
    @Override
    public void addEntity(MovingEntity entity) {
        entities.add(entity);
        entity.setLocation(this);
    }

    /**
     * Visszaadja az aszteroida nyersanyag�t
     *
     * @return resource az aszteroida nyersanyaga
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Az aszteroida nyersanyag�nak be�ll�t�sa
     *
     * @param res a be�ll�tand� nyersanyag
     */
    public void setResource(Resource res) {
        resource = res;
    }

    /**
     * az aszteroida r�teg�nek visszaad�sa
     *
     * @return az aszteroida r�tege
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Visszaadja azt, hogy az aszteroida Napk�zelben van-e
     *
     * @return napk�zelben vagy sem
     */
    public boolean isNearSun() {
        return nearSun;
    }

    public void addTeleport(TeleportGate teleport) {
        neighbors.add(teleport);
        teleport.setAsteroid(this);
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setNearSun(boolean nearSun) {
        this.nearSun = nearSun;
    }

    @Override
    public void draw() {

    }
}
