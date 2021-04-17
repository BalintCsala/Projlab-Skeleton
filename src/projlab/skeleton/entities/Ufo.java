package projlab.skeleton.entities;

import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.FunctionPrinter;

public class Ufo extends MovingEntity implements MiningEntity {

	
	
	
	@Override
	public void dig() {
	   
		
	}
	@Override
	public void mine() {
	   
			// Bányásszuk ki az aszteroida nyersanyagát
			Resource resource = location.mineResource();//resourcenak die metodusa van?
			
		
	}
	@Override
	public void explode() {
		
		die();
		
	}
}
