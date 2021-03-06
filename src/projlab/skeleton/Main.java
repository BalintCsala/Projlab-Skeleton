package projlab.skeleton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A program kezdőosztálya
 */
public class Main extends Application {

    public static Stage stage;
    /**
     * Az UI létrehozása
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));

            Scene scene = new Scene(root, 960, 540);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Asteroids and Settlers");
            primaryStage.setWidth(976);
            primaryStage.setHeight(579);
            primaryStage.setResizable(false);
            primaryStage.show();
            stage = primaryStage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A program belépési pontja
     * @param args A program argumentumai
     */
    public static void main(String[] args) {
    	launch(args);
    }
    
}
