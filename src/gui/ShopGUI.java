package gui;

import java.awt.Color;
import start.*;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class ShopGUI extends JPanel {
	JButton confirm;
	JButton exit;
	JButton Healup;
	JTextField search;
	JScrollPane elist;
	JScrollPane alist;
	JLabel background;
	JList<Entity> shopelist;
	JList<Ability> shopalist;
	EntityList model1;
	AbilityList model2;
	ImageIcon confirmI = new ImageIcon("shopconfirm.png");
	ImageIcon exitI = new ImageIcon("shopexit.png");
	ImageIcon searchI = new ImageIcon("shopsearchbar.png");
	ImageIcon list1I = new ImageIcon("shoplist1.png");
	ImageIcon list2I = new ImageIcon("shoplist2.png");
	ImageIcon backgroundI = new ImageIcon("shopbackground.png");
	ImageIcon priceI = new ImageIcon("shoppricedisplay.png");
	
	
	public ShopGUI(Map m) {
		this.model1 = m.getShop().getEnlist();
		this.model2 = m.getShop().getAblist();
		
		setLayout(null);
		
		this.shopelist = new JList<Entity>(this.model1.getentityList());
		shopelist.setOpaque(false);
		shopelist.setBackground(new Color(0, 0, 0, 0));
		shopelist.setForeground(Color.WHITE);
		shopelist.setFont(new Font("Arial",0, 15));
		
		
		this.shopelist.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane1 = new JScrollPane(shopelist);
		scrollPane1.setViewport(new JViewport());
		
		scrollPane1.getViewport().setView(shopelist);
		
		scrollPane1.setOpaque(false);
		scrollPane1.getViewport().setOpaque(false);
		
		scrollPane1.setLocation(0, 0);  
		scrollPane1.setSize(800, 500);
		this.add(scrollPane1);
		
		
		
		this.shopalist = new JList<Ability>(this.model2.getAbilitylist());
		shopalist.setOpaque(false);
		shopalist.setBackground(new Color(0, 0, 0, 0));
		shopalist.setForeground(Color.WHITE);
		shopalist.setFont(new Font("Arial",0, 15));
		

		this.shopalist.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane2 = new JScrollPane(shopalist);
		scrollPane2.setViewport(new JViewport());
		scrollPane2.getViewport().setView(shopalist);
		scrollPane2.setOpaque(false);
		scrollPane2.getViewport().setOpaque(false);
		scrollPane2.setLocation(0, 500);
		scrollPane2.setSize(800, 300);
		this.add(scrollPane2);
		
		
		
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
		
		this.search = new JTextField();
		this.search.setOpaque(false);
		this.search.setBackground(new Color(0, 0, 0, 0));
		this.search.setVisible(true);
		this.search.setLocation(800,800);
		this.search.setSize(565,100);
		this.search.setForeground(Color.WHITE);
		this.search.setFont(new Font("Arial",1,40));
		this.add(search);
		
		this.Healup = new JButton("Heal Up for 6$");
		this.Healup.setOpaque(false);
		this.Healup.setBackground(new Color(0, 0, 0, 0));
		this.Healup.setLocation(0, 800);
		this.Healup.setSize(800,100);
		this.Healup.setForeground(Color.WHITE);
		this.Healup.setFont(new Font("old English Text MT",1,40));
		this.Healup.setVisible(true);
		this.add(Healup);
		
				
		this.background = new JLabel();
		this.background.setIcon(backgroundI);
		this.background.setLocation(0,0);
		this.background.setSize(1600, 900);
		this.add(background);
	}

}
