package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import start.*;

public class MapDisplay extends JPanel {
	private ImageIcon okb;
	private ImageIcon imageback;
	private ImageIcon backgroundp;
	private JLabel background;
	private ImageIcon titleI;
	JLabel playerName;
	JLabel playerAttack;
	JLabel defence;
	JLabel health;
	JLabel playerLevel;
	JLabel money;
	JLabel weapon;
	JLabel shield;
	JButton checkAbility;
	JButton checkEntity;
	JLabel guide;
	JLabel info1;
	JLabel info2;
	JLabel info3;
	JLabel info4;
	JLabel info5;
	
	public MapDisplay(Map m, int level) {
		this.setLayout(null);
		Mapg(m,level);
				
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(1600, 900); 
//		setResizable(false);
	}
	private void Mapg(Map m, int level) {
		if (level == 1) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					JLabel picture = new JLabel();
					ImageIcon icon;
					picture.setLocation(354+i * 81, j * 81);
					picture.setSize(81, 81);
					m.display();
					String sign = m.getMap()[j][i][0];
					switch (sign) {
					case "*":
						icon = new ImageIcon("wall.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "1":
						icon = new ImageIcon("zoombie.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "2":
						icon = new ImageIcon("knight.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "3":
						icon = new ImageIcon("dragon.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "D":
						icon = new ImageIcon("door.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "S":
						icon = new ImageIcon("shop.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					case "P":
						icon = new ImageIcon("player.png");
						picture.setIcon(icon);
						picture.setVisible(true);
						this.add(picture);
						break;
					}
				}
			}
		}
		
		this.playerName = new JLabel("Player Name: "+m.getP().getName());
		this.playerName.setVisible(true);
		this.playerName.setLocation(1245,20);
		this.playerName.setSize(354,50);
		this.playerName.setForeground(Color.WHITE);
		this.playerName.setFont(new Font("old English Text MT",0,35));
		this.add(this.playerName);
		
		this.playerAttack = new JLabel("Attack: "+m.getP().getAttack());
		this.playerAttack.setVisible(true);
		this.playerAttack.setLocation(1245,70);
		this.playerAttack.setSize(354,50);
		this.playerAttack.setForeground(Color.WHITE);
		this.playerAttack.setFont(new Font("old English Text MT",0,35));
		this.add(this.playerAttack);
		
		this.defence = new JLabel("Defence: "+m.getP().getdefense());
		this.defence.setVisible(true);
		this.defence.setLocation(1245,120);
		this.defence.setSize(354,50);
		this.defence.setForeground(Color.WHITE);
		this.defence.setFont(new Font("old English Text MT",0,35));
		this.add(this.defence);
		
		this.health = new JLabel("Health: "+m.getP().getHealth());
		this.health.setVisible(true);
		this.health.setLocation(1245,170);
		this.health.setSize(354,50);
		this.health.setForeground(Color.WHITE);
		this.health.setFont(new Font("old English Text MT",0,35));
		this.add(this.health);
		
		this.playerLevel = new JLabel("Level: "+m.getP().getLevel());
		this.playerLevel.setVisible(true);
		this.playerLevel.setLocation(1245,220);
		this.playerLevel.setSize(354,50);
		this.playerLevel.setForeground(Color.WHITE);
		this.playerLevel.setFont(new Font("old English Text MT",0,35));
		this.add(this.playerLevel);
		
		this.money = new JLabel("Money: "+m.getP().getMoney());
		this.money.setVisible(true);
		this.money.setLocation(1245,270);
		this.money.setSize(354,50);
		this.money.setForeground(Color.WHITE);
		this.money.setFont(new Font("old English Text MT",0,35));
		this.add(	this.money);
		
		this.weapon = new JLabel("Weapon: "+m.getP().getWeapon());
		this.weapon.setVisible(true);
		this.weapon.setLocation(1245,320);
		this.weapon.setSize(354,50);
		this.weapon.setForeground(Color.WHITE);
		this.weapon.setFont(new Font("old English Text MT",0,35));
		this.add(this.weapon);
		
		this.shield = new JLabel("Shield: "+m.getP().getShield());
		this.shield.setVisible(true);
		this.shield.setLocation(1245,370);
		this.shield.setSize(354,50);
		this.shield.setForeground(Color.WHITE);
		this.shield.setFont(new Font("old English Text MT",0,35));
		this.add(this.shield);
				
		this.checkAbility = new JButton("Check Ability");
		this.checkAbility.setVisible(true);
		this.checkAbility.setLocation(1245,650);
		this.checkAbility.setSize(354,50);
		this.checkAbility.setForeground(Color.WHITE);
		this.checkAbility.setFont(new Font("old English Text MT",0,35));
		this.add(this.checkAbility);
		
		this.checkEntity = new JButton("Check Entity");
		this.checkEntity.setVisible(true);
		this.checkEntity.setLocation(1245,750);
		this.checkEntity.setSize(354,50);
		this.checkEntity.setForeground(Color.WHITE);
		this.checkEntity.setFont(new Font("old English Text MT",0,35));
		this.add(this.checkEntity);
		
		this.guide = new JLabel("Guide:");
		this.guide.setVisible(true);
		this.guide.setLocation(1,500);
		this.guide.setSize(354,100);
		this.guide.setForeground(Color.WHITE);
		this.guide.setFont(new Font("Times New Roman",0,35));
		this.add(this.guide);
		
		this.info1 = new JLabel("Use WASD control character to move.");
		this.info1.setVisible(true);
		this.info1.setLocation(1,550);
		this.info1.setSize(354,100);
		this.info1.setForeground(Color.WHITE);
		this.info1.setFont(new Font("Times New Roman",0,20));
		this.add(this.info1);
		
		this.info2 = new JLabel("Click 'Check Entity' can see all the entity");
		this.info2.setVisible(true);
		this.info2.setLocation(1,600);
		this.info2.setSize(354,100);
		this.info2.setForeground(Color.WHITE);
		this.info2.setFont(new Font("Times New Roman",0,20));
		this.add(this.info2);
		
		this.info3 = new JLabel("you got.");
		this.info3.setVisible(true);
		this.info3.setLocation(1,650);
		this.info3.setSize(354,100);
		this.info3.setForeground(Color.WHITE);
		this.info3.setFont(new Font("Times New Roman",0,20));
		this.add(this.info3);
		
		this.info4 = new JLabel("Click 'Check ability' can see all the skill");
		this.info4.setVisible(true);
		this.info4.setLocation(1,700);
		this.info4.setSize(354,100);
		this.info4.setForeground(Color.WHITE);
		this.info4.setFont(new Font("Times New Roman",0,20));
		this.add(this.info4);
		
		this.info5 = new JLabel("you learned");
		this.info5.setVisible(true);
		this.info5.setLocation(1,750);
		this.info5.setSize(354,100);
		this.info5.setForeground(Color.WHITE);
		this.info5.setFont(new Font("Times New Roman",0,20));
		this.add(this.info5);
		
		this.titleI = new ImageIcon("title.png");
		JLabel title = new JLabel();
	    title.setIcon(titleI);
		title.setVisible(true);
		title.setLocation(0, 0);
		title.setSize(355, 500);
		this.add(title);
		
		this.backgroundp = new ImageIcon("background.png");
		this.background = new JLabel();
		this.background.setIcon(backgroundp);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		this.add(background);
		
		
	}
	public JButton getCheckAbility() {
		return checkAbility;
	}
	public void update(Map m,int l) {
		Mapg(m,l);
		
	}
}
