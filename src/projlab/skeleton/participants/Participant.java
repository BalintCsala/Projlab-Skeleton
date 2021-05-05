package projlab.skeleton.participants;

/**
 * A j√°t√©kban r√©sztvev≈ëket jelk√©pez≈ë absztrakt ≈ësoszt√°ly
 */
public abstract class Participant {

<<<<<<< HEAD
	
	/**
	 * Megmondja, hogy j·tÈkban van-e az adott rÈsztvevı
	 */
	protected boolean isPlaying=true;
	/**
	 * a rÈsztvevı egy kˆrÈnek megvalÛsÌt·sa
	 */
	public abstract void round();
	/**
	 * Visszaadja, hogy j·tÈkban van-e az adott rÈsztvevı
	 * @return j·tÈkban van-e a rÈsztvevı
	 */
	public boolean getisplaying() {
		return isPlaying;
	}
=======
    protected boolean isPlaying = true;

    public abstract void round();

    public boolean getIsPlaying() {
        return isPlaying;
    }
>>>>>>> refs/remotes/origin/main
}
