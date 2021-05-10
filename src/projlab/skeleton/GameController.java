package projlab.skeleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;
import projlab.skeleton.participants.Player;
import projlab.skeleton.utils.ClickArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    public Canvas canvas;
    @FXML
    public static Text solarFlareText;

    public static GraphicsContext graphics;

    public static final ArrayList<ClickArea> clickAreas = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphics = canvas.getGraphicsContext2D();
        graphics.fillRect(50, 100, 150, 200);
        Game.getInstance().startGame();
        Game.getInstance().round();
        canvas.setOnMouseClicked(event -> {
            int x = (int)event.getSceneX();
            int y = (int)event.getSceneY();
            for (int i = 0; i < clickAreas.size(); i++) {
                ClickArea clickArea = clickAreas.get(i);
                if (x >= clickArea.x && x <= clickArea.x + clickArea.width && y >= clickArea.y && y <= clickArea.y + clickArea.height) {
                    clickArea.clickEvent.onClick();
                    break;
                }
            }
        });
    }

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
}
