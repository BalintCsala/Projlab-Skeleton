package projlab.skeleton;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;
import projlab.skeleton.participants.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    public Canvas canvas;
    @FXML
    public static Text solarFlareText;

    private GraphicsContext g;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        g = canvas.getGraphicsContext2D();
        g.fillRect(50, 100, 150, 200);
    }

    @FXML
    public void Dig(ActionEvent event) {
        for (int i = 0; i < Game.getInstance().getParticipants().size(); i++) {
            if (((Player) Game.getInstance().getParticipants().get(i)).isActive()) {
                ((Player) Game.getInstance().getParticipants().get(i)).getSettler().dig();
                ((Player) Game.getInstance().getParticipants().get(i)).setActive(false);
            }
        }
    }

    @FXML
    public void Mine(ActionEvent event) {
        for (int i = 0; i < Game.getInstance().getParticipants().size(); i++) {
            if (((Player) Game.getInstance().getParticipants().get(i)).isActive()) {
                ((Player) Game.getInstance().getParticipants().get(i)).getSettler().mine();
                ((Player) Game.getInstance().getParticipants().get(i)).setActive(false);
            }
        }
    }

    @FXML
    public void BuildTeleport(ActionEvent event) {
        for (int i = 0; i < Game.getInstance().getParticipants().size(); i++) {
            if (((Player) Game.getInstance().getParticipants().get(i)).isActive()) {
                ((Player) Game.getInstance().getParticipants().get(i)).getSettler().buildTeleport();
                ((Player) Game.getInstance().getParticipants().get(i)).setActive(false);
            }
        }
    }

    @FXML
    public void BuildRobot(ActionEvent event) {
        for (int i = 0; i < Game.getInstance().getParticipants().size(); i++) {
            if (((Player) Game.getInstance().getParticipants().get(i)).isActive()) {
                ((Player) Game.getInstance().getParticipants().get(i)).getSettler().buildRobot();
                ((Player) Game.getInstance().getParticipants().get(i)).setActive(false);
            }
        }
    }
}
