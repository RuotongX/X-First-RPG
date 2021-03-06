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
/**
 * This is the control class which is a part of MVC.This class control the panel changes and event happen.
 * @author RuotongXu QichangZhou
 *
 */
public class MapDisplay extends JPanel {
	private ImageIcon okb;
	private ImageIcon imageback;
	JLabel background;
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
	JLabel elements[][][] = new JLabel[11][11][2];
	ImageIcon wall =new ImageIcon("wall.png");
	ImageIcon zoombie = new ImageIcon("zoombie.png");
	ImageIcon knight = new ImageIcon("knight.png");
	ImageIcon dragon = new ImageIcon("dragon.png");
	ImageIcon door = new ImageIcon("door.png");
	ImageIcon shop = new ImageIcon("shop.png");
	ImageIcon player = new ImageIcon("player.png");
	ImageIcon demon =new ImageIcon("Demonmap.png");
	ImageIcon backgroundp = new ImageIcon("background.png");
	
	
	
	public MapDisplay(Map m, int level) {
		this.setLayout(null);
		Mapg(m,level);
	}
	public void setM2(Map m) {
		m.display2();
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				elements[i][j][0].setVisible(false);
				String sign = m.getMap()[j][i][1];
				switch (sign) {
				case "*":
					
					elements[i][j][0].setIcon(wall);
					elements[i][j][0].setVisible(true);
					
					break;
				case "D":
				
					elements[i][j][0].setIcon(door);
					elements[i][j][0].setVisible(true);
					
					break;
				case "P":
					elements[i][j][0].setIcon(player);
					elements[i][j][0].setVisible(true);
					
					break;
				case " ":
					elements[i][j][0].setIcon(player);
					elements[i][j][0].setVisible(false);
					
					break;
				case "B":
					elements[i][j][0].setIcon(demon);
					elements[i][j][0].setVisible(true);
					
					break;
				}
			}
		}
	}

	public void setM1(Map m) {
		m.display();

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				elements[i][j][0].setVisible(false);
				
				String sign = m.getMap()[j][i][0];
				switch (sign) {
				case "*":
					
					elements[i][j][0].setIcon(wall);
					elements[i][j][0].setVisible(true);
					break;
				case "1":
					
					elements[i][j][0].setIcon(zoombie);
					elements[i][j][0].setVisible(true);
					break;
				case "2":
					
					elements[i][j][0].setIcon(knight);
					elements[i][j][0].setVisible(true);
					break;
				case "3":
					
					elements[i][j][0].setIcon(dragon);
					elements[i][j][0].setVisible(true);
					break;
				case "D":
					
					elements[i][j][0].setIcon(door);
					elements[i][j][0].setVisible(true);
					break;
				case "S":
					
					elements[i][j][0].setIcon(shop);
					elements[i][j][0].setVisible(true);
					break;
				case "P":
					elements[i][j][0].setVisible(true);
					break;
				case " ":
					elements[i][j][0].setVisible(false);
					break;
				}
			}
		}
	}
	
	private void Mapg(Map m, int level) {
		if (level == 1) {
			m.display();
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					
					elements[i][j][level-1] = new JLabel();
					elements[i][j][level-1].setLocation(354+i * 81, j * 81);
					elements[i][j][level-1].setSize(81, 81);
					String sign = m.getMap()[j][i][level-1];
					switch (sign) {
					case "*":
						
						elements[i][j][level-1].setIcon(wall);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case "1":
						
						elements[i][j][level-1].setIcon(zoombie);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case "2":
						
						elements[i][j][level-1].setIcon(knight);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case "3":
					
						elements[i][j][level-1].setIcon(dragon);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case "D":
					
						elements[i][j][level-1].setIcon(door);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case "S":
						
						elements[i][j][level-1].setIcon(shop);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					case " ":
						elements[i][j][level-1].setIcon(player);
						elements[i][j][level-1].setVisible(false);
						this.add(elements[i][j][level-1]);
						break;
					case "P":
						elements[i][j][level-1].setIcon(player);
						elements[i][j][level-1].setVisible(true);
						this.add(elements[i][j][level-1]);
						break;
					}
				}
				
			}
		}	if(level == 2) {
			m.display2();
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					elements[i][j][0] = new JLabel();
					elements[i][j][0].setLocation(354+i * 81, j * 81);
					elements[i][j][0].setSize(81, 81);
					String sign = m.getMap()[j][i][1];
					switch (sign) {
					case "*":
						
						elements[i][j][0].setIcon(wall);
						elements[i][j][0].setVisible(true);
						this.add(elements[i][j][0]);
						break;
					case "D":
					
						elements[i][j][0].setIcon(door);
						elements[i][j][0].setVisible(true);
						this.add(elements[i][j][0]);
						break;
					case "B":
						elements[i][j][0].setIcon(demon);
						elements[i][j][0].setVisible(true);
						this.add(elements[i][j][0]);
						break;
					case " ":
						elements[i][j][0].setIcon(player);
						elements[i][j][0].setVisible(false);
						this.add(elements[i][j][0]);
						break;
					case "P":
						elements[i][j][0].setIcon(player);
						elements[i][j][0].setVisible(true);
						this.add(elements[i][j][0]);
						break;
					}
				}
			}
		}
		
		
		this.playerName = new JLabel("Player: "+m.getP().getName());
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
		
		try {
		this.weapon = new JLabel("Weapon:"+m.getP().getWeapon().getName());
		} catch(Exception e){
			this.weapon = new JLabel("Weapon: null");
		}
		this.weapon.setVisible(true);
		this.weapon.setLocation(1245,320);
		this.weapon.setSize(400,50);
		this.weapon.setForeground(Color.WHITE);
		this.weapon.setFont(new Font("old English Text MT",0,35));
		this.add(this.weapon);
		
		try {
		this.shield = new JLabel("Shield:"+m.getP().getShield().getName());
		} catch(Exception e) {
			this.shield = new JLabel("Shield: null");
		}
		this.shield.setVisible(true);
		this.shield.setLocation(1245,370);
		this.shield.setSize(354,50);
		this.shield.setForeground(Color.WHITE);
		this.shield.setFont(new Font("old English Text MT",0,35));
		this.add(this.shield);
				
		this.checkAbility = new JButton("Check Ability");
		this.checkAbility.setOpaque(false);
	    this.checkAbility.setBackground(new Color(0,0,0,0));
		this.checkAbility.setVisible(true);
		this.checkAbility.setLocation(1245,650);
		this.checkAbility.setSize(354,50);
		this.checkAbility.setForeground(Color.WHITE);
		this.checkAbility.setFont(new Font("old English Text MT",0,35));
		this.add(this.checkAbility);
		
		this.checkEntity = new JButton("Check Entity");
		this.checkEntity.setOpaque(false);
		this.checkEntity.setBackground(new Color(0,0,0,0));
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
	
	public void setM1unvisable() {
		for(int i =0;i<11;i++) {
			for(int j =0;j<11;j++) {
				elements[i][j][0].setVisible(false);
			}
		}
	}
	public void setM1visable() {
		for(int i =0;i<11;i++) {
			for(int j =0;j<11;j++) {
				elements[i][j][0].setVisible(true);
			}
		}
	}
	public void setM2unvisable() {
		for(int i =0;i<11;i++) {
			for(int j =0;j<11;j++) {
				elements[i][j][1].setVisible(false);
			}
		}
	}
	public void setM2visable() {
		for(int i =0;i<11;i++) {
			for(int j =0;j<11;j++) {
				elements[i][j][1].setVisible(true);
			}
		}
	}
	public void update(Map m,int level) {
		
		if (level == 1) {
			m.display();

			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					elements[i][j][level-1].setVisible(false);
					
					String sign = m.getMap()[j][i][level-1];
					switch (sign) {
					case "*":
						
						elements[i][j][level-1].setIcon(wall);
						elements[i][j][level-1].setVisible(true);
						break;
					case "1":
						
						elements[i][j][level-1].setIcon(zoombie);
						elements[i][j][level-1].setVisible(true);
						break;
					case "2":
						
						elements[i][j][level-1].setIcon(knight);
						elements[i][j][level-1].setVisible(true);
						break;
					case "3":
						
						elements[i][j][level-1].setIcon(dragon);
						elements[i][j][level-1].setVisible(true);
						break;
					case "D":
						
						elements[i][j][level-1].setIcon(door);
						elements[i][j][level-1].setVisible(true);
						break;
					case "S":
						
						elements[i][j][level-1].setIcon(shop);
						elements[i][j][level-1].setVisible(true);
						break;
					case "P":
						elements[i][j][0].setIcon(player);
						elements[i][j][level-1].setVisible(true);
						break;
					case " ":
						elements[i][j][level-1].setVisible(false);
						break;
					}
				}
			}

		}
		if (level == 2) {
			m.display2();
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					elements[i][j][0].setVisible(false);
					
					String sign = m.getMap()[j][i][level-1];
					switch (sign) {
					case "*":
						
						elements[i][j][0].setIcon(wall);
						elements[i][j][0].setVisible(true);
						break;
					case "D":
					
						elements[i][j][0].setIcon(door);
						elements[i][j][0].setVisible(true);
						
						break;
					case "P":
						elements[i][j][0].setIcon(player);
						elements[i][j][0].setVisible(true);
						
						break;
					case " ":
						
						elements[i][j][0].setIcon(player);
						elements[i][j][0].setVisible(false);
						
						break;
					case "B":
						elements[i][j][0].setIcon(demon);
						elements[i][j][0].setVisible(true);
						
						break;
					}
				}
				
			}
			
		}
	
	}
}
