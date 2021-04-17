package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.utils.FunctionPrinter;

/**
 * Az entitásokat jelképező absztrakt ősosztály
 */
public abstract class MovingEntity {

	protected Asteroid location;

	/**
	 * Az entitás ásás parancsát implementáló metódus
	 */
	public void dig() {
	    FunctionPrinter.enter("MovingEntity", "dig", this);
		location.digLayer();
	    FunctionPrinter.exit();
	}

	/**
	 * Az entitás mozgás parancsát implementáló metódus
	 * @param field A mező, amire szeretnénk, hogy az entitás lépjen
	 */
	public void move(Field field) {
	    FunctionPrinter.enter("MovingEntity", "move", this, field);
	    // Távolítsuk el az entitást a mostani helyéről és rakjuk át a másikra
		location.removeEntity(this);
		field.addEntity(this);
	    FunctionPrinter.exit();
	}

	/**
	 * Az entitás halálát elvégző művelet
	 */
	public void die() {
	    FunctionPrinter.enter("MovingEntity", "die", this);
	    location.removeEntity(this);
	    FunctionPrinter.exit();
	}

	/**
	 * Az entitás felrobbanását implementáló metódus
	 */
	public abstract void explode();

	/**
	 * Visszaadja az aszteroidát, amin az entitás jelenleg tartózkodik
	 * @return Az entitás tartózkodási helye
	 */
	public Asteroid getLocation() {
	    FunctionPrinter.enter("MovingEntity", "getLocation", this);
	    FunctionPrinter.exit();
	    return location;
	}

	/**
	 * Beállítja az aszteroidát, amin a telepes jelenleg tartózkodik
	 * @param field Az entitás új tartózkodási helye
	 */
	public void setLocation(Asteroid field) {
	    FunctionPrinter.enter("MovingEntity", "setLocation", this, field);
	    this.location = field;
	    FunctionPrinter.exit();
	}

}
