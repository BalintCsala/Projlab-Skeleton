package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.participants.Player;

import java.io.FileNotFoundException;


/**
 * Gyakorlatilag a statusbar-on megjelenő dolgokat rajzolja ki
 */

public class PlayerDrawer extends GameDrawer<Player> {

    /**
     * image-ek a képek betöltéséhez
     */
    Image aluminium = new Image("aluminium.png");
    Image coal = new Image("coal.png");
    Image copper = new Image("copper.png");
    Image iron = new Image("iron.png");
    Image plutonium = new Image("plutonium.png");
    Image sulfur = new Image("sulfur.png");
    Image uran = new Image("uran.png");
    Image waterice = new Image("waterice.png");
    Image teleport = new Image("teleport.png");
    Image crazyteleport = new Image("crazy_teleport.png");


    public PlayerDrawer() throws FileNotFoundException {
    }

    /**
     * Publikus függvény, ezt hivják meg kívülről
     * @param player aktív játékos
     * @param x koordináták
     * @param y koordináták
     * @throws Exception  akkor dobja ha valami olyan osztályt próbálunk kirajzolni ami nem létezik
     */
    @Override
    public void draw(Player player, int x, int y) throws Exception {
        drawName(player);
        drawResources(player);
        drawTeleports(player);
    }

    /**
     * Játékos nevét írja ki
     * @param player adott játékos
     */
    private void drawName(Player player) {
        GameController.g.fillText("Player",435, 10);
    }

    /**
     * A játékos telepesének tárhelyében található dolgokat rajzolja ki
     * @param player adott játékos
     * @throws Exception
     */
    private void drawResources(Player player) throws Exception {
        Settler s= player.getSettler();
        for (int i=0; i<s.getInventory().size(); i++){
            String r=s.getInventory().get(i).getClass().getSimpleName();
            int x= (155+i*60);
            int y =(435);
            switch (r) {
                case "Aluminium":
                    GameController.g.drawImage(aluminium,x,y);
                    break;
                case "Coal":
                    GameController.g.drawImage(coal,x,y);
                    break;
                case "Copper":
                    GameController.g.drawImage(copper,x,y);
                    break;
                case "Iron":
                    GameController.g.drawImage(iron,x,y);
                    break;
                case "Plutonium":
                    GameController.g.drawImage(plutonium,x,y);
                    break;
                case "Sulfur":
                    GameController.g.drawImage(sulfur,x,y);
                    break;
                case "Uran":
                   GameController.g.drawImage(uran,x,y);
                    break;
                case "WaterIce":
                    GameController.g.drawImage(waterice,x,y);
                    break;
                default:
                    throw new Exception("Nincs ilyen osztaly, nem tudok kepet tolteni hozza");

            }
        }
    }

    private void drawTeleports(Player player){
        Settler s= player.getSettler();
        for (int i=0; i<s.getTeleports().size(); i++){
            int x=(155+i*60);
            int y= (435);
            if (s.getTeleports().get(i).isCrazy()) {
                GameController.g.drawImage(crazyteleport,x,y);
            } else{GameController.g.drawImage(teleport,x,y);}
        }
    }

}
