package projlab.skeleton.entities;

import projlab.skeleton.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.utils.FunctionPrinter;

public abstract class Entity {

	private Asteroid location;
	
	public void dig() {
	    FunctionPrinter.enter("Entity", "dig");
		location.digLayer();
	    FunctionPrinter.exit();
	}

	public void move(Field field) {
	    FunctionPrinter.enter("Entity", "move");
		location.removeEntity(this);
		field.addEntity(this);
	    FunctionPrinter.exit();
	}

	public void die() {
	    FunctionPrinter.enter("Entity", "die");
		getLocation().removeEntity(this);
	    FunctionPrinter.exit();
	}

	public void explode() {
	    FunctionPrinter.enter("Entity", "explode");

	    FunctionPrinter.exit();
	}

	public Asteroid getLocation() {
	    FunctionPrinter.enter("Entity", "getLocation");
	    FunctionPrinter.exit();
	    return location;
	}

	public void setLocation(Asteroid field) {
	    FunctionPrinter.enter("Entity", "setLocation");
	    this.location = field;
	    FunctionPrinter.exit();
	}

}
