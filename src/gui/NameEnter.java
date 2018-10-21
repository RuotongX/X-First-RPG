package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author RuotongXu QichangZhou
 *
 */
public class NameEnter extends JPanel {
	private ImageIcon okb;
	private ImageIcon imageback;
	private JLabel background;
	private JLabel name;
	public JButton ok;
	public JTextField nameinput;
	
	public NameEnter() {
		this.setLayout(null);
		
		okb = new ImageIcon("ConfirmB.png");
		imageback = new ImageIcon("background.png");
		
		this.ok = new JButton();
		this.ok.setIcon(okb);
		this.ok.setVisible(true);
		this.ok.setLocation(1040, 500);
		this.ok.setSize(60,60);
		this.add(ok);
		
		this.name = new JLabel("Hey, Warrior,");
		this.name.setLocation(550, 75);
		this.name.setSize(600, 150);
		this.name.setFont(new Font("Old English Text MT", 1, 80));
		this.name.setForeground(Color.WHITE);
		this.add(this.name);
		
		JLabel name2 = new JLabel(" tell me your name :");
		name2.setLocation(450, 250);
		name2.setSize(800, 150);
		name2.setFont(new Font("Old English Text MT", 1, 80));
		name2.setForeground(Color.WHITE);
		this.add(name2);
		
		this.nameinput = new JTextField("Player");
		this.nameinput.setLocation(520, 500);
		this.nameinput.setSize(500,60);
		this.nameinput.setFont(new Font("Old English Text MT",0,30));
		this.add(nameinput);
		
		this.background = new JLabel();
		this.background.setIcon(imageback);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		this.add(background);
		
	}
	

}
