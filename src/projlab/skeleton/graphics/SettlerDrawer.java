package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Settler;

/**
 *Telepes kirajzolása
 */
public class SettlerDrawer extends GameDrawer<Settler> {

	/**
	 * Telepes képe
	 */
	Image settlerImage = new Image("settler.png");
	
    /**
     * Kirajzol egy telepes a megadott pontra
     */
    @Override
    public void draw(Settler settler, int x, int y) {
    	GameController.graphics.drawImage(settlerImage, x, y, 64, 64);
    }

}
