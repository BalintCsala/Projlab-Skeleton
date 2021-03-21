package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

public class AI extends Participant {

    private static AI instance;

    private final ArrayList<Robot> robots = new ArrayList<>();

    public AI() { }

    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    public void addRobot(Robot robot) {
        FunctionPrinter.enter("AI", "addRobot");
        robots.add(robot);
        FunctionPrinter.exit();
    }

    public void removeRobot(Robot robot) {
        FunctionPrinter.enter("AI", "removeRobot");
        robots.remove(robot);
        FunctionPrinter.exit();
    }

}
