package Game;
/**
 * It rapresents the game field
 * @author Project
 *
 */
public class Field {
	private Cell[][] grid;
/**
 * Create a matrix 10x10 of Cell object
 */
	public Field() {

		grid = new Cell[10][10];
		for (int i = 0; i < 10; i++) {
			for (int c = 0; c < 10; c++) {
				this.grid[i][c] = new Cell(new Position(i,c));
			}
		}
	}



/**
 * Place a ship inside the field
 * @param ship
 * @param position
 * @param direction
 */
	
	public void shipPositioner(Ships ship, Position position, int direction){
		int x=position.getX();
		int y=position.getY();
		int length= ship.getLength();
		if (direction%2==1){
			for(int i=x; i<x+length; i++){
				grid[i][y].insertion(ship);
			}
		}else{
			for(int i=y; i<y+length; i++){
				grid[x][i].insertion(ship);
			}
		}
	}

	/**
	 * Try to place the ship from the position given
	 * @param ship
	 * @param pos
	 * @param direction
	 * @return True if there is space for the ship
	 */

	public boolean tryPositioner(Ships ship, Position pos, int direction) {
		int length = ship.getLength();
		int x= pos.getX();
		int y=pos.getY();
		try {
			if (direction % 2 == 1) {
				for (int i = x; i < x + length; i++) {
					if (!grid[i][y].isFree()) {
						return false;
					}
				}
			} else {
				for (int i = y; i < y + length; i++) {
					if (!grid[x][i].isFree()) {
						return false;
					}
				}
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	
	/**
	 * 
	 * @param position
	 * @return The cell in the given position
	 */
	public Cell getFieldCell(Position position) {
		return this.grid[position.getX()][position.getY()];
	}
		

		
}
