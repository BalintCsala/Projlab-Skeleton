package projlab.skeleton;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Canvas canvas;

    private GraphicsContext g;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        g = canvas.getGraphicsContext2D();
        g.fillRect(50, 100, 150, 200);
    }

}
