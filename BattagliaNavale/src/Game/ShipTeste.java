package Game;
/**
 * It's a tester class, create a ship and hit it until it's sunk
 * @author Project
 *
 */
public class ShipTeste {

	public static void main(String[] args) {
		Ships nave = new Ships("test", 2);
		nave.hit();
		System.out.println(nave.isSunk());
		nave.hit();
		System.out.println(nave.isSunk());
	}

}
