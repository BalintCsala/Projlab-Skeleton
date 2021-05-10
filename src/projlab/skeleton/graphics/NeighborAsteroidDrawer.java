package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.map.Asteroid;

public class NeighborAsteroidDrawer extends GameDrawer<Asteroid> {

    Image normalAsteroid = new Image("asteroid.png");
    Image nearSunAsteroid = new Image("asteroid.png");

    @Override
    public void draw(Asteroid asteroid, int x, int y) {
        GameController.graphics.drawImage(asteroid.isNearSun() ? nearSunAsteroid : normalAsteroid, x, y, 100, 100);
    }
}
