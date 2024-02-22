package Graphics;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Game.Cell;
import Game.Field;
import Game.Player;
import Game.Position;
/**
 * The User field is a JPanel with a GridBagLayout on it every cell is an FieldCell object except the first row and column
 * @author Project
 *
 */
public class MyPlayField extends JPanel {

	private FieldCell[][] indexField;
	private Player huPlayer;
	private static final int ROW = 11;
	private static final int COLUMNS = 10;

	public MyPlayField(Player aPlayer) {
		super();
		Field gameField;
		this.huPlayer = aPlayer;
		gameField = this.huPlayer.getField();

		this.setLayout(new GridLayout(ROW, COLUMNS, 0, 0));
		this.indexField = new FieldCell[ROW - 1][COLUMNS];
													//create the game field  the first row and column are for letters and numbers
		for (int x = 0; x < ROW; x++) {
			if (x > 0) {
				this.add(new JLabel(Character.toString((char) (('A' + x) - 1)), SwingConstants.CENTER));
			} else {
				this.add(new JLabel(" "));
			}
			for (int y = 0; y < COLUMNS; y++) {

				if (x == 0) {
					this.add(new JLabel(Integer.toString(y + 1), SwingConstants.CENTER));
				} else {

					Cell cell = gameField.getFieldCell(new Position(x - 1, y));
					this.indexField[x - 1][y] = new FieldCell(cell);

					this.add(this.indexField[x - 1][y]);

				}
			}
		}

	}

	public FieldCell[][] getIndexField() {
		return this.indexField;
	}
}
