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

    private boolean isActive = false;

    /**
     * A feladás parancsot implementáló metódus
     */
    public void giveUp() {
        // Öljük meg a telepest
        if (settler != null)
            settler.die();
        // Távolítsuk el a játékost a játékból
        Game.getInstance().removeParticipant(this);
        isPlaying = false;
    }

    /**
     * A semmittevés/passz parancsot implementáló metódus, nem csinál semmit
     */
    public void pass() {
        isActive = false;
    }

    /**
     * Beállítja a játékos telepesét
     *
     * @param settler A beállítandó telepes
     */
    public void setSettler(Settler settler) {
        this.settler = settler;
    }

    @Override
    public void round() {
        isActive = true;
        if (!this.settler.isAlive()) {
            isPlaying = false;
        }
        if(!isActive) return;
    }

    public Settler getSettler() {
        return settler;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
