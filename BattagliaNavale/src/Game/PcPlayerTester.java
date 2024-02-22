package Game;
//Class that create two PcPlayer object, place the ships, and starts a battle between them. At the end print the Winner.
public class PcPlayerTester {

	public static void main(String[] args) {
		System.out.println("start");
		PcPlayer pc = new PcPlayer("PC1");
		pc.placeShip();
		PcPlayer pc2 = new PcPlayer("PC2");
		pc2.placeShip();
		System.out.println("Done");

		while (pc.getPoints() != 10 && pc2.getPoints() != 10) {
			pc.hit(pc2.getField());
			pc2.hit(pc.getField());
		}
		System.out.println(pc2.getPoints());
		System.out.println(pc.getPoints());
		if (pc.getPoints() == pc2.getPoints()) {
			System.out.println("Pareggio");
		} else {
			if (pc.getPoints() > pc2.getPoints()) {
				System.out.println("vince pc1");
			} else {
				System.out.println("vince pc2");
			}
		}

	}

}
