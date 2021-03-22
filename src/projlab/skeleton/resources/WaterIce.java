package projlab.skeleton.resources;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.FunctionPrinter;


public class WaterIce extends Resource {

	@Override
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("WaterIce", "reaction", this, a);
		a.setResource(null);
		FunctionPrinter.exit();
	}

}
