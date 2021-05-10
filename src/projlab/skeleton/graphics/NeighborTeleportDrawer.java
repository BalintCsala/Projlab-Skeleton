package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.map.TeleportGate;

public class NeighborTeleportDrawer extends GameDrawer<TeleportGate> {

    Image normalTeleport = new Image("teleport.png");
    Image crazyTeleport = new Image("crazy_teleport.png");

    @Override
    public void draw(TeleportGate teleport, int x, int y) {
        GameController.graphics.drawImage(teleport.isCrazy() ? crazyTeleport : normalTeleport, x, y, 100, 100);
    }
}
