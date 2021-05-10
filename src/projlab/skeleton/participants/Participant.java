package projlab.skeleton.participants;

/**
 * A játékban résztvevőket jelképező absztrakt ősosztály
 */
public abstract class Participant {

    /**
     * A résztvevő játszik-e
     */
    protected boolean isPlaying = true;

    /**
     * A résztvevő köre
     */
    public abstract void round();

    /**
     * Visszaadja hogy a résztvevő játszik-e
     * 
     * @return a résztvevő játszik-e
     */
    public boolean getIsPlaying() {
        return isPlaying;
    }
}
