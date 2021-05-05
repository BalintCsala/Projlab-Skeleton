package projlab.skeleton.entities;

<<<<<<< HEAD
import projlab.skeleton.participants.AI;
import projlab.skeleton.resources.Resource;

=======
import projlab.skeleton.utils.ObjectCatalog;
>>>>>>> refs/remotes/origin/main

public class Ufo extends MovingEntity implements MiningEntity {

<<<<<<< HEAD
	
	/**
	 * dig felülírása, az ufo nem csinál ekkor semmit
	 */
	
	@Override
	public void dig() {
	   
		
	}
	/**
	 * MiningEntity mine metódus implementálása
	 * aszteroida bányászása a nyersanyag eltárolása nélkül
	 */
	@Override
	public void mine() {
	   
			// BÃ¡nyÃ¡sszuk ki az aszteroida nyersanyagÃ¡t, de nem kell eltárolni
			Resource resource = location.mineResource();
			
		
	}
	/**
	 * explode implementálása, az ufo meghal
	 */
	@Override
	public void explode() {
		
		die();
		
	}
	/**
     * A ufo halÃ¡lÃ¡t implementÃ¡lÃ³ metÃ³dus
     */
    @Override
    public void die() {
        super.die();
        AI.getInstance().removeUfo(this);
=======
    private boolean alive = true;

    @Override
    public void dig() {

    }

    @Override
    public void mine() {
        // BÃ¡nyÃ¡sszuk ki az aszteroida nyersanyagÃ¡t
        location.mineResource();
    }

    @Override
    public void die() {
        super.die();
        alive = false;
    }

    @Override
    public void explode() {
        die();
    }

    @Override
    public String toString() {
        return "type: Ufo\n" +
                "name: " + ObjectCatalog.getName(this) + "\n" +
                "alive: " + alive;
>>>>>>> refs/remotes/origin/main
    }
}
