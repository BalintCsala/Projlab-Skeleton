package projlab.skeleton.entities;

import projlab.skeleton.Game;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A telepeseket jelképező osztály
 */
public class Settler extends MovingEntity implements MiningEntity {

    /**
     * Az egy robot megépítéséhez szükséges nyersanyagokat tároló objektum
     */
    private static final BillOfResources robotBill = new BillOfResources();
    /**
     * A teleportkapuk építéséhez szükséges nyersanyagokat tároló objektum
     */
    private static final BillOfResources teleportBill = new BillOfResources();

    static {
        // A robot bill feltöltése
        robotBill.addResource(new Coal());
        robotBill.addResource(new Iron());
        robotBill.addResource(new Uran());

        // A teleport bill feltöltése
        teleportBill.addResource(new WaterIce());
        teleportBill.addResource(new Iron());
        teleportBill.addResource(new Iron());
        teleportBill.addResource(new Uran());
    }

    /**
     * A telepes hátizsákjában lévő nyersanyagok
     */
    private final ArrayList<Resource> inventory = new ArrayList<>();
    /**
     * A telepesnél lévő teleportkapuk
     */
    private final ArrayList<TeleportGate> teleports = new ArrayList<>();
    /**
     * A telepes életben van-e vagy sem
     */
    private boolean alive;

    /**
     * A telepes konstruktora
     */
    public Settler() {
        alive = true;
    }

    /**
     * A telepes felrobbanását lekezelő metódus
     */
    @Override
    public void explode() {
        die();
    }

    /**
     * A bányászás parancsot megvalósító metódus
     */
    @Override
    public void mine() {
        if (inventory.size() < 10) {
            // Bányásszuk ki az aszteroida nyersanyagát
            Resource resource = location.mineResource();
            // Ha van még hely a telepes hátizsákjában és nem null az aszteroida nyersanyaga,
            // akkor adjuk hozzá azt a hátizsákhoz
            if (resource != null)
                inventory.add(resource);
        }
    }

    /**
     * A teleportok építését megvalósító metódus
     */
    public void buildTeleport() {
        // Ha van elég nyersanyagunk hozzá, építsük meg a teleport kapukat
        if (teleportBill.isCompleted(inventory) && teleports.size() < 2) {
            // Hozzunk létre két teleportkaput
            TeleportGate teleport1 = new TeleportGate();
            TeleportGate teleport2 = new TeleportGate();
            // majd állítsuk be őket egymás párjának és tároljuk el őket
            teleport1.setPair(teleport2);
            teleport2.setPair(teleport1);
            teleports.add(teleport1);
            teleports.add(teleport2);
            // Végül távolítsuk el a felhasznált nyersanyagokat a hátizsákból
            teleportBill.removeRequired(inventory);
        }
    }

    /**
     * A robot építés parancsot megvalósító metódus
     */
    public void buildRobot() {
        // Ha van elég nyersanyagunk hozzá, építsük meg a robotot
        if (robotBill.isCompleted(inventory)) {
            // Hozzuk létre a robotot, ez automatikusan hozzáadódik az AI-hoz
            Robot robot = new Robot();
            location.addEntity(robot);
            // Majd távolítsuk el a felhasznált nyersanyagokat a hátizsákból
            robotBill.removeRequired(inventory);
        }
    }

    /**
     * A teleport lehelyezés parancsot megvalósító metódus
     *
     * @param asteroid Az aszteroida, amire lehelyezzük a teleportot
     */
    public void placeDownTeleport(Asteroid asteroid, TeleportGate teleport) {
        if (teleports.size() > 0) {
            // Vegyük ki az első teleportkaput és adjuk hozzá az aszteroida szomszédságához
            teleports.remove(teleport);
            asteroid.addTeleport(teleport);
			boolean placedDown = teleport.getPair().getAsteroid() != null;
            if (placedDown) {
                teleport.setActive(true);
            }
        }
    }

    /**
     * A nyersanyag visszahelyezés parancsot implementáló metódus
     *
     * @param resource A lehelyezendő nyersanyag
     */
    public void placeDownResource(Resource resource) {
        boolean canPlace = location.getResource() == null && location.getDepth() == 0;
        // Ha lehelyezhető a nyersanyag, rakjuk le és vegyük ki a hátizsákból
        if (canPlace) {
            location.setResource(resource);
            inventory.remove(resource);
            // Ha napközelben vagyunk, indítsuk el a nyersanyag reakcióját
            if (location.isNearSun()) {
                resource.reaction(location);
            }
        }

    }

    /**
     * A telepes halálát implementáló metódus
     */
    @Override
    public void die() {
        alive = false;

    }

    /**
     * Visszaadja, hogy a telepes életben van-e
     * 
     * @return a telepes életben van-e vagy sem
     */
    public boolean isAlive() {

        return alive;
    }

    /**
     * Visszaadja a telepesnél lévő nyersanyagokat
     * 
     * @return a telepesnél lévő nyersanyagok
     */
    public ArrayList<Resource> getInventory() {
        return inventory;
    }


    /**
     * Visszaadja a telepesnél lévő teleportkapukat
     * 
     * @return a telepesnél lévő teleportkapuk
     */
    public ArrayList<TeleportGate> getTeleports() {
        return teleports;
    }

    @Override
    public void draw() {
        Random random = new Random();
        int x = random.nextInt(200) - 100 + 480;
        int y = random.nextInt(200) - 100 + 250;
        Game.settlerDrawer.draw(this, x, y);
    }
}
