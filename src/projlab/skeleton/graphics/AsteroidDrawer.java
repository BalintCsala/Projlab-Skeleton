package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.map.Asteroid;

/**
 * Kirajzol egy kis méretű aszteroidát adott koordinátákra (vagyis ez rajzolja a szomszédos aszteroidákat, de nem a nagyot!
 */
public class AsteroidDrawer extends GameDrawer<Asteroid> {

	Image asteroidImage = new Image("asteroid.png");
	
    @Override
    public void draw(Asteroid asteroid, int x, int y) {
    	GameController.g.drawImage(asteroidImage, x, y, 100, 100);
    }

}
