package gui;
import start.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class Bag extends JPanel{
	JButton confirm;
	JButton exit;
	JLabel background;
	JList<Entity> entitylist;
	JScrollPane elist;
	ImageIcon backgroundI = new ImageIcon("Bag");
	public Bag(Map m) {
		this.confirm = new JButton();
		this.confirm.setOpaque(false);
		this.confirm.setBackground(new Color(0, 0, 0, 0));
		this.confirm.setVisible(true);
		this.confirm.setLocation(1525,825);
		this.confirm.setSize(75,75);
		this.add(confirm);
		
		this.exit = new JButton();
		this.exit.setOpaque(false);
		this.exit.setBackground(new Color(0, 0, 0, 0));
		this.exit.setVisible(true);
		this.exit.setLocation(1525,710);
		this.exit.setSize(75,75);
		this.add(exit);
		
		this.background = new JLabel();
		this.background.setIcon(backgroundI);
		this.background.setLocation(0,0);
		this.background.setSize(1600, 900);
		this.add(background);
	}
}
