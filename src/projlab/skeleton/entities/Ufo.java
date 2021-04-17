package projlab.skeleton.entities;

import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.FunctionPrinter;

public class Ufo extends MovingEntity {

	
	
	
	@Override
	public void dig() {
	   
		
	}
	
	public void mine() {
	   
			// Bányásszuk ki az aszteroida nyersanyagát
			Resource resource = location.mineResource();//resourcenak die metodusa van?
			
		
	}
}
