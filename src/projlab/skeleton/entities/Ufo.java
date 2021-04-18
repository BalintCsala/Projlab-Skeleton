package projlab.skeleton.entities;

import projlab.skeleton.participants.AI;
import projlab.skeleton.resources.Resource;


public class Ufo extends MovingEntity implements MiningEntity {

	
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
    }
}
