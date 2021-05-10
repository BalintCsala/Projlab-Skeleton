package projlab.skeleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import projlab.skeleton.participants.Player;
import projlab.skeleton.utils.ClickArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * A játékot vezérlő osztály
 *
 */
public class GameController implements Initializable {

    /**
     * Canvas, amire a játék objektumai vannak kirajzolva
     */
    @FXML
    public Canvas canvas;
    /**
     * A canvashoz tartozó GraphicsContext, melynek segtségével rajzolni lehet a canvasra
     */
    public static GraphicsContext graphics;

    public static final ArrayList<ClickArea> clickAreas = new ArrayList<>();

    public static void endGame() {

    }

    /**
     * Az initialize metódus implementációja.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphics = canvas.getGraphicsContext2D();
        Game.getInstance().startGame();
        Game.getInstance().round();
        canvas.setOnMouseClicked(event -> {
            int x = (int)event.getSceneX();
            int y = (int)event.getSceneY();
            for (ClickArea clickArea : clickAreas) {
                if (x >= clickArea.x && x <= clickArea.x + clickArea.width && y >= clickArea.y && y <= clickArea.y + clickArea.height) {
                    clickArea.clickEvent.onClick();
                    break;
                }
            }
        });
    }

    /**
     * Ásás esemény.
     */
    @FXML
    public void Dig() {
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.getSettler().dig();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }

    /**
     * Bányászás esemény.
     */
    @FXML
    public void Mine() {
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.getSettler().mine();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }

    /**
     * Teleport építése esemény.
     */
    @FXML
    public void BuildTeleport() {
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.getSettler().buildTeleport();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }

    /**
     * Robot építése esemény.
     */
    @FXML
    public void BuildRobot() {
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.getSettler().buildRobot();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }
    @FXML
    public void Pass(){
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.pass();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }
    @FXML
    public void GiveUp(){
        for (int i = 0; i < Game.getInstance().getPlayers().size(); i++) {
            Player player = Game.getInstance().getPlayers().get(i);
            if (player.isActive()) {
                player.giveUp();
                player.setActive(false);
            }
        }
        Game.getInstance().round();
    }
}
