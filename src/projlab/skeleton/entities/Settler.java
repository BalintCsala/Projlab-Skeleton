package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A telepeseket jelképező osztály
 */
public class Settler extends MovingEntity implements MiningEntity {

	/**
	 * A telepes hátizsákjában lévő nyersanyagok
	 */
	private final ArrayList<Resource> inventory = new ArrayList<>();
	/**
	 * A telepesnél lévő teleportkapuk
	 */
	private ArrayList<TeleportGate> teleports = new ArrayList<>();
	/**
	 * Az egy robot megépítéséhez szükséges nyersanyagokat tároló objektum
	 */
	private static BillOfResources robotBill= new BillOfResources();
	
	static {
		
		robotBill.addResource(new Coal());
		
		robotBill.addResource(new Iron());
		
		robotBill.addResource(new Uran());
	}
	/**
	 * A teleportkapuk építéséhez szükséges nyersanyagokat tároló objektum
	 */
	private static BillOfResources teleportBill;
	
	static {
		teleportBill.addResource(new WaterIce());
		teleportBill.addResource(new Iron());
		teleportBill.addResource(new Iron());
		teleportBill.addResource(new Uran());
		
	}
	private boolean alive;
	/**
	 * A settler konstruktora
	 * @param robotBill A robothoz szükséges nyersamyagok
	 * @param teleportBill A teleportokhoz szükséges nyersanyagok
	 */
	public Settler() {//param n�lk�li konstr kellene
		alive = true;
	}

	/**
	 * A telepes felrobbanását lekezelő metódus
	 */
	@Override
	public void explode() {
		FunctionPrinter.enter("Settler", "explode", this);
		die();
		FunctionPrinter.exit();
	}

	/**
	 * A bányászás parancsot megvalósító metódus
	 */
	@Override
	public void mine() {
	    FunctionPrinter.enter("Settler", "mine", this);
		if (inventory.size() < 10) {
			// Bányásszuk ki az aszteroida nyersanyagát
			Resource resource = location.mineResource();
			// Ha van még hely a telepes hátizsákjában és nem null az aszteroida nyersanyaga,
			// akkor adjuk hozzá azt a hátizsákhoz
			if (resource != null)
				inventory.add(resource);    //k�r�k v�g�n n�zz�k a gy�zelmet vagy m�r itt is
		}
	    FunctionPrinter.exit();
	}

	/**
	 * A teleportok építését megvalósító metódus
	 */
	public void buildTeleport() {
	    FunctionPrinter.enter("Settler", "buildTeleport", this);
	    // Ha van elég nyersanyagunk hozzá, építsük meg a teleport kapukat
		if (teleportBill.isCompleted(inventory) && teleports.size() <2) {//felt�tel �t�rva
			// Hozzunk létre két teleportkaput
			TeleportGate teleport1 = new TeleportGate();
			FunctionPrinter.register(teleport1, "teleport1");
			TeleportGate teleport2 = new TeleportGate();
			FunctionPrinter.register(teleport2, "teleport2");
			// majd állítsuk be őket egymás párjának és tároljuk el őket
			teleport1.setPair(teleport2);
			teleport2.setPair(teleport1);
			teleports.add(teleport1);
			teleports.add(teleport2);
			// Végül távolítsuk el a felhasznált nyersanyagokat a hátizsákból
			Iron iron1 = new Iron();
			FunctionPrinter.register(iron1, "iron1");
			Iron iron2 = new Iron();
			FunctionPrinter.register(iron2, "iron2");
			WaterIce waterIce = new WaterIce();
			FunctionPrinter.register(waterIce, "waterIce");
			Uran uran = new Uran();
			FunctionPrinter.register(uran, "uran");

			removeResource(iron1);
			removeResource(iron2);
			removeResource(waterIce);
			removeResource(uran);
		}
	    FunctionPrinter.exit();
	}

	/**
	 * A robot építés parancsot megvalósító metódus
	 */
	public void buildRobot() {
	    FunctionPrinter.enter("Settler", "buildRobot", this);
		// Ha van elég nyersanyagunk hozzá, építsük meg a robotot
		if (robotBill.isCompleted(inventory)) {
			// Hozzuk létre a robotot, ez automatikusan hozzáadódik az AI-hoz
			Robot robot = new Robot();
			FunctionPrinter.register(robot, "robot");
			// Majd távolítsuk el a felhasznált nyersanyagokat a hátizsákból
			Iron iron2 = new Iron();
			FunctionPrinter.register(iron2, "iron2");
			Coal coal2 = new Coal();
			FunctionPrinter.register(coal2, "coal2");
			Uran uran2 = new Uran();
			FunctionPrinter.register(uran2, "uran2");

			removeResource(iron2);
			removeResource(coal2);
			removeResource(uran2);
		}
	    FunctionPrinter.exit();
	}

	/**
	 * A teleport lehelyezés parancsot megvalósító metódus
	 * @param asteroid Az aszteroida, amire lehelyezzük a teleportot
	 */
	public void placeDownTeleport(Asteroid asteroid) {
	    FunctionPrinter.enter("Settler", "placeDownTeleport", this, asteroid);
	    if (teleports.size() > 0) {
	    	// Vegyük ki az első teleportkaput és adjuk hozzá az aszteroida szomszédságához
			TeleportGate teleport = teleports.get(0);
			asteroid.addNeighbor(teleport);
			FunctionPrinter.ask("Le van rakva a teleport parja? (I/N)");
			boolean placedDown = new Scanner(System.in).next().equals("I");// nem kell
			// Ha már mindkét teleportkapu le van rakva, aktiváluk őket
			if (placedDown) {//l�trehoz ilyen attrib�tum
				teleport.setActive(true);
			}
			teleports.remove(0);
		}
	    FunctionPrinter.exit();
	}

	/**
	 * A nyersanyag visszahelyezés parancsot implementáló metódus
	 * @param resource A lehelyezendő nyersanyag
	 */
	public void placeDownResource(Resource resource) {
	    FunctionPrinter.enter("Settler", "placeDownResource", this, resource);
	    FunctionPrinter.ask("Le lehet helyezni a nyersanyagot (ki van banyaszva es ureges)? (I/N)");
	    boolean canPlace = new Scanner(System.in).next().equals("I");//nem kell
	    // Ha lehelyezhető a nyersanyag, rakjuk le és vegyük ki a hátizsákból
		if (canPlace) {// megn�z �res-e mine nem ad vissza semmit
			location.setResource(resource);
			inventory.remove(resource);
			// Ha napközelben vagyunk, indítsuk el a nyersanyag reakcióját
			if (location.getIsNearSun()) {
				resource.reaction(location);
			}
		}

	    FunctionPrinter.exit();
	}

	/**
	 * Hozzáad egy nyersanyagot a telepes hátizsákjához
	 * @param resource A hozzáadandó nyersanyag
	 */
	public void addResource(Resource resource) {
		FunctionPrinter.enter("Settler", "addResource", this, resource);
		// Ha még van hely, adjuk hozzá
		if (inventory.size() < 10) {
			inventory.add(resource);
		}
		FunctionPrinter.exit();
	}

	/**
	 * Távolítsunk el egy nyersanyagot a teleps hátizsákjából
	 * @param resource Az eltávolítandó nyersanyag
	 */
	public void removeResource(Resource resource) {
	    FunctionPrinter.enter("Settler", "removeResource", this, resource);
	    inventory.remove(resource);
	    FunctionPrinter.exit();
	}

	/**
	 * Beállítja a telepesnél lévő teleportkapukat tesztelés célből
	 * @param teleport1 Az első teleportkapu
	 * @param teleport2 A második teleportkapu
	 */
	public void setTeleports(TeleportGate teleport1, TeleportGate teleport2) {
		FunctionPrinter.enter("Settler", "setTeleports", this, teleport1, teleport2);
		teleports.clear();
		teleports.add(teleport1);
		teleports.add(teleport2);
		FunctionPrinter.exit();
	}
	@Override
	public void die() {
		alive = false;
	}
	public boolean getalive() {
		
		return alive;
	}

}
