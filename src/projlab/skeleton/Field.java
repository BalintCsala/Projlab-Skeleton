package projlab.skeleton;

import java.util.ArrayList;

public class Field {
	
	protected ArrayList<Entity> entities;
	protected ArrayList<Field> neighbors;
	
	public Field() {
		entities = new ArrayList<Entity>();
		neighbors = new ArrayList<Field>();
	}
	
	public void addNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "addNeighbor");
		 neighbors.add(f);
		 FunctionPrinter.exit();
	}
	public void removeNeighbor(Field f) {
		 FunctionPrinter.enter("Field", "removeNeighbor");
		 neighbors.remove(f);
		 FunctionPrinter.exit();
	}
	public void addEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "addEntity");
		entities.add(entity);
		FunctionPrinter.exit();
	}
	public void removeEntity(Entity entity) {
		 FunctionPrinter.enter("Field", "removeEntity");
		 entities.remove(entity);
		 FunctionPrinter.exit();
	}
	public void solarFlare() {   //  3.4.10 ennek nem kell semmit csinalnia aszteroida feluldefinialja?
		 FunctionPrinter.enter("Field", "solarFlare");
		 FunctionPrinter.exit();
	}
	public void explodeReaction() {
		 FunctionPrinter.enter("Field", "explodeReaction");
		 FunctionPrinter.exit();
	}
	public ArrayList<Field> getNeighbors(){//nem irom ki
		 
		return neighbors;
	}
	
	
}
