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
/**
 * This is a class for bag view, which is a panel.
 * @author RuotongXu
 */
public class Bag extends JPanel{
	JButton confirm;
	JButton exit;
	JLabel background;
	JList<Entity> entitylist;
	JScrollPane elist;
	EntityList model1;
	ImageIcon backgroundI = new ImageIcon("Bag.png");
	public Bag(Map m) {
		this.model1 = m.getP().enlist;
		
		setLayout(null);
		
		this.entitylist = new JList<Entity>(this.model1.getentityList());
		entitylist.setOpaque(false);
		entitylist.setBackground(new Color(0, 0, 0, 0));
		entitylist.setForeground(Color.WHITE);
		entitylist.setFont(new Font("Arial",0, 15));
		
		this.entitylist.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane1 = new JScrollPane(entitylist);
		scrollPane1.setViewport(new JViewport());
		
		scrollPane1.getViewport().setView(entitylist);
		
		scrollPane1.setOpaque(false);
		scrollPane1.getViewport().setOpaque(false);
		
		scrollPane1.setLocation(415, 25);  
		scrollPane1.setSize(945, 850);
		this.add(scrollPane1);
		
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
		this.setVisible(true);
		this.add(background);
	}
}
