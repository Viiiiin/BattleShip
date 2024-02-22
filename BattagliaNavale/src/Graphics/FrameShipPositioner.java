package Graphics;



import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Game.Cell;
import Game.Field;
import Game.Match;
import Game.PcPlayer;
import Game.Player;
import Game.Position;
import Game.Ships;




public class FrameShipPositioner extends JFrame implements MouseListener,ActionListener {
	private Match match;
	private MyPlayField playField;
	private Player huPlayer;
	private PcPlayer pcPlayer;
	private JTextArea textArea;
	private JButton finish;
	private int i=0;
	/**
	 * Create the Frame for the ship placing adding the MyPlayField and two buttons
	 * @param aMatch
	 */
	public FrameShipPositioner(Match aMatch) {
		super();
		
		this.match= aMatch;
		this.huPlayer= this.match.gethuPlayer();
		this.pcPlayer = this.match.getPcPlayer();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
				
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Verticale");
		c.gridx = 0;
		c.gridy = 0;
		
		add(textArea, c);
		

		playField =new MyPlayField(this.huPlayer);
		this.playField.setPreferredSize(new Dimension(400, 400));
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		pane.add(playField, c);
		
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout());
		
		JButton rotate = new JButton(" Rotate ");
		rotate.setPreferredSize(new Dimension(100, 20));
		rotate.addActionListener(this);
		
		panel.add(rotate);
	
		finish = new JButton ("Finished");
		finish.setVisible(false);
		finish.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				pcPlayer.placeShip();
				new FrameGame(match, playField);
				setVisible(false);
			}
		});
		finish.setPreferredSize(new Dimension(100, 20));
		
		panel.add(finish);
		c.gridx = 2;
		c.gridy = 0;
		add(panel,c);
		
		
		FieldCell[][] indexField= playField.getIndexField();
		for (int i=0; i<10; i++) {
			for (int j=0;j<10;j++) {
				indexField[i][j].addMouseListener(this); 
			}
		}
		this.pack();
	}
	
	public void mouseClicked(MouseEvent e) {
		Position pos;
		Cell cell;
		FieldCell clicked;
		Field ourField;
		ourField = huPlayer.getField();
		FieldCell[][] indexField= playField.getIndexField();
		Ships ship= huPlayer.getCurrentShip();			// get the current ship that the user is placing
		if (e.getClickCount()==2) {
			clicked = (FieldCell) e.getComponent();
			cell= clicked.getCell();
			pos=cell.getPos();
			
			if(ship==null) {							// if the ship is null the are no ships left
				textArea.setText("Tutte le navi sono state posizionate");
				finish.setVisible(true);
				
			}else if (!huPlayer.tryPlaceShip(pos,i)) {
					textArea.setText("Hai fatto un errore nel posizionare la nave riprova");
			}
			else {
					    // The ship place went good and it will update every cell with the image of the ship placed
						int c=1;
						if (i%2==0) {
						for(int y=pos.getY(); y<pos.getY()+ship.getLength();y++) {  //Orizontal
							
							updateIcon(indexField[pos.getX()][y],ship.getName(),c);
							c++;
							}
						}
						else {
							for(int x=pos.getX(); x<pos.getX()+ship.getLength();x++) { //Vertical
								
								updateIcon(indexField[x][pos.getY()],ship.getName(),c);
								c++;
						}
						}
						textArea.setText("Nave posizionata correttamente");
					}
					
					
				}
			}
		
	
	/**
	 * Update the icon, it takes the ship name and get the url with that name, that direction and the number
	 * @param cell
	 * @param nameShip
	 * @param c
	 */
	private void updateIcon(FieldCell cell,String nameShip,int c) {
		String direction;
		if (this.i%2==0) {
			direction="";
		}
		else {
			direction="V";}
		String url="Navi/"+ direction+nameShip+"_"+c;
		cell.setUrl(url);
		ImageIcon imageIcon;
		url = url + ".jpg";
		imageIcon = new ImageIcon(url); // assign image to a new ImageIcon
		
		Image image = imageIcon.getImage(); // transform it 
		Image newimg =image.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
		ImageIcon newImageIcon = new ImageIcon(newimg); // assign to a new ImageIcon instance
			
		cell.setIcon(newImageIcon);
		
				
		
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
	
	public void actionPerformed(ActionEvent e) {	
		i++;
		if(i%2==1) {
		textArea.setText("Verticale");
		}else {
			textArea.setText("Orizzontale");
		}
	}

}
