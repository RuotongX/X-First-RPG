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

public class BattleB extends JPanel{
	private ImageIcon battle2;
	JLabel background;
	JButton ability1;
	JButton ability2;
	JButton ability3;
	JButton ability4;
	JButton playerBag;
	JButton palyerRun;
	JLabel playerState;
	JButton checkAbility;
	JLabel monsterState;
	
	public BattleB(Map m,Monster mon) {
		this.setLayout(null);
		this.ability1 = new JButton(m.getP().ablist.getAbilitylist()[0].getName()+" pp: "+m.getP().ablist.getAbilitylist()[0].getPp());
		this.ability1.setOpaque(false);
		this.ability1.setBackground(new Color(0, 0, 0, 0));
		this.ability1.setVisible(true);
		this.ability1.setLocation(20, 60);
		this.ability1.setSize(350, 80);
		this.ability1.setForeground(Color.WHITE);
		this.ability1.setFont(new Font("old English Text MT", 0, 35));
		this.add(this.ability1);

		try {

			this.ability2 = new JButton(m.getP().ablist.getAbilitylist()[1].getName()+" pp: "+m.getP().ablist.getAbilitylist()[1].getPp());
			this.ability2.setOpaque(false);
			this.ability2.setBackground(new Color(0, 0, 0, 0));
			this.ability2.setVisible(true);
			this.ability2.setLocation(20,180);
			this.ability2.setSize(350, 80);
			this.ability2.setForeground(Color.WHITE);
			this.ability2.setFont(new Font("old English Text MT", 0, 35));
			this.add(this.ability2);
		} catch (Exception e) {

		}
		try {
			this.ability3 = new JButton(m.getP().ablist.getAbilitylist()[2].getName()+" pp: "+m.getP().ablist.getAbilitylist()[2].getPp());
			this.ability3.setOpaque(false);
			this.ability3.setBackground(new Color(0, 0, 0, 0));
			this.ability3.setVisible(true);
			this.ability3.setLocation(20,300);
			this.ability3.setSize(350, 80);
			this.ability3.setForeground(Color.WHITE);
			this.ability3.setFont(new Font("old English Text MT", 0, 35));
			this.add(this.ability3);
		} catch (Exception e) {

		}

		try {
			this.ability4 = new JButton(m.getP().ablist.getAbilitylist()[3].getName()+" pp: "+m.getP().ablist.getAbilitylist()[3].getPp());
			this.ability4.setOpaque(false);
			this.ability4.setBackground(new Color(0, 0, 0, 0));
			this.ability4.setVisible(true);
			this.ability4.setLocation(20,420);
			this.ability4.setSize(350, 80);
			this.ability4.setForeground(Color.WHITE);
			this.ability4.setFont(new Font("old English Text MT", 0, 35));
			this.add(this.ability4);
		} catch (Exception e) {

		}
		this.playerBag = new JButton("Bag");
		this.playerBag.setOpaque(false);
		this.playerBag.setBackground(new Color(0, 0, 0, 0));
		this.playerBag.setVisible(true);
		this.playerBag.setLocation(20,540);
		this.playerBag.setSize(280, 80);
		this.playerBag.setForeground(Color.WHITE);
		this.playerBag.setFont(new Font("old English Text MT",0,35));
		this.add(this.playerBag);
		
		this.checkAbility = new JButton("Check Ability");
		this.checkAbility.setOpaque(false);
		this.checkAbility.setBackground(new Color(0, 0, 0, 0));
		this.checkAbility.setVisible(true);
		this.checkAbility.setLocation(20,660);
		this.checkAbility.setSize(280, 80);
		this.checkAbility.setForeground(Color.WHITE);
		this.checkAbility.setFont(new Font("old English Text MT",0,35));
		this.add(this.checkAbility);
		
		this.palyerRun = new JButton("Run Away");
		this.palyerRun.setOpaque(false);
		this.palyerRun.setBackground(new Color(0, 0, 0, 0));
		this.palyerRun.setVisible(true);
		this.palyerRun.setLocation(20,790);
		this.palyerRun.setSize(280, 80);
		this.palyerRun.setForeground(Color.WHITE);
		this.palyerRun.setFont(new Font("old English Text MT",0,35));
		this.add(this.palyerRun);
		
		this.playerState = new JLabel(m.getP().getName()+" LV:"+m.getP().getLevel()+" HP:"+m.getP().getHealth());
		this.playerState.setOpaque(false);
		this.playerState.setBackground(new Color(0, 0, 0, 0));
		this.playerState.setVisible(true);
		this.playerState.setLocation(660,820);
		this.playerState.setSize(400, 80);
		this.playerState.setForeground(Color.WHITE);
		this.playerState.setFont(new Font("Times New Roman",0,40));
		this.add(this.playerState);
		
		this.monsterState = new JLabel(m.getM2().getName()+" LV:"+m.getM2().getLevel()+" HP:"+m.getM2().getHealth());
		this.monsterState.setOpaque(false);
		this.monsterState.setBackground(new Color(0, 0, 0, 0));
		this.monsterState.setVisible(true);
		this.monsterState.setLocation(600,0);
		this.monsterState.setSize(400, 80);
		this.monsterState.setForeground(Color.WHITE);
		this.monsterState.setFont(new Font("Times New Roman",0,40));
		this.add(this.monsterState);
		
		this.battle2 = new ImageIcon("battle2.png");
		this.background = new JLabel();
		this.background.setIcon(battle2);
		this.background.setVisible(true);
		this.background.setLocation(0, 0);
		this.background.setSize(1600, 900);
		this.add(background);
		
	}
	public void update(Map m) {
		this.playerState.setVisible(false);
		this.playerState.setText(m.getP().getName()+" LV:"+m.getP().getLevel()+" HP:"+m.getP().getHealth());
		this.playerState.setVisible(true);
		this.monsterState.setVisible(false);
		this.monsterState.setText(m.getM2().getName()+" LV:"+m.getM2().getLevel()+" HP:"+m.getM2().getHealth());
		this.monsterState.setVisible(true);
		this.ability1.setVisible(false);
		this.ability1.setText(m.getP().ablist.getAbilitylist()[0].getName()+" pp: "+m.getP().ablist.getAbilitylist()[0].getPp());
		this.ability1.setVisible(true);
		try {
		this.ability2.setVisible(false);
		this.ability2.setText(m.getP().ablist.getAbilitylist()[1].getName()+" pp: "+m.getP().ablist.getAbilitylist()[1].getPp());
		this.ability2.setVisible(true);
		} catch (Exception e) {
			
		}
		try {
			this.ability3.setVisible(false);
			this.ability3.setText(m.getP().ablist.getAbilitylist()[2].getName()+" pp: "+m.getP().ablist.getAbilitylist()[2].getPp());
			this.ability3.setVisible(true);
			} catch (Exception e) {
				
			}
		try {
			this.ability4.setVisible(false);
			this.ability4.setText(m.getP().ablist.getAbilitylist()[3].getName()+" pp: "+m.getP().ablist.getAbilitylist()[3].getPp());
			this.ability4.setVisible(true);
			} catch (Exception e) {
				
			}
	}


}
