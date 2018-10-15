package gui;

import java.awt.Color;
import java.awt.Font;

import start.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class GuiRunner extends JFrame {
	public MapDisplay md;
	public BattleA ba;
	public BattleB bb ;
	public BattleC bc;
	public BattleD bd;
	public ShopGUI sg;
	FileControl fc = new FileControl();
	Map m = new Map();

	public void changeP(JPanel changeTo) {
		this.getContentPane().removeAll();
		this.getContentPane().add(changeTo);
		this.repaint();
	}

	private void positionCheck(Map m) {
		if (m.getP().getRow() == m.getM1().getRow() && m.getP().getColumn() == m.getM1().getColumn()
				&& m.getFloor() == 0) {
			ba = new BattleA(m,m.getM1());
			this.changeP(ba);
		} else if (m.getP().getRow() == m.getM2().getRow() && m.getP().getColumn() == m.getM2().getColumn()
				&& m.getFloor() == 0) {
			bb = new BattleB(m,m.getM2());
			this.getContentPane().removeAll();
			this.getContentPane().add(bb);
			this.repaint();
		} else if (m.getP().getRow() == m.getM3().getRow() && m.getP().getColumn() == m.getM3().getColumn()
				&& m.getFloor() == 0) {
			bc = new BattleC(m,m.getM3());
			this.getContentPane().removeAll();
			this.getContentPane().add(bc);
			this.repaint();
		} else if (m.getP().getRow() == m.getShop().getRow() && m.getP().getColumn() == m.getShop().getColumn()
				&& m.getFloor() == 0) {
			sg = new ShopGUI(m);
			this.changeP(sg);
		} else if (m.getP().getRow() == 9 && m.getP().getColumn() == 1) {
			BoyNextDoor bnd = new BoyNextDoor(m,md);
			if(m.getFloor() == 1) {
				changeP(md);
			} else {
				md.update(m,m.getFloor()+1);
				changeP(md);
			}
			
		} else if (m.getP().getRow() == m.getBoss().getRow() && m.getP().getColumn() == m.getBoss().getColumn()
				&& m.getFloor() == 1) {
			bd = new BattleD(m,m.getBoss());
			this.getContentPane().removeAll();
			this.getContentPane().add(bd);
			this.repaint();
		}
	}
	private void BattleControl(Map m,Monster mon) {
		Battle battle = new Battle(m,mon);
		if(mon.equals(m.getM1())) {
			ba.ability1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		} else if(mon.equals(m.getM2())) {
			
		} else if(mon.equals(m.getM3())) {
			
		} else if(mon.equals(m.getBoss())) {
			
		}
	}
	public void eventHandleNewGame(Map m) {
		NameEnter ne = new NameEnter();
		this.resize(1611,910);
		changeP(ne);
		ne.ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getP().setName(ne.nameinput.getText());
				History his  = new History();
				changeP(his);
				resize(1610, 920);
				his.skip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eventHandleSkip(m);
					}
				});
			}
		});
	}
	public void eventHandleLoadGame(Map m) {
		try {
			fc.loadfile(m.getP());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		History his  = new History();
		this.changeP(his);
		this.resize(1610, 920);
		his.skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleSkip(m);
			}
		});
	}
	public void eventHandleSkip(Map m) {
		this.md = new MapDisplay(m, 1);
		this.resize(1620, 935);
		this.changeP(md);
		md.requestFocus();
		this.md.getCheckAbility().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleCheckAbilityDisplay(m);
				md.requestFocus();
			}

		});

		this.md.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				eventHandleMove(m, e);
				md.update(m, m.getFloor()+1);
				changeP(md);
				positionCheck(m);
				md.requestFocus();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});

		this.md.setFocusable(true);

	}
	public void eventHandleMove(Map m, KeyEvent userInput) {

		if (keyVaildCheck(userInput)) {
			switch (Character.toUpperCase(userInput.getKeyChar())) {
			case 'W':

				m.moveup(m.getFloor());

				break;
			case 'S':

				m.movedown(m.getFloor());
				break;
			case 'A':

				m.moveleft(m.getFloor());
				break;
			case 'D':
				m.moveright(m.getFloor());
				break;
			}
		}

	}
	public void eventHandleCheckAbilityDisplay(Map m) {
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		switch (m.getP().ablist.getAbilitylist().length) {
		case 1:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			break;
		case 2:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			break;
		case 3:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			c = m.getP().ablist.getAbilitylist()[2].getName();
			break;
		case 4:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			c = m.getP().ablist.getAbilitylist()[2].getName();
			d = m.getP().ablist.getAbilitylist()[3].getName();
			break;
		}

		JOptionPane.showMessageDialog(null, a + "\n" + b + "\n" + c + "\n" + d, "Ability",
				JOptionPane.INFORMATION_MESSAGE);

	}
	private boolean keyVaildCheck(KeyEvent userInput) {
		return userInput.getKeyChar() == 'a' || userInput.getKeyChar() == 's' || userInput.getKeyChar() == 'w'
				|| userInput.getKeyChar() == 'd' || userInput.getKeyChar() == 'A' || userInput.getKeyChar() == 'S'
				|| userInput.getKeyChar() == 'W' || userInput.getKeyChar() == 'D';
	}

	public GuiRunner() {
		StartMenu sm = new StartMenu();
		sm.load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleLoadGame(m);
				
			}
		});
		sm.newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleNewGame(m);
				
			}
		});
		
		this.getContentPane().add(sm);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		setSize(1610, 935);

	}
}
