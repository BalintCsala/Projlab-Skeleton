package projlab.skeleton;

public class Radioactive extends Resource {

	
	
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("Radioactive", "reaction");
		a.explode();
		FunctionPrinter.exit();
	}
}
