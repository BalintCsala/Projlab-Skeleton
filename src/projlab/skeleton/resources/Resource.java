package projlab.skeleton.resources;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.FunctionPrinter;

public abstract class Resource {

	public void reaction(Asteroid a) {
		FunctionPrinter.enter("Resource", "reaction");
		FunctionPrinter.exit();
	}
}
