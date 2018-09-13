package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Angelo
 */
public class StartMenu extends JFrame {
	private ImageIcon imageba;
	private ImageIcon imagebunew;
	private ImageIcon imagebuload;
	private JLabel background;

	public StartMenu(String name) {
		super(name);

		getContentPane().setLayout(null);

		JLabel gameName = new JLabel("CODE X");
		gameName.setLocation(450, 75);
		gameName.setSize(700, 150);
		gameName.setFont(new Font("Old English Text MT", 1, 150));
		gameName.setForeground(Color.WHITE);
		getContentPane().add(gameName);

		JLabel info = new JLabel("Author: Ruotong XU, Qichang Zhou");
		info.setLocation(10, 10);
		info.setSize(300, 50);
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Old English Text MT", 0, 20));
		getContentPane().add(info);

		this.imagebunew = new ImageIcon("buttonnew.png");
		this.imagebuload = new ImageIcon("buttonload.png");

		JButton newGame = new JButton("New Game");
		newGame.setLocation(520, 400);
		newGame.setSize(500, 100);
		newGame.setIcon(imagebunew);
		newGame.setContentAreaFilled(true);

		getContentPane().add(newGame);

		JButton load = new JButton("Load");
		load.setLocation(520, 600);
		load.setSize(500, 100);
		load.setIcon(imagebuload);
		getContentPane().add(load);

		this.imageba = new ImageIcon("background.png");
		this.background = new JLabel();
		
		this.background.setIcon(imageba);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		getContentPane().add(background);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1600, 900); 
		setResizable(false);

	}

	public static void main(String[] args) {
		JFrame frame = new StartMenu("My Fruit List");
		frame.setVisible(true);
	}

}
