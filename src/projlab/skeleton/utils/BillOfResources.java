package projlab.skeleton.utils;

import projlab.skeleton.resources.Resource;

import java.util.ArrayList;
import java.util.Scanner;

public class BillOfResources {

	private final ArrayList<Resource> resources = new ArrayList<>();
	
	public void addResource(Resource resource) {
	    FunctionPrinter.enter("BillOfResources", "addResource");
		resources.add(resource);
	    FunctionPrinter.exit();
	}

	public boolean isCompleted(ArrayList<Resource> resources) {
	    FunctionPrinter.enter("BillOfResources", "isCompleted");
	    FunctionPrinter.msg("Kesz van a megadott resource lista? (I/N");
		boolean completed = new Scanner(System.in).next().equals("I");
	    FunctionPrinter.exit();
	    return completed;
	}
}
