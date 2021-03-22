package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.utils.FunctionPrinter;

public abstract class Entity {

	protected Asteroid location;
	
	public void dig() {
	    FunctionPrinter.enter("Entity", "dig", this);
		location.digLayer();
	    FunctionPrinter.exit();
	}

	public void move(Field field) {
	    FunctionPrinter.enter("Entity", "move", this, field);
		location.removeEntity(this);
		field.addEntity(this);
	    FunctionPrinter.exit();
	}

	public void die() {
	    FunctionPrinter.enter("Entity", "die", this);
	    location.removeEntity(this);
	    FunctionPrinter.exit();
	}

	public void explode() {
	    FunctionPrinter.enter("Entity", "explode", this);

	    FunctionPrinter.exit();
	}

	public Asteroid getLocation() {
	    FunctionPrinter.enter("Entity", "getLocation", this);
	    FunctionPrinter.exit();
	    return location;
	}

	public void setLocation(Asteroid field) {
	    FunctionPrinter.enter("Entity", "setLocation", this, field);
	    this.location = field;
	    FunctionPrinter.exit();
	}

}
