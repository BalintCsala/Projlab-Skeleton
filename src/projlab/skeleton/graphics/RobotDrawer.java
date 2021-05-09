package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Robot;

/**
 * Robot kirajzolása
 */
public class RobotDrawer extends GameDrawer<Robot> {

	Image robotImage = new Image("robot.png");
	
    @Override
    public void draw(Robot robot, int x, int y) {
    	GameController.g.drawImage(robotImage, x, y, 64, 64);
    }

}
