package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

public class Settler extends Entity {

	private final ArrayList<Resource> inventory = new ArrayList<>();
	private final ArrayList<TeleportGate> teleports = new ArrayList<>();
	private BillOfResources robotBill;
	private BillOfResources teleportBill;
	
	public void mine() {
	    FunctionPrinter.enter("Settler", "mine");
		if (inventory.size() < 10) {
			Resource resource = getLocation().mineResource();
			if (resource != null)
				inventory.add(resource);
		}
	    FunctionPrinter.exit();
	}
	
	public void buildTeleport() {
	    FunctionPrinter.enter("Settler", "buildTeleport");
		if (teleportBill.isCompleted(inventory) && teleports.size() == 0) {
			TeleportGate teleport1 = new TeleportGate();
			TeleportGate teleport2 = new TeleportGate();
			teleport1.setPair(teleport2);
			teleport2.setPair(teleport1);
			teleports.add(teleport1);
			teleports.add(teleport2);
		}
	    FunctionPrinter.exit();
	}

	public void buildRobot() {
	    FunctionPrinter.enter("Settler", "buildRobot");
		if (robotBill.isCompleted(inventory)) {
			new Robot();
		}
	    FunctionPrinter.exit();
	}

	public void placeDownTeleport(Asteroid asteroid) {
	    FunctionPrinter.enter("Settler", "placeDownTeleport");
	    if (teleports.size() > 0) {
			TeleportGate teleport = teleports.get(0);
			asteroid.addNeighbor(teleport);
			if (teleports.size() == 1) {
				teleport.setActive(true);
			}
			teleports.remove(0);
		}
	    FunctionPrinter.exit();
	}

	public void placeDownResource(Resource resource) {
	    FunctionPrinter.enter("Settler", "placeDownResource");
		if (getLocation().getResource() == null && getLocation().getLayerDepth() == 0) {
			getLocation().setResource(resource);
			inventory.remove(resource);
		}

		if (getLocation().getIsNearSun()) {
			resource.reaction(getLocation());
		}
	    FunctionPrinter.exit();
	}

}
