package Game;
/**
 * A position is a couple of two number x,y
 * @author Project
 *
 */
public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return Int
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @return Int
	 */
	
	public int getY() {
		return y;
	}
	
	/**
	 * Change the y value
	 * @param y
	 */
	public void setY(int y) {
		this.y=y;	
	}
	
	/**
	 * Change the x value
	 * @param x
	 */
	public void setX(int x) {
		this.x=x;	
	}
}
