package Game;

import java.util.ArrayList;

/**
 * Player contains a Field object and an ArrayList of the ships. A player has
 * two main function: Place Ship: he can place the ships at some coordinates
 * Hit: hit a cell in the enemy field
 * 
 * @author Project
 *
 */
public class Player {

	protected String name;
	protected Field field;
	protected ArrayList<Ships> shipsToLocate;
	protected int points;
	private ShipsType shipsType;

	/**
	 * Initialize a Player object
	 * 
	 * @param aName
	 */
	public Player(String aName) {
		this.name = aName;
		this.field = new Field();
		this.shipsToLocate = new ArrayList<Ships>();
		

		// Iterate an Enum ShipsType object to create a list of ships to place
		
		for (ShipsType ship : shipsType.values()) {
			for (int i = 0; i < ship.getNShips(); i++) {
				Ships s = new Ships(ship.getName(), ship.getLength());
				this.shipsToLocate.add(s);
			}
		}

	}

	/**
	 * Set the hit in the given cell, if the hit will bring to a sunk it will also
	 * increments the points
	 * 
	 * @param cell
	 */
	public void hit(Cell cell) {

		Ships ship;
		cell.setHit();
		ship = cell.getShip();

		if (!cell.isFree()) {
			if (ship.isSunk()) {
				this.points++;

			}
		}
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * If all the ship are sunk the player won
	 * 
	 * @return True if player has 10 points
	 */
	public boolean checkWin() {
		if (this.points == 10) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return field
	 */
	public Field getField() {
		return this.field;
	}

	/**
	 * 
	 * @return points
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * If some ship left try to place them in the given position with a certain
	 * direction
	 * 
	 * @param pos
	 * @param direction
	 * @return True if the place ship went good
	 * 
	 */
	public boolean tryPlaceShip(Position pos, int direction) {
		Ships shipToPlace;

		shipToPlace = shipsToLocate.get(0);
		if (field.tryPositioner(shipToPlace, pos, direction)) {
			field.shipPositioner(shipToPlace, pos, direction);
			shipsToLocate.remove(0);
			return true;
		}

		return false;

	}

	/**
	 *
	 * @return The current ship if some left, else null
	 */

	public Ships getCurrentShip() {
		if (!shipsToLocate.isEmpty()) {
			return shipsToLocate.get(0);
		} else {
			return null;
		}
	}

}
