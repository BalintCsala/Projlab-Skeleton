package projlab.skeleton.entities;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

public class Robot extends Entity {

	public Robot() {
		FunctionPrinter.enter("Robot", "<<create>>", this);
		FunctionPrinter.register(this, "robot");
		AI.getInstance().addRobot(this);
		FunctionPrinter.exit();
	}

	public void explode() {
	    FunctionPrinter.enter("Robot", "explode", this);
		ArrayList<Field> neighbors = location.getNeighbors();
	    if (neighbors.isEmpty()) {
	    	die();
		} else {
	    	move(neighbors.get(0));
		}
	    FunctionPrinter.exit();
	}

}
