package Graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Game.Position;
/**
 * ShowMove is a JPanle with a GridBagLayout that will show the results of the user move, it will color the cell in red if he hit or blue if he miss
 * @author vince
 *
 */
public class ShowMove extends JPanel{
	private static final int ROW = 11;
	private static final int COLUMNS = 10;
	private JLabel indexShowMove[][];
	
	public ShowMove() {
		indexShowMove=new JLabel[ROW-1][COLUMNS];
		this.setLayout(new GridLayout(ROW, COLUMNS, 0, 0));
		Border blackline = BorderFactory.createLineBorder(Color.black);
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
					this.indexShowMove[x-1][y]=new JLabel();
					this.indexShowMove[x-1][y].setOpaque(isOpaque());
					this.indexShowMove[x-1][y].setBackground(new Color(255,255,255));
					this.indexShowMove[x-1][y].setBorder(blackline);
					this.add(this.indexShowMove[x-1][y]);
				}
		
		
			}

		}
	}
	/**
	 * Will update the cell in a given position if is free it will be colored in blue, else in red
	 * @param pos
	 * @param free
	 */
	public void updateIcon(Position pos,boolean free) {
		JLabel label;
		label= this.indexShowMove[pos.getX()][pos.getY()];
		if (free) {
			label.setBackground(new Color(0,0,255));
		}
		else {
			label.setBackground(new Color(255,0,0));
		}
		
		
	}
}
