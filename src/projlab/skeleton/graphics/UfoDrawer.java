package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Ufo;

/**
 * Ufo kirajzolása
 */
public class UfoDrawer extends GameDrawer<Ufo> {

	Image ufoImage = new Image("ufo.png");
	
    @Override
    public void draw(Ufo ufo, int x, int y) {
    	GameController.graphics.drawImage(ufoImage, x, y, 64, 64);
    }

}
