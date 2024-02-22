package Game;

import java.util.Random;

/**
 * Extends the player class but is a Bot that plays.
 * 
 * @author Project
 *
 */
public class PcPlayer extends Player {
	private Random rand;
	private Position lastPos;

	/**
	 * Create a PcPlayer with the given name
	 * 
	 * @param name
	 */
	public PcPlayer(String name) {
		super(name);
		rand = new Random();
		lastPos= new Position(-1,-1);
	}

	/**
	 * Place all the ships inside the field in random position and directions
	 */
	public void placeShip() {
		int direction, x, y;
		Ships ship;

		while (!this.shipsToLocate.isEmpty()) {
			direction = rand.nextInt(1000000);
		    randomPosition();
			ship = shipsToLocate.get(0);
			if (this.field.tryPositioner(ship, lastPos, direction)) {
				this.field.shipPositioner(ship, lastPos, direction);
				shipsToLocate.remove(0);
			}

		}
		this.lastPos.setX(-1);
		this.lastPos.setY(-1);
	}

	/**
	 * Change the last position
	 * @return 
	 */
	private void randomPosition() {
		int x = rand.nextInt(1000000) % 10;
		int y = rand.nextInt(1000000) % 10;
		this.lastPos.setX(x);
		this.lastPos.setY(y);
		
	}

	/**
	 * Hit a random enemy cell, choose a position until it finds one not hit yet. If
	 * the ship is sunk increments the points
	 * 
	 * @param enemyField
	 * 
	 */
	public void hit(Field enemyField) {
		Cell cell;
		randomPosition();
		cell = enemyField.getFieldCell(this.lastPos);
		while (cell.isHitten()) {
			randomPosition();
			cell = enemyField.getFieldCell(this.lastPos);
		}

		cell.setHit();
		if (!cell.isFree()) {
			Ships ship = cell.getShip();
			if (ship.isSunk()) {
				this.points++;
			}
		}
	}
	public Position lastPos() {
		return this.lastPos;
	}
}
