package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.Scanner;
/**
 *
 * Teleportkapuk megtestes�t�se
 *
 */
public class TeleportGate extends Field {
/**
 *  a teleportkapu p�rja
 */
	private TeleportGate pair;
	/**
	 * megsz�nik l�tezni a teleportkapu
	 */
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die", this);
		FunctionPrinter.exit();
	}
	/**
	 *
	 * reag�l�s az aszteroid�j�nak felrobban�sra
	 */
	@Override
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction", this);
		pair.die();
		this.die();
		FunctionPrinter.exit();
	}
	/**
	 * Az teleportkapura entit�s �rkezik
	 * @param entity  az �rkez� entit�s
	 */
	@Override
	public void addEntity(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "addEntity", this, entity);
		teleportToPair(entity);
		FunctionPrinter.exit();
	}
/**
 * a teleportkapu p�rj�ra val� �tteleport�l�s
 * @param entity a teleportkaput haszn�l� entit�s
 */
	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair", this, entity);
		neighbors.get(0).addEntity(entity);
		FunctionPrinter.exit();
	}
/**
 * be�ll�tja a teleportkapu p�rj�t
 * @param teleport a teleportkapu p�rja
 */
	public void setPair(TeleportGate teleport) {
		FunctionPrinter.enter("TeleportGate", "setPair", this, teleport);
		pair = teleport;
		FunctionPrinter.exit();
	}

	/**
	 * Megadja, hogy akt�v-e a teleportkapu
	 * @return akt�vs�g
	 */
	public boolean getActive() {
		FunctionPrinter.enter("TeleportGate", "getActive", this);
		FunctionPrinter.ask("Aktiv a teleport? (I/N)");
		boolean active = new Scanner(System.in).next().equals("I");
		FunctionPrinter.exit();
		return active;
	}
/**
 * Be�ll�tjuk a teleportkapu akt�vs�g�t
 * @param active a teleportkapu akt�vs�ga
 */
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
