package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;


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
		
		robotBill.addResource(new Coal());//nyersanyagok hozz�ad�sa
		
		robotBill.addResource(new Iron());
		
		robotBill.addResource(new Uran());
	}
	/**
	 * A teleportkapuk építéséhez szükséges nyersanyagokat tároló objektum
	 */
	private static BillOfResources teleportBill;
	
	static {
		teleportBill.addResource(new WaterIce());//nyersanyagok hozz�ad�sa
		teleportBill.addResource(new Iron());
		teleportBill.addResource(new Iron());
		teleportBill.addResource(new Uran());
		
	}
	/**
	megadja, hogy �letben van-e m�g a telepes
	*/
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
				inventory.add(resource);    //k�r�k v�g�n n�zz�k a gy�zelmet vagy m�r itt is
		}
	   
	}

	/**
	 * A teleportok építését megvalósító metódus
	 */
	public void buildTeleport() {
	   
	    // Ha van elég nyersanyagunk hozzá, építsük meg a teleport kapukat
		if (teleportBill.isCompleted(inventory) && teleports.size() <2) {
			// Hozzunk létre két teleportkaput
			TeleportGate teleport1 = new TeleportGate();
			
			TeleportGate teleport2 = new TeleportGate();
			
			// majd állítsuk be őket egymás párjának és tároljuk el őket
			teleport1.setPair(teleport2);
			teleport2.setPair(teleport1);
			teleports.add(teleport1);
			teleports.add(teleport2);
			// Végül távolítsuk el a felhasznált nyersanyagokat a hátizsákból
			Iron iron1 = new Iron();
			
			Iron iron2 = new Iron();
			
			WaterIce waterIce = new WaterIce();
			
			Uran uran = new Uran();
			

			removeResource(iron1);
			removeResource(iron2);
			removeResource(waterIce);
			removeResource(uran);
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
			
			// Majd távolítsuk el a felhasznált nyersanyagokat a hátizsákból
			Iron iron2 = new Iron();
			
			Coal coal2 = new Coal();
			
			Uran uran2 = new Uran();
			

			removeResource(iron2);
			removeResource(coal2);
			removeResource(uran2);
		}
	    
	}

	/**
	 * A teleport lehelyezés parancsot megvalósító metódus
	 * @param asteroid Az aszteroida, amire lehelyezzük a teleportot
	 */
	public void placeDownTeleport(Asteroid asteroid) {
	    
	    if (teleports.size() > 0) {
	    	// Vegyük ki az első teleportkaput és adjuk hozzá az aszteroida szomszédságához
			TeleportGate teleport = teleports.get(0);
			asteroid.addNeighbor(teleport);
			teleport.setAsteroid(location);
			boolean placedDown = true;
			if(teleport.getPair().getAsteroid()==null) {
			 placedDown =false;
			 }
			// Ha már mindkét teleportkapu le van rakva, aktiváluk őket
			if (placedDown) {
				teleport.setActive(true);
			}
			teleports.remove(0);
		}
	   
	}

	/**
	 * A nyersanyag visszahelyezés parancsot implementáló metódus
	 * @param resource A lehelyezendő nyersanyag
	 */
	public void placeDownResource(Resource resource) {
	   
	    boolean canPlace= false;
	    //Ha nincs az aszteroid�nak nyersanyaga �s t�bb r�tege akkor �reges �s ez�rt lerakhat� a resource
	   if(location.getResource()==null && location.getDepth()==0) {
		   canPlace=true;
	   }
	    // Ha lehelyezhető a nyersanyag, rakjuk le és vegyük ki a hátizsákból
		if (canPlace) {// megn�z �res-e mine nem ad vissza semmit
			location.setResource(resource);
			inventory.remove(resource);
			// Ha napközelben vagyunk, indítsuk el a nyersanyag reakcióját
			if (location.getIsNearSun()) {
				resource.reaction(location);
			}
		}

	    
	}

	/**
	 * Hozzáad egy nyersanyagot a telepes hátizsákjához
	 * @param resource A hozzáadandó nyersanyag
	 */
	public void addResource(Resource resource) {
		
		// Ha még van hely, adjuk hozzá
		if (inventory.size() < 10) {
			inventory.add(resource);
		}
		
	}

	/**
	 * Távolítsunk el egy nyersanyagot a teleps hátizsákjából
	 * @param resource Az eltávolítandó nyersanyag
	 */
	public void removeResource(Resource resource) {
	   
	    inventory.remove(resource);
	    
	}

	/**
	 * Beállítja a telepesnél lévő teleportkapukat tesztelés célből
	 * @param teleport1 Az első teleportkapu
	 * @param teleport2 A második teleportkapu
	 */
	public void setTeleports(TeleportGate teleport1, TeleportGate teleport2) {
		
		teleports.clear();
		teleports.add(teleport1);
		teleports.add(teleport2);
		
	}
	/**
	 * meghal�s implement�l�sa 
	 * 
	 */
	@Override
	public void die() {
		alive = false;
	}
	public boolean getalive() {
		
		return alive;
	}
	public ArrayList<Resource> getInventory() {
		
		return inventory;
	}

}
