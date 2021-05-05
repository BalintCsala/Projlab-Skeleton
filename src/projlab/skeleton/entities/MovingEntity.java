package projlab.skeleton.entities;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;

/**
 * Az entitásokat jelképező absztrakt ősosztály
 */
public abstract class MovingEntity {

    protected Asteroid location;

<<<<<<< HEAD
	/**
	 * Az entitás ásás parancsát implementáló metódus
	 */
	public void dig() {
	   
		location.digLayer();
	   
	}
=======
    /**
     * Az entitás ásás parancsát implementáló metódus
     */
    public void dig() {
        location.digLayer();
    }
>>>>>>> refs/remotes/origin/main

<<<<<<< HEAD
	/**
	 * Az entitás mozgás parancsát implementáló metódus
	 * @param field A mező, amire szeretnénk, hogy az entitás lépjen
	 */
	public void move(Field field) {
	   
	    // Távolítsuk el az entitást a mostani helyéről és rakjuk át a másikra
		location.removeEntity(this);
		field.addEntity(this);
	    
	}
=======
    /**
     * Az entitás mozgás parancsát implementáló metódus
     *
     * @param field A mező, amire szeretnénk, hogy az entitás lépjen
     */
    public void move(Field field) {
        // Távolítsuk el az entitást a mostani helyéről és rakjuk át a másikra
        location.removeEntity(this);
        field.addEntity(this);
    }
>>>>>>> refs/remotes/origin/main

<<<<<<< HEAD
	/**
	 * Az entitás halálát elvégző művelet
	 */
	public void die() {
	    //elt�vol�tjuk az aszteroid�r�l
	    location.removeEntity(this);
	    
	}
=======
    /**
     * Az entitás halálát elvégző művelet
     */
    public void die() {
        location.removeEntity(this);
    }
>>>>>>> refs/remotes/origin/main

    /**
     * Az entitás felrobbanását implementáló metódus
     */
    public abstract void explode();

<<<<<<< HEAD
	/**
	 * Visszaadja az aszteroidát, amin az entitás jelenleg tartózkodik
	 * @return Az entitás tartózkodási helye
	 */
	public Asteroid getLocation() {
	    
	    return location;
	}
=======
    /**
     * Visszaadja az aszteroidát, amin az entitás jelenleg tartózkodik
     *
     * @return Az entitás tartózkodási helye
     */
    public Asteroid getLocation() {
        return location;
    }
>>>>>>> refs/remotes/origin/main

<<<<<<< HEAD
	/**
	 * Beállítja az aszteroidát, amin a telepes jelenleg tartózkodik
	 * @param field Az entitás új tartózkodási helye
	 */
	public void setLocation(Asteroid field) {
	    
	    this.location = field;
	   
	}
=======
    /**
     * Beállítja az aszteroidát, amin a telepes jelenleg tartózkodik
     *
     * @param field Az entitás új tartózkodási helye
     */
    public void setLocation(Asteroid field) {
        this.location = field;
    }
>>>>>>> refs/remotes/origin/main

}
