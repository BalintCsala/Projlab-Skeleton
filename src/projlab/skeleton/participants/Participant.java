package projlab.skeleton.participants;

/**
 * A jÃ¡tÃ©kban rÃ©sztvevÅ‘ket jelkÃ©pezÅ‘ absztrakt Å‘sosztÃ¡ly
 */
public abstract class Participant {

	
	/**
	 * Megmondja, hogy játékban van-e az adott résztvevõ
	 */
	protected boolean isPlaying=true;
	/**
	 * a résztvevõ egy körének megvalósítása
	 */
	public abstract void round();
	/**
	 * Visszaadja, hogy játékban van-e az adott résztvevõ
	 * @return játékban van-e a résztvevõ
	 */
	public boolean getisplaying() {
		return isPlaying;
	}
}
