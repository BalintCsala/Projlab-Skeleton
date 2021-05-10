package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.resources.Resource;

/**
 * egy darab resource kirajzolása
 */
public class ResourceDrawer extends GameDrawer<Resource> {

    Image aluminium = new Image("aluminium.png");
    Image coal = new Image("coal.png");
    Image copper = new Image("copper.png");
    Image iron = new Image("iron.png");
    Image plutonium = new Image("plutonium.png");
    Image sulfur = new Image("sulfur.png");
    Image uran = new Image("uran.png");
    Image waterice = new Image("waterice.png");

    @Override
    public void draw(Resource resource, int x, int y) {
        Image image = null;
        switch (resource.getClass().getSimpleName()) {
            case "Aluminium":
                image = aluminium;
                break;
            case "Coal":
                image = coal;
                break;
            case "Copper":
                image = copper;
                break;
            case "Iron":
                image = iron;
                break;
            case "Plutonium":
                image = plutonium;
                break;
            case "Sulfur":
                image = sulfur;
                break;
            case "Uran":
                image = uran;
                break;
            case "WaterIce":
                image = waterice;
                break;

        }
        GameController.graphics.drawImage(image, x, y, 50, 50);
    }

}
