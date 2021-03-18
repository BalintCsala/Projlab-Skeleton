package projlab.skeleton;

import java.util.ArrayList;

public class Field {
	
	protected ArrayList<Entity> entities;
	protected ArrayList<Field> neighbors;
	
	public void addNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "addNeighbor");
		 neighbors.add(f);
		
	}
	public void removeNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "removeNeighbor");
		 neighbors.remove(f);
	}
	public void addEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "addEntity");
		entities.add(entity);
	}
	public void removeEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "removeEntity");
		 entities.remove(entity);
	}
	public void solarFlare() {   //  3.4.10 ennek nem kell semmit csinalnia aszteroida feluldefinialja?
		 FunctionPrinter.enter("Field", "solarFlare");
		
	}
	public void explodeReaction() {
		 FunctionPrinter.enter("Field", "explodeReaction");
		
	}
	public ArrayList<Field> getNeighbors(){//nem irom ki
		 
		return neighbors;
	}
	
	
}
