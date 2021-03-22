package projlab.skeleton.resources.radioactive;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.FunctionPrinter;

public abstract class Radioactive extends Resource {

	@Override
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("Radioactive", "reaction", this, a);
		a.explode();
		FunctionPrinter.exit();
	}

}
