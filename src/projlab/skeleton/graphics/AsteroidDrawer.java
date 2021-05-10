package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import projlab.skeleton.Game;
import projlab.skeleton.GameController;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
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

        for (int i = 0; i < asteroid.getNeighbors().size(); i++) {
            final Field neighbor = asteroid.getNeighbors().get(i);
            int side = (i % 2) * 2 - 1;
            int neighborX = 480 + 350 * side - 50;
            int arrowX = 480 + 250 * side - 50;
            int neighborY = 60 + 60 * i - 50;
            GameController.graphics.drawImage(i % 2 == 0 ? currLeftArrow : currRightArrow, arrowX, neighborY, 100, 100);
            neighbor.drawAsNeighbor(neighborX, neighborY);
            GameController.clickAreas.add(new ClickArea(arrowX, neighborY, 100, 100, () -> {
                Game.getInstance().getCurrentPlayer().getSettler().move(neighbor);
                Game.getInstance().round();
            }));
        }
        if(asteroid.getResource() == null) {
            GameController.graphics.setFont(new Font("Comic Sans MS", 20));
            GameController.graphics.fillText("ASTEROID RESOURCE: Empty", 599, 409);
            GameController.graphics.setFill(Color.WHITE);
            GameController.graphics.fillText("ASTEROID RESOURCE: Empty", 600, 410);
            GameController.graphics.setFill(Color.BLACK);
        }
        else {
            GameController.graphics.setFont(new Font("Comic Sans MS", 20));
            GameController.graphics.fillText("ASTEROID RESOURCE:" + asteroid.getResource().getClass().getSimpleName(), 599, 409);
            GameController.graphics.setFill(Color.WHITE);
            GameController.graphics.fillText("ASTEROID RESOURCE:" + asteroid.getResource().getClass().getSimpleName(), 600, 410);
            GameController.graphics.setFill(Color.BLACK);
        }


    }

}
