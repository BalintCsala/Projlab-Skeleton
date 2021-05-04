package projlab.skeleton.graphics;

import projlab.skeleton.entities.Settler;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Resource;

/**
 * Gyakorlatilag a statusbar-on megjelenő dolgokat rajzolja ki
 */

public class PlayerDrawer {
    private Player player;

    public PlayerDrawer(Player p){
        player=p;
    }

    public void draw() {
        drawName();
        drawResources();
        drawTeleports();
    }

    public void drawName() {
        //TODO: Kiírni coor: 870:40 player.toString()
    }

    public void drawResources() {
        Settler s= player.getSettler();
        for (Resource r: s.getInventory()){

        }
    }

    public void drawTeleports(){

    }
}
