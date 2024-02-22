package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.Match;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel nameTag;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	 /**
	  * Create the first Frame setting the layout,the button and image
	  */
	public Menu() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
		nameTag = new JLabel("BATTAGLIA NAVALE");
		nameTag.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nameTag.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nameTag, BorderLayout.NORTH);
		
		JButton btnStart = new JButton("INIZIA A GIOCARE");
		  try {
		    Image image = ImageIO.read(new File("Navi/Sfondo.jpg"));
			Image newimg =image.getScaledInstance(700, 600, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
			ImageIcon newImageIcon = new ImageIcon(newimg); // assign to a new ImageIcon instance
		    btnStart.setIcon(newImageIcon);
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btnStart.setBackground(Color.WHITE);
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 10));
		btnStart.setForeground(Color.BLACK);
		contentPane.add(btnStart, BorderLayout.CENTER);
		btnStart.addActionListener(this);
		btnStart.setPreferredSize(new Dimension(40, 40));

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		new FrameShipPositioner(new Match());

		setVisible(false);

	}

}
