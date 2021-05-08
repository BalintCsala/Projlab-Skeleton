package projlab.skeleton.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Gyakorlatilag a statusbar-on megjelenő dolgokat rajzolja ki
 */

public class PlayerDrawer extends GameDrawer<Player> {

    /**
     * image-ek a képek betöltéséhez
     */
    Image aluminium = new Image(new FileInputStream("/res/aluminium.png"));
    Image coal = new Image(new FileInputStream("/res/coal.png"));
    Image copper = new Image(new FileInputStream("/res/copper.png"));
    Image iron = new Image(new FileInputStream("/res/iron.png"));
    Image plutonium = new Image(new FileInputStream("/res/plutonium.png"));
    Image sulfur = new Image(new FileInputStream("/res/sulfur.png"));
    Image uran = new Image(new FileInputStream("/res/uran.png"));
    Image waterice = new Image(new FileInputStream("/res/waterice.png"));
    Image teleport = new Image(new FileInputStream("/res/teleport.png"));
    Image crazyteleport = new Image(new FileInputStream("/res/crazy_teleport.png"));
    Text playername;
    ArrayList<ImageView> imageViews;

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
        imageViews.clear();
        drawName(player);
        drawResources(player);
        drawTeleports(player);
    }

    /**
     * Játékos nevét írja ki
     * @param player adott játékos
     */
    private void drawName(Player player) {
        playername=new Text(435,10,"Player"); //TODO: sorszámot adni a playernek
        playername.setFont(new Font(20));
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
            ImageView res=new ImageView();
            res.setX(310+i*120);
            res.setY(435);
            switch (r) {
                case "Aluminium":
                    res.setImage(aluminium);
                    break;
                case "Coal":
                    res.setImage(coal);
                    break;
                case "Copper":
                    res.setImage(copper);
                    break;
                case "Iron":
                    res.setImage(iron);
                    break;
                case "Plutonium":
                    res.setImage(plutonium);
                    break;
                case "Sulfur":
                    res.setImage(sulfur);
                    break;
                case"Uran":
                    res.setImage(uran);
                    break;
                case "WaterIce":
                    res.setImage(waterice);
                    break;
                default:
                    throw new Exception("Nincs ilyen osztaly, nem tudok kepet tolteni hozza");

            }
        }
    }

    private void drawTeleports(Player player){
        Settler s= player.getSettler();
        for (int i=0; i<s.getTeleports().size(); i++){
            ImageView tele=new ImageView();
            tele.setX(310+i*120);
            tele.setY(435);
            if (s.getTeleports().get(i).isCrazy()) {
                tele.setImage(crazyteleport);
            } else{tele.setImage(teleport);}
            imageViews.add(tele);
        }
    }

}
