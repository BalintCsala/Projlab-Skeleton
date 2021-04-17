package projlab.skeleton.participants;

/**
 * A játékban résztvevőket jelképező absztrakt ősosztály
 */
public abstract class Participant {

	protected boolean isPlaying=true;
	
	public abstract void round();
	
	public boolean getisplaying() {
		return isPlaying;
	}
}
