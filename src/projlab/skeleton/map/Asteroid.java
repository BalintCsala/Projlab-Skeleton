package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
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
     * az aszteroida felrobban, a rajta tart�zkod� entit�sok meghalnak,
     * az aszteroida szomsz�djai reag�lnak a robban�sra �s megsz�ntetik szomsz�ds�gukat az aszteroid�val
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
     * Az aszteroida b�ny�sz�sa amennyiben nincs t�bb r�tege,
     *  b�ny�szhat� �s visszaadja az aszteroida nyersanyag�t
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
 * Aszteroida r�teg�nek cs�kkent�se, amennyiben Napk�zelben vagyunk �s a r�teg 0
 * az aszteroida nyersanyaga reag�l
 * 
 */
    public void digLayer() {  //if
        FunctionPrinter.enter("Asteroid", "diglayer");
        FunctionPrinter.msg("Napk�zelben vagyunk �s a r�teg 0? (I/N)");
        String choice = new Scanner(System.in).next();
        if (choice.equals("I")) {
            resource.reaction(this);
        }

        FunctionPrinter.exit();
    }
/**
 * Gy�zele  vizsg�lata aszteroid�n
 * @param winBill a gy�zelemhez sz�ks�ges nyersanyagok
 * @return visszaadja, hogy van-e el�g nyersanyag az aszteroid�n a gy�zelemhez
 */
    public boolean checkEnoughResources(BillOfResources winBill) {
        FunctionPrinter.enter("Asteroid", "checkEnoughResources");
        FunctionPrinter.msg("Van eleg nyersanyag az aszteroidan? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }
/**
 * Egy entit�s elt�voz�sa az aszteroid�r�l
 * @param entity az elt�voz� entit�s
 */
    public void removeEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "removeEntity");
        entities.remove(entity);
        FunctionPrinter.exit();
    }
/**
 * Az aszteroid�ra entit�s �rkezik
 * @param entity  az �rkez� entit�s
 */
    @Override
    public void addEntity(Entity entity) {
        FunctionPrinter.enter("Asteroid", "addEntity");
        entities.add(entity);
        entity.setLocation(this);
        FunctionPrinter.exit();
    }
/**
 *  Visszaadja az aszteroida nyersanyag�t
 * @return resource az aszteroida nyersanyaga
 */
    public Resource getResource() {
        FunctionPrinter.enter("Asteroid", "getResource");
        FunctionPrinter.exit();
        return resource;
    }
/**
 * Az aszteroida nyersanyag�nak be�ll�t�sa
 * @param res a be�ll�tand� nyersanyag
 */
    public void setResource(Resource res) {
        FunctionPrinter.enter("Asteroid", "setResource");
        resource = res;
        FunctionPrinter.exit();
    }
/**
 * az aszteroida r�teg�nek visszaad�sa
 * @return  az aszteroida r�tege
 */
    public int getLayerDepth() {
        FunctionPrinter.enter("Asteroid", "getLayerDepth");
        FunctionPrinter.msg("Milyen vastag legyen az aszteroida kerge?");
        int depth = (new Scanner(System.in)).nextInt();
        FunctionPrinter.exit();
        return depth;
    }
/**
 * Visszaadja azt, hogy az aszteroida Napk�zelben van-e
 * @return napk�zelben vagy sem
 */
    public boolean getIsNearSun() {
        FunctionPrinter.enter("Asteroid", "getIsNearSun");
        boolean nearSun = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return nearSun;
    }
}
