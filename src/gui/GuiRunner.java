package gui;

import java.awt.Color;
import java.awt.Font;
import Ability.*;
import start.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import Ability.AbilityLimiter;
import database.PlayerDB;
import java.io.FileNotFoundException;
import database.*;
/**
 * This is the control class which is a part of MVC.This class control the panel changes and event happen.
 * @author RuotongXu QichangZhou
 *
 */
public class GuiRunner extends JFrame {
	public MapDisplay md;
	public BattleA ba;
	public BattleB bb;
	public BattleC bc;
	public BattleD bd;
	public ShopGUI sg;
	FileControl fc = new FileControl();
//        PlayerDB pdb = new PlayerDB();
	Map m = new Map();
	Battle battle = null;
/**
 * This method is used to change the panel in this JFrame.
 * @param changeTo 
 */
	public void changeP(JPanel changeTo) {
		this.getContentPane().removeAll();
		this.getContentPane().add(changeTo);
		this.repaint();
	}
        /**
         * This class is used to check the position of player in the map.
         * @param m 
         */
	private void positionCheck(Map m) {
		if (m.getP().getRow() == m.getM1().getRow() && m.getP().getColumn() == m.getM1().getColumn()//If at this place,player meet monster
				&& m.getFloor() == 0) {
			ba = new BattleA(m, m.getM1());
			this.changeP(ba);
			BattleControl(m, m.getM1());
		} else if (m.getP().getRow() == m.getM2().getRow() && m.getP().getColumn() == m.getM2().getColumn()//If at this place,player meet monster
				&& m.getFloor() == 0) {
			bb = new BattleB(m, m.getM2());
			this.getContentPane().removeAll();
			this.getContentPane().add(bb);
			this.repaint();
			BattleControl(m, m.getM2());
		} else if (m.getP().getRow() == m.getM3().getRow() && m.getP().getColumn() == m.getM3().getColumn()//If at this place,player meet monster
				&& m.getFloor() == 0) {
			bc = new BattleC(m, m.getM3());
			this.getContentPane().removeAll();
			this.getContentPane().add(bc);
			this.repaint();
			BattleControl(m, m.getM3());
		} else if (m.getP().getRow() == m.getShop().getRow() && m.getP().getColumn() == m.getShop().getColumn()//If at this place player get into the store and also the store action listener are added here.
				&& m.getFloor() == 0) {
			sg = new ShopGUI(m);
			Shopping sp = new Shopping();
			sg.confirm.setEnabled(false);
			sg.sch.setEnabled(false);
			sg.Healup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (m.getP().getMoney() >= 6) {
						m.getP().setMoney(m.getP().getMoney() - 6);
						m.getP().setHealth(m.getP().getHealthmax());
						for (int i = 0; i < m.getP().ablist.getTotalnumber(); i++) {
							m.getP().ablist.getAbilitylist()[i].setPp(m.getP().ablist.getAbilitylist()[i].getMaxpp());
						}
						JOptionPane.showMessageDialog(null,"Heal finished.", "info",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,"Sorry your money is " + m.getP().getMoney() + " \nyou can't get healed.", "info",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			sg.exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getP().setRow(9);
					m.getShop().renew();
					eventHandleSkip(m);
				}
			});
			sg.sch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EntityList model = sg.model1;
					String text = sg.search.getText().toLowerCase();
					EntityList search = new EntityList();
					for (Entity m : sg.model1.getentityList()) {
						if (m.getName().toLowerCase().contains(text)) {
							search.addentity(m);
						}
					}
					if (search.getentityList().length == 0) {
						model.clear();
						sg.update();
						JOptionPane.showMessageDialog(null,"Sorry, No such entity has found.", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						model.clear();
						for (int i = 0; i < search.getentityList().length; i++) {
							model.addentity(search.getentityList()[i]);
						}
						sg.update();
					}
					
				}
			});
			sg.search.addKeyListener(new KeyAdapter() {//This is the search action to get the input in text field, and the scrollpane will renew for the search result.
				public void keyReleased(KeyEvent e) {
					sg.sch.setEnabled(!sg.search.getText().isEmpty());
				}
			});
			sg.shopelist.addListSelectionListener(new ListSelectionListener() {//This can make the confirm be used after user select any thing in scrollPane.
				public void valueChanged(ListSelectionEvent e) {
					sg.confirm.setEnabled(true);
				}
			});
			sg.shopalist.addListSelectionListener(new ListSelectionListener() {//This can make the confirm be used after user select any thing in scrollPane.
				public void valueChanged(ListSelectionEvent e) {
					sg.confirm.setEnabled(true);
					sg.confirm.requestFocus();
				}
			});
			sg.confirm.addActionListener(new ActionListener() {//This can let user buy the select thing
				public void actionPerformed(ActionEvent e) {
					if(sg.shopelist.getSelectedIndex()!=-1) {
						int temp = sg.shopelist.getSelectedIndex();
						sp.entitybuy(m, sg.model1.getentityList()[temp].getName());
					} 
					if(sg.shopalist.getSelectedIndex()!=-1) {
						int temp = sg.shopalist.getSelectedIndex();
						sp.abilitybuy(m, sg.model2.getAbilitylist()[temp].getName());
					}
				}
			});
			
			this.resize(1615, 965);
			this.changeP(sg);
		} else if (m.getP().getRow() == 9 && m.getP().getColumn() == 1) {//when player at this place start door dependence, if condition is achieve player can get into the door and go upstair, else stay at the same floor.
			BoyNextDoor bnd = new BoyNextDoor(m, md);
			if (m.getFloor() == 1) {
				changeP(md);
			} else {
				md.update(m, m.getFloor() + 1);
				changeP(md);
			}

		} else if (m.getP().getRow() == m.getBoss().getRow() && m.getP().getColumn() == m.getBoss().getColumn()//when player at this place, player meet boss
				&& m.getFloor() == 1) {
			bd = new BattleD(m, m.getBoss());
			this.getContentPane().removeAll();
			this.getContentPane().add(bd);
			this.repaint();
			BattleControl(m, m.getBoss());
		}
	}
/**
 * This class is used for battle control to depend which things will happen during the battle.
 * @param m
 * @param mon 
 */
	private void BattleControl(Map m, Monster mon) {
		if(this.battle == null) {
			this.battle = new Battle(m, mon);
		} else {
			
		}
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
					m.getP().setColumn(5);
					m.getP().setRow(5);
					resize(1618,956);
					battle = null;
					eventHandleSkip(m);
				}
			});
			ba.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
			ba.playerBag.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bag bag = new Bag(m);
					resize(1623,956);
					changeP(bag);
					bag.exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							resize(1621,955);
							changeP(ba);
							BattleControl(m,mon);
						}
						
					});
					bag.confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int index = bag.entitylist.getSelectedIndex();
								UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
							} catch(Exception ee) {
								JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
							}
							bag.requestFocus();
						}
					});
					ba.requestFocus();
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
					m.getP().setColumn(5);
					m.getP().setRow(5);
					resize(1618,955);
					battle = null;
					eventHandleSkip(m);
				}
			});
			bb.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
			bb.playerBag.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bag bag = new Bag(m);
					resize(1623,956);
					changeP(bag);
					bag.exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							resize(1621,955);
							changeP(bb);
							BattleControl(m,mon);
						}
						
					});
					bag.confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int index = bag.entitylist.getSelectedIndex();
								UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
							} catch(Exception ee) {
								JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
							}
							bag.requestFocus();
						}
					});
					bb.requestFocus();
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
					battle = null;
					eventHandleSkip(m);
				}
			});
			bc.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
			bc.playerBag.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bag bag = new Bag(m);
					resize(1623,956);
					changeP(bag);
					bag.exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							resize(1621,955);
							changeP(bc);
							BattleControl(m,mon);
						}
						
					});
					bag.confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int index = bag.entitylist.getSelectedIndex();
								UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
							} catch(Exception ee) {
								JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
							}
							bag.requestFocus();
						}
					});
					bc.requestFocus();
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
					battle = null;
					eventHandleSkip(m);
				}
			});
			bd.checkAbility.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eventHandleCheckAbilityDisplay(m);
				}
			});
			bd.playerBag.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bag bag = new Bag(m);
					resize(1623,956);
					changeP(bag);
					bag.exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							resize(1621,955);
							changeP(bd);
							BattleControl(m,mon);
						}
						
					});
					bag.confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int index = bag.entitylist.getSelectedIndex();
								UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
							} catch(Exception ee) {
								JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
							}
							bag.requestFocus();
						}
					});
					bd.requestFocus();
					}	
				});
		}
	}

/**
 * This class is used to control user to start a new game
 * @param m 
**/
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
/**
* This class is used to user to load game since last time.
*
**/
	public void eventHandleLoadGame(Map m) {
		try {
//                        pdb.getinfo(m);
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
/**
* This class is to control whether player can go upstairs or not, once player defeatd all the 3 monsters at ground floor, it will be
* able to allow the player to go upstairs.
*/
	private void defeatbyBoss(Map m) {
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
		this.md.checkEntity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bag bag = new Bag(m);
				resize(1618,957);
				changeP(bag);
				bag.exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						eventHandleSkip(m);
					}
					
				});
				bag.confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int index = bag.entitylist.getSelectedIndex();
							UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
						} catch(Exception ee) {
							JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
						}
						bag.requestFocus();
					}
				});
				md.requestFocus();
				}	
			});

		this.md.setFocusable(true);

	}
/**
* In this method we call the database method
*/
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
		this.md.checkEntity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bag bag = new Bag(m);
				resize(1618,957);
				changeP(bag);
				bag.exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						eventHandleSkip(m);
					}
					
				});
				bag.confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int index = bag.entitylist.getSelectedIndex();
							UsingEntity ue = new UsingEntity(bag.model1.getentityList()[index].getName(),m.getP());
						} catch(Exception ee) {
							JOptionPane.showMessageDialog(null, "You have not choose one of the Entity!", "Error",JOptionPane.ERROR_MESSAGE);
						}
						bag.requestFocus();
					}
				});
				md.requestFocus();
				}	
			});

		this.md.setFocusable(true);

	}
/**
 * This class call the database
 * @param m
 * @param userInput 
 */
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
			fc.savefile(m.getP());
//                        pdb.addinfo(m);
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
			m.setFloor(0);
			m.getP().setMoney(m.getP().getMoney() / 2);
			m.getP().setHealth(m.getP().getHealthmax());
			for (int i = 0; i < m.getP().ablist.getTotalnumber(); i++) {
				m.getP().ablist.getAbilitylist()[i].setPp(m.getP().ablist.getAbilitylist()[i].getMaxpp());
			}
			JOptionPane.showMessageDialog(null, "You have been defeated!!", "", JOptionPane.INFORMATION_MESSAGE);
			
			this.resize(1621,954);
			battle = null;
			this.defeatbyBoss(m);
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
			battle = null;
			this.eventHandleSkip(m);
			
		}
		
	}
/**
 * 
 */
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
