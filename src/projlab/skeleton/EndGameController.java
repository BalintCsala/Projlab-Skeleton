package projlab.skeleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {

    public static boolean win = false;

    @FXML
    public Text gameEndText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameEndText.setText(win ? "Nyertel! :(" : "Vesztettel :)");
    }
}
