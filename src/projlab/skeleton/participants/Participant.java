package projlab.skeleton.participants;

/**
 * A játékban résztvevőket jelképező absztrakt ősosztály
 */
public abstract class Participant {

	
	/**
	 * Megmondja, hogy j�t�kban van-e az adott r�sztvev�
	 */
	protected boolean isPlaying=true;
	/**
	 * a r�sztvev� egy k�r�nek megval�s�t�sa
	 */
	public abstract void round();
	/**
	 * Visszaadja, hogy j�t�kban van-e az adott r�sztvev�
	 * @return j�t�kban van-e a r�sztvev�
	 */
	public boolean getisplaying() {
		return isPlaying;
	}
}
