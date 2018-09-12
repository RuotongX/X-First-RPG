package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class History extends JFrame{
	private JLabel line0;
	private JLabel line1;
	private JLabel line2;
	private JLabel line3;
	private JLabel line4;
	private JLabel line5;
	private JLabel line6;
	private ImageIcon imageba;
	private JLabel background;
	
	public History(String name) {
		super(name);
		getContentPane().setLayout(null);
		
		line0 = new JLabel("It's an old story...");
		line0.setLocation(10,70);
		line0.setSize(1600,60);
		line0.setFont(new Font("Old English Text MT", 1, 50));
		line0.setForeground(Color.WHITE);
		getContentPane().add(line0);
		
		line1 = new JLabel("Once upon a time, on the middle-earth, there was a small kingdom.");
		line1.setLocation(10,180);
		line1.setSize(1600,60);
		line1.setFont(new Font("Old English Text MT", 1, 50));
		line1.setForeground(Color.WHITE);
		getContentPane().add(line1);
		
		line2 = new JLabel("One day, monsters took over the kingdom ");
		line2.setLocation(10,290);
		line2.setSize(1600,60);
		line2.setFont(new Font("Old English Text MT", 1, 50));
		line2.setForeground(Color.WHITE);
		getContentPane().add(line2);
		
		line6 = new JLabel(", therefore the king summoned the warriors and said");
		line6.setLocation(10,400);
		line6.setSize(1600,60);
		line6.setFont(new Font("Old English Text MT", 1, 50));
		line6.setForeground(Color.WHITE);
		getContentPane().add(line6);
		
		line3 = new JLabel("No matter who drove the monsters away, he will marry the princess. ");
		line3.setLocation(10,510);
		line3.setSize(1600,60);
		line3.setFont(new Font("Old English Text MT", 1, 50));
		line3.setForeground(Color.WHITE);
		getContentPane().add(line3);
		
		line4 = new JLabel("So, all the warriors set out, but no one came back alive...");
		line4.setLocation(10,620);
		line4.setSize(1600,60);
		line4.setFont(new Font("Old English Text MT", 1, 50));
		line4.setForeground(Color.WHITE);
		getContentPane().add(line4);
		
		line5 = new JLabel("And this is where our story begins...");
		line5.setLocation(10,730);
		line5.setSize(1600,60);
		line5.setFont(new Font("Old English Text MT", 1, 50));
		line5.setForeground(Color.WHITE);
		getContentPane().add(line5);
		
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
		JFrame frame = new History("My Fruit List");
		frame.setVisible(true);
	}

}
