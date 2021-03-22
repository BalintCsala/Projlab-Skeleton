package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.Scanner;

public class TeleportGate extends Field {

	private TeleportGate pair;
	
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die", this);
		FunctionPrinter.exit();
	}

	@Override
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction", this);
		pair.die();
		this.die();
		FunctionPrinter.exit();
	}

	@Override
	public void addEntity(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "addEntity", this, entity);
		teleportToPair(entity);
		FunctionPrinter.exit();
	}

	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair", this, entity);
		neighbors.get(0).addEntity(entity);
		FunctionPrinter.exit();
	}

	public void setPair(TeleportGate teleport) {
		FunctionPrinter.enter("TeleportGate", "setPair", this, teleport);
		pair = teleport;
		FunctionPrinter.exit();
	}

	public boolean getActive() {
		FunctionPrinter.enter("TeleportGate", "getActive", this);
		FunctionPrinter.ask("Aktiv a teleport? (I/N)");
		boolean active = new Scanner(System.in).next().equals("I");
		FunctionPrinter.exit();
		return active;
	}

	public void setActive(boolean active) {
	    FunctionPrinter.enter("TeleportGate", "setActive", this, active);
	    if (active) {
			if (!pair.getActive())
				pair.setActive(true);
		} else {
	    	if (pair.getActive())
	    		pair.setActive(false);
		}
	    FunctionPrinter.exit();
	}

}
