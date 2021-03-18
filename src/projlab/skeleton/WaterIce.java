package projlab.skeleton;

public class WaterIce extends Resource {

	
	
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("WaterIce", "reaction");
		a.setResource(null);
	}
}
