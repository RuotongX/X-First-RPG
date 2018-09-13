package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import start.*;

public class MapDisplay extends JFrame {
	private ImageIcon backgroundp;
	private JLabel background;

	public MapDisplay(Map m, int level) {
		getContentPane().setLayout(null);
		if (level == 1) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					JLabel picture = new JLabel();
					ImageIcon icon;
					picture.setLocation(354+i * 81, j * 81);
					picture.setSize(81, 81);
					String sign = m.getMap()[j][i][0];
					switch (sign) {
					case "*":
						icon = new ImageIcon("wall.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "1":
						icon = new ImageIcon("zoombie.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "2":
						icon = new ImageIcon("knight.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "3":
						icon = new ImageIcon("dragon.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "D":
						icon = new ImageIcon("door.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "S":
						icon = new ImageIcon("shop.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					case "P":
						icon = new ImageIcon("player.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						getContentPane().add(picture);
						break;
					}
				}
			}
		}
		this.backgroundp = new ImageIcon("background.png");
		this.background = new JLabel();
		this.background.setIcon(backgroundp);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		getContentPane().add(background);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1600, 900); 
		setResizable(false);
	}
}
