package projlab.skeleton.graphics;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import projlab.skeleton.Game;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.participants.Player;


/**
 * Gyakorlatilag a statusbar-on megjelenő dolgokat rajzolja ki
 */

public class PlayerDrawer extends GameDrawer<Player> {


    /**
     * Publikus függvény, ezt hivják meg kívülről
     *
     * @param player aktív játékos
     * @param x      koordináták
     * @param y      koordináták
     */
    @Override
    public void draw(Player player, int x, int y) {
        drawName(player);
        drawInventory(player);
        drawTeleports(player);
    }

    /**
     * Játékos nevét írja ki
     *
     * @param player adott játékos
     */
    private void drawName(Player player) {
        int playerIndex = Game.getInstance().getPlayers().indexOf(player) + 1;
        GameController.graphics.setFill(Color.WHITE);
        GameController.graphics.setFont(new Font("Comic Sans MS", 30));
        GameController.graphics.fillText("Player #" + playerIndex, 18, 500);
        GameController.graphics.setFill(Color.BLACK);
    }

    /**
     * A játékos telepesének tárhelyében található dolgokat rajzolja ki
     *
     * @param player adott játékos
     */
    private void drawInventory(Player player) {
        Settler s = player.getSettler();
        for (int i = 0; i < s.getInventory().size(); i++) {
            Game.resourceDrawer.draw(s.getInventory().get(i), 175 + i * 60, 465);
        }
    }

    private void drawTeleports(Player player) {
        Settler s = player.getSettler();
        for (int i = 0; i < s.getTeleports().size(); i++) {
            int x = 175 + (i + 10) * 60;
            int y = 465;
            Game.teleportDrawer.draw(s.getTeleports().get(i), x, y);
        }
    }

}
