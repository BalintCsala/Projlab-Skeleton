package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.Scanner;
/**
 * 
 * Teleportkapuk megtestesítése
 *
 */
public class TeleportGate extends Field {
/**
 *  a teleportkapu párja
 */
	private TeleportGate pair;
	/**
	 * megszûnik létezni a teleportkapu
	 */
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die");
		FunctionPrinter.exit();
	}
	/**
	 * 
	 * reagálás az aszteroidájának felrobbanásra 
	 */
	@Override
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction");
		pair.die();
		this.die();
		FunctionPrinter.exit();
	}
	/**
	 * Az teleportkapura entitás érkezik
	 * @param entity  az érkezõ entitás
	 */
	@Override
	public void addEntity(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "addEntity");
		teleportToPair(entity);
		FunctionPrinter.exit();
	}
/**
 * a teleportkapu párjára való átteleportálás
 * @param entity a teleportkaput használó entitás
 */
	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair");
		getNeighbors().get(0).addEntity(entity);
		FunctionPrinter.exit();
	}
/**
 * beállítja a teleportkapu párját
 * @param teleport a teleportkapu párja
 */
	public void setPair(TeleportGate teleport) {
		FunctionPrinter.enter("TeleportGate", "setPair");
		pair = teleport;
		FunctionPrinter.exit();
	}

	/**
	 * Megadja, hogy aktív-e a teleportkapu
	 * @return aktívság
	 */
	public boolean getActive() {
		FunctionPrinter.enter("TeleportGate", "getActive");
		FunctionPrinter.msg("Aktiv a teleport? (I/N)");
		boolean active = new Scanner(System.in).next().equals("I");
		FunctionPrinter.exit();
		return active;
	}
/**
 * Beállítjuk a teleportkapu aktívságát
 * @param active a teleportkapu aktívsága
 */
	public void setActive(boolean active) {
	    FunctionPrinter.enter("TeleportGate", "setActive");
	    FunctionPrinter.exit();
	}
/**
 * Az teleportkapu aktív lesz
 */
	public void activate() {
	    FunctionPrinter.enter("TeleportGate", "setActive");
		setActive(true);
	    if (!pair.getActive())
	    	pair.setActive(true);
	    FunctionPrinter.exit();
	}
}
