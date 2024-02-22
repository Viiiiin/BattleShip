package Graphics;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Game.Cell;
import Game.Ships;
/**
 * The FieldCell is a JLabel extension that contains an url, a cell object and it can be hit or not 
 * @author Project
 *
 */
public class FieldCell extends JLabel {
	private String url;
	private Cell cell;
	private boolean hitted;
	/**
	 * 
	 * @param Cell
	 */
	/**
	 * Create the label that contains a reference of a Cell object
	 */
	public FieldCell(Cell aCell) {
		super();
		this.cell = aCell;
		this.hitted = false;
		this.url = "Navi/water";
		ImageIcon imageIcon = new ImageIcon(url+".jpg"); // assign image to a new ImageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(40, 50, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
		ImageIcon newImageIcon = new ImageIcon(newimg); // assign to a new ImageIcon instance
		setIcon(newImageIcon);
	}
    
	

	/**
	 * Change the url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url=url;
	}
	/**
	 * 
	 * @return String
	 */
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * 
	 * @return Cell
	 */
	public Cell getCell() {
		return this.cell;
	}
	
	/**
	 * Set the hit
	 */
	public void setHit() {
		this.hitted = true;
	}
	
	/**
	 * 
	 * @return Boolean true if is hit
	 */
	public boolean isHitted() {
		return this.hitted;
	}
}
