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

public class Settler extends Entity {

	private final ArrayList<Resource> inventory = new ArrayList<>();
	private ArrayList<TeleportGate> teleports = new ArrayList<>();
	private BillOfResources robotBill;
	private BillOfResources teleportBill;

	public Settler(BillOfResources robotBill, BillOfResources teleportBill) {
		this.robotBill = robotBill;
		this.teleportBill = teleportBill;
	}

	@Override
	public void explode() {
		FunctionPrinter.enter("Settler", "explode", this);
		die();
		FunctionPrinter.exit();
	}

	public void mine() {
	    FunctionPrinter.enter("Settler", "mine", this);
		if (inventory.size() < 10) {
			Resource resource = location.mineResource();
			if (resource != null)
				inventory.add(resource);
		}
	    FunctionPrinter.exit();
	}
	
	public void buildTeleport() {
	    FunctionPrinter.enter("Settler", "buildTeleport", this);
		if (teleportBill.isCompleted(inventory) && teleports.size() == 0) {
			TeleportGate teleport1 = new TeleportGate();
			FunctionPrinter.register(teleport1, "teleport1");
			TeleportGate teleport2 = new TeleportGate();
			FunctionPrinter.register(teleport2, "teleport2");
			teleport1.setPair(teleport2);
			teleport2.setPair(teleport1);
			teleports.add(teleport1);
			teleports.add(teleport2);
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

	public void buildRobot() {
	    FunctionPrinter.enter("Settler", "buildRobot", this);
		if (robotBill.isCompleted(inventory)) {
			Robot robot = new Robot();
			FunctionPrinter.register(robot, "robot");
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

	public void placeDownTeleport(Asteroid asteroid) {
	    FunctionPrinter.enter("Settler", "placeDownTeleport", this, asteroid);
	    if (teleports.size() > 0) {
			TeleportGate teleport = teleports.get(0);
			asteroid.addNeighbor(teleport);
			FunctionPrinter.ask("Le van rakva a teleport parja? (I/N)");
			boolean placedDown = new Scanner(System.in).next().equals("I");
			if (placedDown) {
				teleport.setActive(true);
			}
			teleports.remove(0);
		}
	    FunctionPrinter.exit();
	}

	public void placeDownResource(Resource resource) {
	    FunctionPrinter.enter("Settler", "placeDownResource", this, resource);
	    FunctionPrinter.ask("Le lehet helyezni a nyersanyagot (ki van banyaszva es ureges)? (I/N)");
	    boolean canPlace = new Scanner(System.in).next().equals("I");
		if (canPlace) {
			location.setResource(resource);
			inventory.remove(resource);
		}

		if (location.getIsNearSun()) {
			resource.reaction(location);
		}
	    FunctionPrinter.exit();
	}

	public void addResource(Resource resource) {
		FunctionPrinter.enter("Settler", "addResource", this, resource);
		if (inventory.size() < 10) {
			inventory.add(resource);
		}
		FunctionPrinter.exit();
	}

	public void removeResource(Resource resource) {
	    FunctionPrinter.enter("Settler", "removeResource", this, resource);
	    inventory.remove(resource);
	    FunctionPrinter.exit();
	}

	public void setTeleports(TeleportGate teleport1, TeleportGate teleport2) {
		FunctionPrinter.enter("Settler", "setTeleports", this, teleport1, teleport2);
		teleports.clear();
		teleports.add(teleport1);
		teleports.add(teleport2);
		FunctionPrinter.exit();
	}

}
