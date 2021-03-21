package projlab.skeleton.resources;
<<<<<<< HEAD
import projlab.skeleton.resources.Resource;
=======

>>>>>>> refs/remotes/origin/Bogi
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.FunctionPrinter;


public class WaterIce extends Resource {

	@Override
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("WaterIce", "reaction");
		a.setResource(null);
		FunctionPrinter.exit();
	}

}
