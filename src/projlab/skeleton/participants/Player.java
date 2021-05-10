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

    private String name;

    /**
     * A játékos éppen soron van-e
     */
    private boolean isActive = false;

    public Player(String name) {
        this.name = name;
    }

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

    /**
     * A játékos köre
     */
    @Override
    public void round() {
        isActive = true;
        if (!this.settler.isAlive()) {
            isPlaying = false;
        }
        if(!isActive) return;
    }

    /**
     * Visszaadja a játékos telepesét
     *
     * @return a játékos telepese
     */
    public Settler getSettler() {
        return settler;
    }

    /**
     * Visszaadja, hogy a játékos éppen soron van-e
     *
     * @return a játékos éppen soron van-e
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Beállítja, hogy a játékos éppen soron van-e
     *
     * @param active a játékos éppen soron van-e
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }
}
