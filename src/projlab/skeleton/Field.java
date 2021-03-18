package projlab.skeleton;

import java.util.ArrayList;

public class Field {
	
	protected ArrayList<Entity> entities;
	protected ArrayList<Field> neighbors;
	
	public void addNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "addNeighbor");
		
	}
	public void removeNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "removeNeighbor");
		
	}
	public void addEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "addEntity");
		
	}
	public void removeEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "removeEntity");
		
	}
	public void solarFlare() {
		 FunctionPrinter.enter("Field", "solarFlare");
		
	}
	public void explodeReaction() {
		 FunctionPrinter.enter("Field", "explodeReaction");
		
	}
	public ArrayList<Field> getNeighbors(){//nem irom ki
		 
		return neighbors;
	}
	
	
}
