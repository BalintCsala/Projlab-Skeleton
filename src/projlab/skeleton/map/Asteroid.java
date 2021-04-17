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
 * Ez az oszt�ly az Aszteroid�kat testes�ti meg
 *
 */
public class Asteroid extends Field {
    /**
     * az aszteroida nyersanyaga
     */
    private Resource resource;
    /**
     * az aszteroid�n tart�zkod� entit�sok
     */
    private final ArrayList<Entity> entities = new ArrayList<>();
    /**
     * Napvihar hat�sa az aszteroid�ra, amennyiben nem lehet elb�jni az aszteroid�n,
     *  a rajta tart�zkod� entit�sok meghalnak
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
     * az aszteroida felrobban, a rajta tart�zkod� entit�sok meghalnak,
     * az aszteroida szomsz�djai reag�lnak a robban�sra �s megsz�ntetik szomsz�ds�gukat az aszteroid�val
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
     * Az aszteroida b�ny�sz�sa amennyiben nincs t�bb r�tege,
     *  b�ny�szhat� �s visszaadja az aszteroida nyersanyag�t
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
 * Aszteroida r�teg�nek cs�kkent�se, amennyiben Napk�zelben vagyunk �s a r�teg 0
 * az aszteroida nyersanyaga reag�l
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
 * Gy�zelem  vizsg�lata aszteroid�n
 * @param winBill a gy�zelemhez sz�ks�ges nyersanyagok
 * @return visszaadja, hogy van-e el�g nyersanyag az aszteroid�n a gy�zelemhez
 */
    public boolean checkEnoughResources(BillOfResources winBill) {

        //TODO: billofresources nem stimmel

        boolean enough = winBill.isCompleted();
        return enough;
    }
/**
 * Egy entit�s elt�voz�sa az aszteroid�r�l
 * @param entity az elt�voz� entit�s
 */
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
/**
 * Az aszteroid�ra entit�s �rkezik
 * @param entity  az �rkez� entit�s
 */
    @Override
    public void addEntity(Entity entity) {
        entities.add(entity);
        entity.setLocation(this);
    }
/**
 *  Visszaadja az aszteroida nyersanyag�t
 * @return resource az aszteroida nyersanyaga
 */
    public Resource getResource() {
        return resource;
    }
/**
 * Az aszteroida nyersanyag�nak be�ll�t�sa
 * @param res a be�ll�tand� nyersanyag
 */
    public void setResource(Resource res) {
        resource = res;
    }
/**
 * az aszteroida r�teg�nek visszaad�sa
 * @return  az aszteroida r�tege
 */
    public int getDepth() {
        return depth;
    }

/**
 * Visszaadja azt, hogy az aszteroida Napk�zelben van-e
 * @return napk�zelben vagy sem
 */
    public boolean getIsNearSun() {
        return nearSun;
    }
}
