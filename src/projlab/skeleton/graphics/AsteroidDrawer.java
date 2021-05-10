package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.Game;
import projlab.skeleton.GameController;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.ClickArea;

/**
 * Kirajzol egy kis méretű aszteroidát adott koordinátákra (vagyis ez rajzolja a szomszédos aszteroidákat, de nem a nagyot!
 */
public class AsteroidDrawer extends GameDrawer<Asteroid> {

    Image background = new Image("background.png");
    Image backgroundNearSun = new Image("background_nearsun.png");
    Image[] normalImages = new Image[]{
            new Image("asteroid.png"),
            new Image("asteroid_dug.png"),
            new Image("asteroid_fully_dug.png")
    };
    Image[] nearSunImages = new Image[]{
            new Image("asteroid_nearSun.png"),
            new Image("asteroid_nearSun_dug.png"),
            new Image("asteroid_nearSun_fully_dug.png")
    };
    Image leftArrow = new Image("arrow_left_off.png");
    Image rightArrow = new Image("arrow_right_off.png");
    Image leftArrowNearSun = new Image("arrow_nearsun_left_off.png");
    Image rightArrowNearSun = new Image("arrow_nearsun_right_off.png");

    public void draw(Asteroid asteroid) {
        draw(asteroid, 0, 0);
    }

    @Override
    public void draw(Asteroid asteroid, int x, int y) {
        Image[] choice;
        if (asteroid.isNearSun()) {
            choice = nearSunImages;
        } else {
            choice = normalImages;
        }

        Image image;
        if (asteroid.getHasBeenDug() && asteroid.getDepth() == 0) {
            image = choice[2];
        } else if (asteroid.getHasBeenDug()) {
            image = choice[1];
        } else {
            image = choice[0];
        }
        GameController.graphics.drawImage(asteroid.isNearSun() ? backgroundNearSun : background, 0, 0, 960, 540);
        GameController.graphics.drawImage(image, 230, 0, 500, 500);
        asteroid.draw();

        Image currLeftArrow = asteroid.isNearSun() ? leftArrowNearSun : leftArrow;
        Image currRightArrow = asteroid.isNearSun() ? rightArrowNearSun : rightArrow;

        GameController.clickAreas.clear();
        for (int i = 0; i < asteroid.getNeighbors().size(); i++) {
            int side = (i % 2) * 2 - 1;
            int neighborX = 480 + 350 * side - 50;
            int arrowX = 480 + 250 * side - 50;
            int neighborY = 60 + 60 * i - 50;
            GameController.graphics.drawImage(i % 2 == 0 ? currLeftArrow : currRightArrow, arrowX, neighborY, 100, 100);
            asteroid.getNeighbors().get(i).drawAsNeighbor(neighborX, neighborY);
            final int asteroidIndex = i;
            GameController.clickAreas.add(new ClickArea(arrowX, neighborY, 100, 100, () -> {
                Game.getInstance().getCurrentPlayer().getSettler().move(asteroid.getNeighbors().get(asteroidIndex));
                Game.getInstance().round();
            }));
        }
    }

}
