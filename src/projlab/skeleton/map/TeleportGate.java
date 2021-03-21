package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.Scanner;

public class TeleportGate extends Field {

	private TeleportGate pair;
	
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die");
		FunctionPrinter.exit();
	}

	@Override
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction");
		pair.die();
		this.die();
		FunctionPrinter.exit();
	}

	@Override
	public void addEntity(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "addEntity");
		teleportToPair(entity);
		FunctionPrinter.exit();
	}

	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair");
		getNeighbors().get(0).addEntity(entity);
		FunctionPrinter.exit();
	}

	public void setPair(TeleportGate teleport) {
		FunctionPrinter.enter("TeleportGate", "setPair");
		pair = teleport;
		FunctionPrinter.exit();
	}

	public boolean getActive() {
		FunctionPrinter.enter("TeleportGate", "getActive");
		FunctionPrinter.msg("Aktiv a teleport? (I/N)");
		boolean active = new Scanner(System.in).next().equals("I");
		FunctionPrinter.exit();
		return active;
	}

	public void setActive(boolean active) {
	    FunctionPrinter.enter("TeleportGate", "setActive");
	    FunctionPrinter.exit();
	}

	public void activate() {
	    FunctionPrinter.enter("TeleportGate", "setActive");
		setActive(true);
	    if (!pair.getActive())
	    	pair.setActive(true);
	    FunctionPrinter.exit();
	}
}
