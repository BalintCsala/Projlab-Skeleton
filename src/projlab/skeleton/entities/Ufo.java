package projlab.skeleton.entities;

import projlab.skeleton.participants.AI;
import projlab.skeleton.resources.Resource;


public class Ufo extends MovingEntity implements MiningEntity {

	
	/**
	 * dig fel�l�r�sa, az ufo nem csin�l ekkor semmit
	 */
	
	@Override
	public void dig() {
	   
		
	}
	/**
	 * MiningEntity mine met�dus implement�l�sa
	 * aszteroida b�ny�sz�sa a nyersanyag elt�rol�sa n�lk�l
	 */
	@Override
	public void mine() {
	   
			// Bányásszuk ki az aszteroida nyersanyagát, de nem kell elt�rolni
			Resource resource = location.mineResource();
			
		
	}
	/**
	 * explode implement�l�sa, az ufo meghal
	 */
	@Override
	public void explode() {
		
		die();
		
	}
	/**
     * A ufo halálát implementáló metódus
     */
    @Override
    public void die() {
        super.die();
        AI.getInstance().removeUfo(this);
    }
}
