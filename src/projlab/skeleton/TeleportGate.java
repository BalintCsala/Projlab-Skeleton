package projlab.skeleton;

public class TeleportGate extends Field {

	
	private TeleportGate pair;
	
	
	public void die() {
		FunctionPrinter.enter("TeleportGate", "die");
	}
	
	public void explodeReaction() {
		FunctionPrinter.enter("TeleportGate", "explodeReaction");
		pair.die();
		this.die();
		
	}
	public void addEntity(Entity entity) {  // nem kell ide 
		//entities.add(entity);  //3.4.15    
		                         // minek addoljuk ha egybõl tovabbkuldjuk
		FunctionPrinter.enter("TeleportGate", "addEntity");
		teleportToPair(entity);
	}
	private void teleportToPair(Entity entity) {
		FunctionPrinter.enter("TeleportGate", "teleportToPair");
		entity.move(pair);
		pair.addEntity(entity);
		
	}
	public void setPair(TeleportGate teleport) {// ezt nem írom ki
		pair = teleport;
		
	}
}
