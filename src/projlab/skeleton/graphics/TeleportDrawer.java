package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.map.TeleportGate;

/**
 * Teleport kirajzolása
 */
public class TeleportDrawer extends GameDrawer<TeleportGate> {

	Image teleportImage = new Image("teleport.png");
	Image crazyTeleportImage = new Image("crazy_teleport.png");
	
    @Override
    public void draw(TeleportGate teleport, int x, int y) {
    	GameController.graphics.drawImage(teleport.isCrazy() ? crazyTeleportImage : teleportImage, x, y, 50, 50);
    }

}
