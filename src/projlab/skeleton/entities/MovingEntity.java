package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;

/**
 * Az entitásokat jelképező absztrakt ősosztály
 */
public abstract class MovingEntity {

    protected Asteroid location;

    /**
     * Az entitás ásás parancsát implementáló metódus
     */
    public void dig() {
        location.digLayer();
    }

    /**
     * AZ entitás mozgás parancsát implementáló metódus
     *
     * @param field A mező, amire szeretnénk, hogy az entitás lépjen
     */
    public void move(Field field) {
    	// Távolítsuk el az entitást a mostani helyéről és rakjuk át a másikra
        location.removeEntity(this);
        field.addEntity(this);
    }

    /**
     * Az entitás halálát elvégző művelet
     */
    public void die() {
        location.removeEntity(this);
    }

    /**
     * Az entitás felrobbanását implementáló metódus
     */
    public abstract void explode();

    /**
     * Visszaadja az aszteroidát, amin az entitás jelenleg tartózkodik
     *
     * @return Az entitás tartózkodási helye
     */
    public Asteroid getLocation() {
        return location;
    }

    /**
     * Beállítja az aszteroidát, amin a telepes jelenleg tartózkodik
     *
     * @param field Az entitás új tartózkodási helye
     */
    public void setLocation(Asteroid field) {
        this.location = field;
    }

}
