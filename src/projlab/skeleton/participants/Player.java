package projlab.skeleton.participants;

import projlab.skeleton.Game;
import projlab.skeleton.entities.Settler;

/**
 * A humán játékosokat jelképező osztály
 */
public class Player extends Participant {

    /**
     * A játékos telepese
     */
    private Settler settler;

    /**
     * A feladás parancsot implementáló metódus
     */
    public void giveUp() {
        // Öljük meg a telepest
        settler.die();
        // Távolítsuk el a játékost a játékból
        Game.getInstance().removeParticipant(this);
    }

    /**
     * A semmittevés/passz parancsot implementáló metódus, nem csinál semmit
     */
    public void pass() {
    }

    /**
     * Beállítja a játékos telepesét
     *
     * @param settler A beállítandó telepes
     */
    public void setSettler(Settler settler) {
        this.settler = settler;
    }
}
