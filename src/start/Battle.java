package start;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Ability.*;
/**
 * This class is used to implement the battle when player meet the monster.
 * @author RuotongXu QiChangZhou
 *
 */
public class Battle {
	private double attack;
	private double defense;
	private int roundr = 0;
	private int roundl = 0;
	int fighting = 0;
	Scanner sc = new Scanner(System.in);
	TwoWay twoway = new TwoWay();
	Smash smash = new Smash();
	Reversal reversal = new Reversal();
	LeechSeed leechseed = new LeechSeed();
/**
 * This method is used to depend which ability player choose by recognize the input ability name.
 * Then call the method which is belong to that ability.
 * @param s
 * @param m
 * @param monster
 */
	public void skilldepender(String s,Map m,Monster monster) {
		if(s.contains("Attack With Hard")) {
			this.awh(m, monster);
		}
		else if(s.contains("Become Huge")) {
			this.bh(m,monster);
		}
		else if(s.contains("Huge Impact")) {
			this.hi(m, monster);
		}
		else if(s.contains("Leech Seed")) {
			this.ls(m, monster);
		}
		else if(s.contains("Reversal")) {
			this.rs(m,monster);
		}
		else if(s.contains("Smash")) {
			this.sm(m, monster);
		}
		else if(s.contains("Tackle")) {
			this.tk(m, monster);
		}
		else if(s.contains("TwoWay")) {
			this.tw(m, monster);
		}
	}
/**
 * This method is when the player use ability "attack with hard", 
 * this round the player will attack the monster and player will get a defense improved, then hit by the monster. 
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void awh(Map m,Monster monster) {
		String hit;
			for(Ability ability:m.p.ablist.getAbilitylist()) {
				if(ability.getName().toLowerCase().equals("attack with hard")){
					if (ability.getPp() > 0) {
					m.p.setTempattack(this.attack*ability.getStrength());
					this.defense = this.defense*ability.getdefenseboost();
					ability.setPp(ability.getPp()-1);
					hit = "You used the "+ability.getName();
					hit = hit+"\nYou feel your defense improve.";
					double damage1 = (m.p.getTempattack()-monster.getdefense());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					hit = hit+"\nYou have deal "+damage1+" to "+monster.getName();
					} else {
						hit = "You do not have enough pp!";
						
					}
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					hit=hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
					if(roundr!=0) {
						m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
						hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
						this.roundr--;
						if(roundr == 0) 
							hit = hit+"\nReversal effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundr=0;
						}
					} 
					if(roundl!=0) {
						monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
						m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
						hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
						hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
						this.roundl--;
						if(roundl == 0) 
							hit = hit+"\nLeech Seed effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundl=0;
						}
					}
					JOptionPane.showMessageDialog(null,hit, "info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
	}
/**
 * This method is when player use the ability "become huge",
 * this round player will increase the attack and defense, then hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void bh(Map m,Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("become huge")) {
			  if (ability.getPp() > 0) {
				this.attack = this.attack*ability.getAttackboost();
				this.defense = this.defense*ability.getdefenseboost();
				ability.setPp(ability.getPp()-1);
				hit = "You used the "+ability.getName();
				hit = hit+"\nYou feel you attack and defense improve a lot.";
			  } else {
				  hit = "You do not have enough pp!";
				  
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				if(roundr!=0) {
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
					hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
					this.roundr--;
					if(roundr == 0) 
						hit = hit+"\nReversal effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
				} 
				if(roundl!=0) {
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
					hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
					hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
					this.roundl--;
					if(roundl == 0) 
						hit = hit+"\nLeech Seed effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
		   }
		}
	}	
/**
 * This method is when the player use ability "huge impact",
 * This round player will attack to the monster, than hit by monster.
 *(The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void hi(Map m,Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			 if(ability.getName().toLowerCase().equals("huge impact")) {
				 if (ability.getPp() > 0) {
					m.p.setTempattack(m.p.getAttack()*ability.getStrength());
					ability.setPp(ability.getPp()-1);
					hit = "You used the "+ability.getName();
					double damage1 = (m.p.getTempattack()-monster.getdefense());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					hit = hit+"\nYou have deal "+damage1+" to "+monster.getName();
				 } else {
						hit = "You do not have enough pp!";
						
					}
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
					if(roundr!=0) {
						m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
						hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
						this.roundr--;
						if(roundr == 0) 
							hit = hit+"\nReversal effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundr=0;
						}
					} 
					if(roundl!=0) {
						monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
						m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
						hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
						hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
						this.roundl--;
						if(roundl == 0) 
							hit = hit+"\nLeech Seed effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundl=0;
						}
					}
					JOptionPane.showMessageDialog(null,hit, "info",
							JOptionPane.INFORMATION_MESSAGE);
			 }
	    }
	}
/**
 * This method is used when player use ability "smash",
 * This round player will attack to the monster, than hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void sm(Map m,Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if (ability.getName().toLowerCase().equals("smash")) {
				if (ability.getPp() > 0) {
					m.p.setTempattack(attack * ability.getStrength());
					ability.setPp(ability.getPp() - 1);
					hit = "You used the " + ability.getName();
					double damage1 = (m.p.getTempattack() - monster.getdefense());
					if (damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth() - damage1);
					hit ="\nYou have deal " + damage1 + " to " + monster.getName();
				} else {
					hit = "You do not have enough pp!";
					
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				if(roundr!=0) {
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
					hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
					this.roundr--;
					if(roundr == 0) 
						hit = hit+"\nReversal effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
				} 
				if(roundl!=0) {
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
					hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
					hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
					this.roundl--;
					if(roundl == 0) 
						hit = hit+"\nLeech Seed effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
/**
 * This method is used when player use ability "tackle",
 *  This round player will attack to the monster, than hit by monster.
 *  (The ability pp will reduce and damage calculate in this method too.)	
 * @param m
 * @param monster
 */
	private void tk(Map m,Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("tackle")) {
				if (ability.getPp() > 0) {
				m.p.setTempattack(attack*ability.getStrength());
				ability.setPp(ability.getPp()-1);
				hit = "You used the "+ability.getName();
				double damage1 = (m.p.getTempattack()-monster.getdefense());
				if(damage1 <= 0) {
					damage1 = 1;
				}
				monster.setHealth(monster.getHealth()-damage1);
				hit = hit+"\nYou have deal "+damage1+" to "+monster.getName();
				} else {
					hit = "You do not have enough pp!";
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				if(roundr!=0) {
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
					hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
					this.roundr--;
					if(roundr == 0) 
						hit = hit+"\nReversal effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
				} 
				if(roundl!=0) {
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
					hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
					hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
					this.roundl--;
					if(roundl == 0) 
						hit = hit+"\nLeech Seed effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}
/**
 * This method is used when the player use ability "reversal",
 * Player will heal up 1/3 heal for 3 times after the damage calculation turn by using while loop.
 * @param m
 * @param monster
 */
	private void rs(Map m, Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("reversal")) {
				if (ability.getPp() > 0) {
				this.roundr = 3;
				ability.setPp(ability.getPp()-1);
				hit = "You feel you are full of healing power.";
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				hit = hit+"\nYou heal up "+m.p.getHealthmax()*ability.getHealupbyp()+" due to reversal";
				this.roundr = 2;
				} else {
					hit = "Sorry you have not enough pp";
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
					if(roundr!=0) {
						m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
						hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
						this.roundr--;
						if(roundr == 0) 
							hit = hit+"\nReversal effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundr=0;
						}
					} 
					if(roundl!=0) {
						monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
						m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
						hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
						hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
						this.roundl--;
						if(roundl == 0) 
							hit = hit+"\nLeech Seed effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundl=0;
						}
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
/**
 * This method is used when the player use ability "leech seed",
 * the monster will reduce some heal and player will heal the same value for 3 rounds after damage calculation turn,
 * which is the same way to implement compare with "reversal".
 * @param m
 * @param monster
 */
	private void ls(Map m, Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("leech seed")) {
				if (ability.getPp() > 0) {
				this.roundl = 3;
				ability.setPp(ability.getPp()-1);
				hit = "Enemy got the leechseed and keep losing heal, you are healed by seed.";
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit=hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				monster.setHealth(monster.getHealth()-monster.getHealthmax()*ability.getPercentagehit());
				m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
				this.roundl = 2;
				hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*ability.getPercentagehit()+" damages.";
				hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*ability.getPercentagehit()+" heals.";
				
				this.roundl = 2;
			
				} else {
					hit = "Sorry you have not enough pp";
					sc.nextLine();
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
					if(roundr!=0) {
						m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
						hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
						this.roundr--;
						if(roundr == 0) 
							hit = hit+"\nReversal effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundr=0;
						}
					} 
					if(roundl!=0) {
						monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
						m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
						hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
						hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
						this.roundl--;
						if(roundl == 0) 
							hit = hit+"\nLeech Seed effect disappear";
						if(monster.getHealth() <= 0) {
							this.roundl=0;
						}
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
/**
 * This method is used when player use ability "two way",
 * this round player will increase the attack and defense, then hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void tw(Map m,Monster monster) {
		String hit;
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("twoway")) {
				if (ability.getPp() > 0) {
				this.attack = this.attack*ability.getAttackboost();
				this.defense = this.defense*ability.getdefenseboost();
				ability.setPp(ability.getPp()-1);
				hit = "You used the "+ability.getName();
				hit =hit+"\nYou feel you attack and defense improved.";
				} else {
					hit ="You do not have enough pp!";
				
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				hit = hit+"\n"+monster.getName()+" deals you "+damage2+" damages!";
				if(roundr!=0) {
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*this.reversal.getHealupbyp());
					hit = hit+"\nDue to the Reversal you get "+m.p.getHealthmax()*this.reversal.getHealupbyp()+" heals";
					this.roundr--;
					if(roundr == 0) 
						hit = hit+"\nReversal effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
				} 
				if(roundl!=0) {
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*this.leechseed.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*this.leechseed.getPercentagehit());
					hit = hit+"\nDue to the Leech Seed enemy gets "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" damages.";
					hit = hit+"\nAnd due to the Leech Seed you get "+monster.getHealthmax()*this.leechseed.getPercentagehit()+" heals.";
					this.roundl--;
					if(roundl == 0) 
						hit = hit+"\nLeech Seed effect disappear";
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
				}
				JOptionPane.showMessageDialog(null,hit, "info",
						JOptionPane.INFORMATION_MESSAGE);
		   }
		}
	}
/**
 * This method is when player choose to use ability when fighting with monster
 * It will display the ability list of player by calling the play ability display class,
 * then use the skilldepender to depend which ability player type in to use.
 * it also depends the battle progress is over or not by conform the health of player and monster.
 * @param m
 * @param monster
 */
	private void battle(Map m,Monster monster) {
		int temp =0;
    	    System.out.println("Please select your ability to attack. Type 1, 2, 3 or 4 to select.");
    	    PlayerAbilityDisplay pad = new PlayerAbilityDisplay(m.p.ablist);
    	    int order = sc.nextInt();
    	    String s = m.p.ablist.getAbilitylist()[order-1].getName();
    	    this.skilldepender(s, m, monster);
    	    
    	 }
/**
 * This method is used to decide which thing player want to do when fight with the monster by using switch case,
 * if the input is invalid, player escape.
 * @param m
 * @param monster
 */
	private void typedepender(Map m,Monster monster) {
		int order = 3;
		System.out.println("Please decide what you want to do: (Type the number)");
	    	System.out.println("1.Battle");
	    	System.out.println("2.Bag");
	    	System.out.println("3.Run");
	    	try {
	    	     order = sc.nextInt();
	    	     switch(order) {
	    	     case 1:
	    	    	 this.battle(m,monster);
	    	    	 break;
				 case 2:
//					 UsingEntity ue = new UsingEntity(m.p);
	    	    	 double damage2 = (monster.getAttack()-this.defense);
						if(damage2 <= 0) {
							damage2 = 1;
						}
						m.p.setHealth(m.p.getHealth()-damage2);
						System.out.println(monster.getName()+" deals you "+damage2+" damages!");
						System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
						break;
	    	     case 3:
	    	    	 System.out.println("You escape from " +monster.getName());
	    	    	 fighting = 1;
	    	    	 break;
	    	     }
	    	}catch(Exception e) {
	    		System.out.println("Input invalid, you will be kicked out!");
	    		this.fighting =1;
	    	}
	}
/**
 * This is a constructor. When player meet a monster, it will give the initial value to attack and defense of player for the battle
 * it will keep looping order input if the battle is not over(player or monster dead or player escape)by using the do while loop.
 * @param m
 * @param monster
 */
	public Battle(Map m,Monster monster) {	
		this.attack = m.p.getAttack();
		this.defense = m.p.getdefense();
		JOptionPane.showMessageDialog(null, m.p.getName()+" you meet a "+monster.getName()+"!", "",
				JOptionPane.INFORMATION_MESSAGE);
		
//		do {
//    	    this.typedepender(m, monster);
//		} while(fighting == 0);
	}

}
