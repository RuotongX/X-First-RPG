package gui;

import java.awt.Color;
import java.awt.Font;
import Ability.*;
import start.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Ability.AbilityLimiter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class GuiRunner extends JFrame {
	public MapDisplay md;
	public BattleA ba;
	public BattleB bb;
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
			ba = new BattleA(m, m.getM1());
			this.changeP(ba);
			BattleControl(m, m.getM1());
		} else if (m.getP().getRow() == m.getM2().getRow() && m.getP().getColumn() == m.getM2().getColumn()
				&& m.getFloor() == 0) {
			bb = new BattleB(m, m.getM2());
			this.getContentPane().removeAll();
			this.getContentPane().add(bb);
			this.repaint();
			BattleControl(m, m.getM2());
		} else if (m.getP().getRow() == m.getM3().getRow() && m.getP().getColumn() == m.getM3().getColumn()
				&& m.getFloor() == 0) {
			bc = new BattleC(m, m.getM3());
			this.getContentPane().removeAll();
			this.getContentPane().add(bc);
			this.repaint();
			BattleControl(m, m.getM3());
		} else if (m.getP().getRow() == m.getShop().getRow() && m.getP().getColumn() == m.getShop().getColumn()
				&& m.getFloor() == 0) {
			sg = new ShopGUI(m);
			this.changeP(sg);
		} else if (m.getP().getRow() == 9 && m.getP().getColumn() == 1) {
			BoyNextDoor bnd = new BoyNextDoor(m, md);
			if (m.getFloor() == 1) {
				changeP(md);
			} else {
				md.update(m, m.getFloor() + 1);
				changeP(md);
			}

		} else if (m.getP().getRow() == m.getBoss().getRow() && m.getP().getColumn() == m.getBoss().getColumn()
				&& m.getFloor() == 1) {
			bd = new BattleD(m, m.getBoss());
			this.getContentPane().removeAll();
			this.getContentPane().add(bd);
			this.repaint();
			BattleControl(m, m.getBoss());
		}
	}

	private void BattleControl(Map m, Monster mon) {
		Battle battle = new Battle(m, mon);
		if (mon.equals(m.getM1())) {
			ba.ability1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					battle.skilldepender(ba.ability1.getText(), m, mon);
					ba.update(m);
					changeP(ba);
					situation(m, mon);
				}
			});
			try {
				ba.ability2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(ba.ability2.getText(), m, mon);
						ba.update(m);
						changeP(ba);
					}
				});
			} catch (Exception e) {

			}
			try {
				ba.ability3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(ba.ability3.getText(), m, mon);
						ba.update(m);
						changeP(ba);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				ba.ability4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(ba.ability4.getText(), m, mon);
						ba.update(m);
						changeP(ba);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			ba.palyerRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getP().setColumn(m.getP().getColumn()+1);
					resize(1618,956);
					eventHandleSkip(m);
				}
			});
			ba.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});

		} else if (mon.equals(m.getM2())) {
			bb.ability1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					battle.skilldepender(bb.ability1.getText(), m, mon);
					bb.update(m);
					changeP(bb);
					situation(m, mon);
				}
			});
			try {
				bb.ability2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bb.ability2.getText(), m, mon);
						bb.update(m);
						changeP(bb);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bb.ability3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bb.ability3.getText(), m, mon);
						bb.update(m);
						changeP(bb);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bb.ability4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bb.ability4.getText(), m, mon);
						bb.update(m);
						changeP(bb);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			bb.palyerRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getP().setColumn(m.getP().getColumn()+1);
					resize(1618,955);
					eventHandleSkip(m);
				}
			});
			bb.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
		} else if (mon.equals(m.getM3())) {

			bc.ability1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					battle.skilldepender(bc.ability1.getText(), m, mon);
					bc.update(m);
					changeP(bc);
					situation(m, mon);
				}
			});
			try {
				bc.ability2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bc.ability2.getText(), m, mon);
						bc.update(m);
						changeP(bc);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bc.ability3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bc.ability3.getText(), m, mon);
						bc.update(m);
						changeP(bc);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bc.ability4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bc.ability4.getText(), m, mon);
						bc.update(m);
						changeP(bc);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			bc.palyerRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getP().setColumn(m.getP().getColumn()+1);
					resize(1618,953);
					eventHandleSkip(m);
				}
			});
			bc.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
		} else if (mon.equals(m.getBoss())) {
			bd.ability1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					battle.skilldepender(bd.ability1.getText(), m, mon);
					bd.update(m);
					changeP(bd);
					situation(m, mon);
				}
			});
			try {
				bd.ability2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bd.ability2.getText(), m, mon);
						bd.update(m);
						changeP(bd);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bd.ability3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bd.ability3.getText(), m, mon);
						bd.update(m);
						changeP(bd);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			try {
				bd.ability4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						battle.skilldepender(bd.ability4.getText(), m, mon);
						bd.update(m);
						changeP(bd);
						situation(m, mon);
					}
				});
			} catch (Exception e) {

			}
			bd.palyerRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getP().setColumn(m.getP().getColumn()+1);
					resize(1618,949);
					eventHandleSkip(m);
				}
			});
			bd.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
		}
	}

	public void eventHandleNewGame(Map m) {
		NameEnter ne = new NameEnter();
		this.resize(1611, 910);
		changeP(ne);
		ne.ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getP().setName(ne.nameinput.getText());
				History his = new History();
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
		History his = new History();
		this.changeP(his);
		this.resize(1610, 920);
		his.skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleSkip(m);
			}
		});
	}

	public void eventHandleSkip(Map m) {
		this.md = new MapDisplay(m, m.getFloor()+1);
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
				md.update(m, m.getFloor() + 1);
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
			a = m.getP().ablist.getAbilitylist()[0].toString();
			break;
		case 2:
			a = m.getP().ablist.getAbilitylist()[0].toString();
			b = m.getP().ablist.getAbilitylist()[1].toString();
			break;
		case 3:
			a = m.getP().ablist.getAbilitylist()[0].toString();
			b = m.getP().ablist.getAbilitylist()[1].toString();
			c = m.getP().ablist.getAbilitylist()[2].toString();
			break;
		case 4:
			a = m.getP().ablist.getAbilitylist()[0].toString();
			b = m.getP().ablist.getAbilitylist()[1].toString();
			c = m.getP().ablist.getAbilitylist()[2].toString();
			d = m.getP().ablist.getAbilitylist()[3].toString();
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

	public void situation(Map m, Monster monster) {
		if (m.getP().getHealth() <= 0) {
			m.getP().setRow(9);
			m.getP().setColumn(8);
			m.getP().setMoney(m.getP().getMoney() / 2);
			m.getP().setHealth(m.getP().getHealthmax());
			for (int i = 0; i < m.getP().ablist.getTotalnumber(); i++) {
				m.getP().ablist.getAbilitylist()[i].setPp(m.getP().ablist.getAbilitylist()[i].getMaxpp());
			}
			JOptionPane.showMessageDialog(null, "You have been defeated!!", "", JOptionPane.INFORMATION_MESSAGE);
			
			this.resize(1621,954);
			this.eventHandleSkip(m);
			;
		}
		if (monster.getHealth() <= 0) {
			JOptionPane.showMessageDialog(null,
					"Congrations! You have slain the monster! You have earned: " + monster.getMoney() + "$!", "",
					JOptionPane.INFORMATION_MESSAGE);

			if (monster.getHealthmax() == 25) {
				m.getP().setM1defeat(true);
			} else if (monster.getHealthmax() == 50) {
				m.getP().setM2defeat(true);
			} else if (monster.getHealthmax() == 90) {
				m.getP().setM3defeat(true);
			} else if (monster.getHealthmax() == 200) {
				JOptionPane
						.showMessageDialog(null,
								"Now you save the small town! People are so happy that they won't suruand the demon!"
										+ "\nCongratuation and thank you for playing!",
								"", JOptionPane.INFORMATION_MESSAGE);

			}
			m.getP().setMoney(monster.getMoney() + m.getP().getMoney());

			m.getP().setExp(m.getP().getExp() + monster.getExp());
			if (m.getP().getExp() >= 10 && m.getP().getExp() < 30) {
				m.getP().setLevel(2);
				m.getP().setHealthmax(160);
				m.getP().setAttack(60);
				m.getP().setdefense(15);
				JOptionPane.showMessageDialog(null, "Your are lv2 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (m.getP().getExp() >= 30 && m.getP().getExp() < 50) {
				m.getP().setLevel(3);
				m.getP().setHealthmax(170);
				m.getP().setAttack(70);
				m.getP().setdefense(20);
				JOptionPane.showMessageDialog(null,
						"Your are lv3 now!\n\"You have learned the ability 'Two way'\"" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
				AbilityLimiter al = new AbilityLimiter(m.getP().ablist);
				Ability twoway = new TwoWay();
				if (!m.getP().ablist.hasAbility(twoway) && al.isKeep() == false) {
					if (al.AvoidDupulicate(m.getP(), twoway) == false) {
						m.getP().ablist.addAbility(twoway);
					}
				}

			} else if (m.getP().getExp() >= 50 && m.getP().getExp() < 80) {
				m.getP().setLevel(4);
				m.getP().setHealthmax(180);
				m.getP().setAttack(80);
				m.getP().setdefense(25);
				JOptionPane.showMessageDialog(null, "Your are lv4 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (m.getP().getExp() >= 80 && m.getP().getExp() < 120) {
				m.getP().setLevel(5);
				m.getP().setHealthmax(180);
				m.getP().setAttack(90);
				m.getP().setdefense(30);
				JOptionPane.showMessageDialog(null,
						"Your are lv5 now!\nYou have learned the ability 'Smash'" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
				AbilityLimiter al = new AbilityLimiter(m.getP().ablist);
				Ability smash = new Smash();
				if (!m.getP().ablist.hasAbility(smash) && al.isKeep() == false) {
					if (al.AvoidDupulicate(m.getP(), smash) == false) {
						m.getP().ablist.addAbility(smash);
					}
				}
			} else if (m.getP().getExp() >= 120 && m.getP().getExp() < 160) {
				m.getP().setLevel(6);
				m.getP().setHealthmax(185);
				m.getP().setAttack(95);
				m.getP().setdefense(35);
				JOptionPane.showMessageDialog(null, "Your are lv6 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (m.getP().getExp() >= 160 && m.getP().getExp() < 200) {
				m.getP().setLevel(7);
				m.getP().setHealthmax(190);
				m.getP().setAttack(100);
				m.getP().setdefense(35);
				JOptionPane.showMessageDialog(null,
						"Your are lv7 now!\nYou have learned the ability 'Reversal'" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
				AbilityLimiter al = new AbilityLimiter(m.getP().ablist);
				Ability reversal = new Reversal();
				if (!m.getP().ablist.hasAbility(reversal) && al.isKeep() == false) {
					if (al.AvoidDupulicate(m.getP(), reversal) == false) {
						m.getP().ablist.addAbility(reversal);
					}
				}
			} else if (m.getP().getExp() >= 200 && m.getP().getExp() < 250) {
				m.getP().setLevel(8);
				m.getP().setHealthmax(200);
				m.getP().setAttack(110);
				m.getP().setdefense(40);
				JOptionPane.showMessageDialog(null, "Your are lv8 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (m.getP().getExp() >= 250 && m.getP().getExp() < 300) {
				m.getP().setLevel(9);
				m.getP().setHealthmax(210);
				m.getP().setAttack(120);
				m.getP().setdefense(45);
				JOptionPane.showMessageDialog(null, "Your are lv9 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (m.getP().getExp() >= 300 && m.getP().getExp() < 384) {
				m.getP().setLevel(10);
				m.getP().setHealthmax(220);
				m.getP().setAttack(130);
				m.getP().setdefense(50);
				JOptionPane.showMessageDialog(null, "Your are lv10 now!" + monster.getMoney() + "$!", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
			m.getP().setColumn(5);
			m.getP().setRow(5);
			this.resize(1619,956);
			this.eventHandleSkip(m);
			
		}
		
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
