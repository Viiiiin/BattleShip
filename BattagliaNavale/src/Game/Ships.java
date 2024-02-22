package Game;
/**
 * The ship is the element to place in the field, every ship has a length (which is the same has the durability) and a name. A ship can be hit and it's durability decrease until it became sunk. 
 * @author Project
 *
 */
public class Ships {

	private String name;
	private boolean sunk;
	private int length;
	private int durability;

   /**
    * Instantiate a ship object
    * @param aName
    * @param aLength
    */
	public Ships(String aName, int aLength) {
		this.name = aName;
		this.length = aLength;
		this.sunk = false;
		this.durability = aLength;

	}
    /**
     * Set a hit at the ship and decrease it's durability
     */
	public void hit() {
		this.durability--;
		if (this.durability ==0) {
			this.sunk = true;
		}

	}
    /**
     * 
     * @return name
     */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return true if is sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
	/**
	 * 
	 * @return length
	 */
	public int getLength() {
		return this.length;
	}


	


}
