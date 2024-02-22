package Game;

/**
 * A cell is a small section of the field every cell can be hit and can be empty or contains a ship.
 * @author Project
 *
 */
public class Cell {
	
	private Position pos;
	private Ships ship;
	private boolean hitten; 
	
/**Instantiate a cell with the position given
 * 
 * @param pos
 */
	public Cell(Position pos){
		this.hitten=false;
		this.ship=null;
		this.pos=pos;
	}
	
	/**
	 * 
	 * @return Return true if the cell doesn't contain any ship
	 */

	public boolean isFree() {
		if (this.ship==null) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @return Return the ship
	 */
	public Ships getShip() {
		return ship;
	}
	/**
	 * Change the hit in true and hit the ship inside the cell
	 */
	public void setHit(){
		if (!isFree()) {
		this.ship.hit();
		}
		hitten=true;
	}
	/**
	 * 
	 * @return Return true if is hit
	 */
	public boolean isHitten(){
		return hitten;
	}
	
	/**
	 * Set the ship inside the cell
	 * @param ship
	 */
	public void insertion(Ships ship){
		this.ship=ship;
	}

	/**
	 * 
	 * @return Return it's position
	 */
	public Position getPos() {
		return this.pos;
	}
}
