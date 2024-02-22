package Game;

import Graphics.FrameGame;
import Graphics.MyPlayField;
/**
 * A match contains a pc player and a human player
 * @author Project
 *
 */
public class Match {
	private Player huPlayer;
	private PcPlayer pcPlayer;
    /**
     * Instantiate a Match object
     */
	public Match() {
		this.huPlayer = new Player("User");
		this.pcPlayer = new PcPlayer("PC");
	}

   /**
    * 
    * @return Player object
    */
	public Player gethuPlayer() {
		return huPlayer;
	}
	/**
	 * 
	 * @return PcPlayer object
	 */
	public PcPlayer getPcPlayer() {
		return pcPlayer;
	}
}
