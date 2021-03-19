package projlab.skeleton;

import java.util.ArrayList;

public class TeleportGate extends Field {

	
	private TeleportGate pair;
	
	
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die");
		FunctionPrinter.exit();
	}
	
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction");
		pair.die();
		this.die();
		FunctionPrinter.exit();
	}
	public void addEntity(Entity entity) {  
		FunctionPrinter.enter("TeleportGate", "addEntity");
		entities.add(entity);    
		                         
		if(!pair.getentities().contains(entity)) {   // ha nincs a párnál teleportaljuk
			teleportToPair(entity);
			
		}
		
		FunctionPrinter.exit();
	}
	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair");
		entity.move(pair);
		pair.addEntity(entity);
		entities.remove(entity);
		FunctionPrinter.exit();
		
	}
	public void setPair(TeleportGate teleport) {// ezt nem írom ki
		pair = teleport;
		
	}
	public ArrayList<Entity> getentities() {
		
		return entities;
	}
}
