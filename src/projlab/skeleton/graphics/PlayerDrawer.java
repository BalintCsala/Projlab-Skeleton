package projlab.skeleton.graphics;

import projlab.skeleton.entities.Settler;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Resource;

/**
 * Gyakorlatilag a statusbar-on megjelenő dolgokat rajzolja ki
 */

public class PlayerDrawer extends GameDrawer<Player> {

    @Override
    public void draw(Player player, int x, int y) {
        drawName(player);
        drawResources(player);
        drawTeleports(player);
    }

    public void drawName(Player player) {
        //TODO: Kiírni coor: 870:40 player.toString()
    }

    public void drawResources(Player player) {
        Settler s= player.getSettler();
        for (Resource r: s.getInventory()){

        }
    }

    public void drawTeleports(Player player){

    }
}
