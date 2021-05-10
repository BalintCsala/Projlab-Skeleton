package projlab.skeleton.graphics;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import projlab.skeleton.Game;
import projlab.skeleton.GameController;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.utils.ClickArea;


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
        GameController.graphics.setFill(Color.WHITE);
        GameController.graphics.setFont(new Font("Comic Sans MS", 30));
        GameController.graphics.fillText(player.getName(), 18, 500);
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
            final Resource res = s.getInventory().get(i);
            Game.resourceDrawer.draw(res, 175 + i * 60, 465);
            GameController.clickAreas.add(new ClickArea(175 + i * 60, 465, 50, 50, () -> {
                player.getSettler().placeDownResource(res);
                Game.getInstance().round();
            }));
        }
    }

    /**
     * Kirajzolja az adott játékos teleportjait
     *
     * @param player adott játékos
     */
    private void drawTeleports(Player player) {
        final Settler s = player.getSettler();
        for (int i = 0; i < s.getTeleports().size(); i++) {
            final TeleportGate teleport = s.getTeleports().get(i);
            int x = 175 + (i + 10) * 60;
            int y = 465;
            Game.teleportDrawer.draw(teleport, x, y);
            GameController.clickAreas.add(new ClickArea(x, y, 50, 50, () -> {
                s.placeDownTeleport(s.getLocation(), teleport);
                Game.getInstance().round();
            }));
        }
    }

}
