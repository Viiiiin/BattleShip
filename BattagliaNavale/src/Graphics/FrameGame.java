package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Game.Cell;
import Game.Field;
import Game.Match;
import Game.PcPlayer;
import Game.Player;
import Game.Position;

public class FrameGame extends JFrame implements MouseListener {
	private MyPlayField playField;
	private Player huPlayer;
	private PcPlayer pcPlayer;
	private ShowMove showMove;
	private Match match;
	/**
	 * Create the Frame for the game
	 * @param aMatch
	 * @param userPlayField
	 */
	public FrameGame(Match aMatch, MyPlayField userPlayField) {
		super();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		this.match = aMatch;
		this.huPlayer = this.match.gethuPlayer();
		this.pcPlayer = this.match.getPcPlayer();
		this.playField = userPlayField;
		this.showMove = new ShowMove();

		pcPlayer.placeShip();
		FieldCell[][] indexField = playField.getIndexField();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				indexField[i][j].addMouseListener(this); // add the mouse listener to every cell of the indexfield
			}
		}

		this.playField.setPreferredSize(new Dimension(400, 400));
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		pane.add(playField, c);

		this.showMove.setPreferredSize(new Dimension(200, 200));

		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 20;
		c.ipadx = 20;
		this.add(showMove, c);
		this.pack();
	
		
	}

	public void mouseClicked(MouseEvent e) {
		if (pcPlayer.checkWin()) {
			JOptionPane.showMessageDialog(this, "I am sorry but PC win"); // If one of the Player gets 10 points a pop
																			// up will come out and the game will end
		} else if (huPlayer.checkWin()) {
			JOptionPane.showMessageDialog(this, "Congratulations User win");
		}
		Position pos, lastPos;
		Cell clickedCell, enemyCell;
		FieldCell clicked;
		Field enemyField, ourField;
		enemyField = pcPlayer.getField();
		ourField = huPlayer.getField();
		if (e.getClickCount() == 2) {
			clicked = (FieldCell) e.getComponent();

			if (!clicked.isHitted()) { // check that the label is not hit
				clicked.setHit();
				clickedCell = clicked.getCell(); // get the cell from the label
				pos = clickedCell.getPos(); // get the cell position
				enemyCell = enemyField.getFieldCell(pos); // get the cell in that position from enemy's field
				showMove.updateIcon(pos, enemyCell.isFree());
				this.huPlayer.hit(enemyCell);

				this.pcPlayer.hit(ourField);
				lastPos = this.pcPlayer.lastPos();
				changeImg(lastPos);

			}
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Change the image in the position given, green if the cell is free, red
	 * otherwise
	 * 
	 * @param pos
	 */
	public void changeImg(Position pos) {
		FieldCell[][] indexField = playField.getIndexField();
		String url = indexField[pos.getX()][pos.getY()].getUrl();
		Cell cell = indexField[pos.getX()][pos.getY()].getCell();
		ImageIcon imageIcon, img;
		url = url + ".jpg";
		imageIcon = new ImageIcon(url);
		BufferedImage buffered = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics g = buffered.createGraphics();
		imageIcon.paintIcon(null, g, 0, 0);	// paint the Icon to the BufferedImage.
		g.dispose();
		if (cell.isFree()) {
			img = changeRGB(buffered, 2);
		} else {
			img = changeRGB(buffered, 1);
		}
		
		Image newimg = img.getImage().getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
		ImageIcon newImageIcon = new ImageIcon(newimg); // assign to a new ImageIcon instance
		indexField[pos.getX()][pos.getY()].setIcon(newImageIcon);

	}

	/**
	 * Color the image given, green if colour is 1, red if colour is 2, green if
	 * colour is 3
	 * 
	 * @param image
	 * @param colour
	 * @return
	 */
	private ImageIcon changeRGB(BufferedImage image, int colour) {
		int width = image.getWidth();
		int height = image.getHeight();
		int newColor = 0;
		BufferedImage tempBuffer = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color color = new Color(image.getRGB(x, y));

				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();

				if (colour == 1) {
					newColor = new Color(red, 0, 0).getRGB();
				} else if (colour == 2) {
					newColor = new Color(0, green, 0).getRGB();
				} else if (colour == 3) {
					newColor = new Color(0, 0, blue).getRGB();
				}

				tempBuffer.setRGB(x, y, newColor);
			}
		}
		ImageIcon icon = new ImageIcon(tempBuffer);
		return icon;
	}

	
}