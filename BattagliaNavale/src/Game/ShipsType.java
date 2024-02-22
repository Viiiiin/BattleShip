package Game;
/**
 * There are different type of ships with different length and some are multiples.
 * This enumeration  will contains every type of ship with it's name, length, number of ships
 * @author Project
 *
 */
public enum ShipsType {
	PORTAEREI("Portaerei",5,1),
	CORAZZATA("Corazzata",4,1),
	CROCIERE("Crociere",3,2),
	SOTTOMARINI("Sottomarini",3,3),
	ASSALTO("Assalto",2,3);
	
	private String name;
	private int length;
	private int nShips;
	
	/**
	 * Instantiate a shipType object
	 * @param aName
	 * @param aLength
	 * @param numberOfShips
	 */
	private ShipsType(String aName, int aLength, int numberOfShips) {
		this.name= aName;
		this.length= aLength;
		this.nShips= numberOfShips;
	}
	/**
	 * 
	 * @return lenght
	 */
	public int getLength() {
		return length;
	}
	/**
	 * 
	 * @return number of Ships
	 */
	public int getNShips() {
		return nShips;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
