package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the control class which is a part of MVC.This class control the panel changes and event happen.
 * @author RuotongXu QichangZhou
 *
 */
public class StartMenu extends JPanel {
	private ImageIcon imageba;
	private ImageIcon imagebunew;
	private ImageIcon imagebuload;
	private JLabel background;
	public JButton load;
	public JButton newGame;

	public StartMenu() {

		this.setLayout(null);

		JLabel gameName = new JLabel("Warrior Challenge");
		gameName.setLocation(285, 75);
		gameName.setSize(1200, 150);
		gameName.setFont(new Font("Old English Text MT", 1, 120));
		gameName.setForeground(Color.WHITE);
		this.add(gameName);

		JLabel info = new JLabel("Author: Ruotong XU, Qichang Zhou");
		info.setLocation(10, 10);
		info.setSize(300, 50);
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Old English Text MT", 0, 20));
		this.add(info);

		this.imagebunew = new ImageIcon("buttonnew.png");
		this.imagebuload = new ImageIcon("buttonload.png");

		newGame = new JButton("New Game");
		newGame.setLocation(520, 400);
		newGame.setSize(500, 100);
		newGame.setIcon(imagebunew);
		newGame.setContentAreaFilled(true);

		this.add(newGame);

		this.load = new JButton("Load");
		load.setLocation(520, 600);
		load.setSize(500, 100);
		load.setIcon(imagebuload);
		this.add(load);

		this.imageba = new ImageIcon("background.png");
		this.background = new JLabel();
		
		this.background.setIcon(imageba);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		this.add(background);

	}
}
