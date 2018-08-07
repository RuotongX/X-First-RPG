package start;
import java.util.Scanner;
import Ability.*;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class Battle {
	private double attack;
	private double defence;
	private int roundr;
	private int roundl;
	int fighting = 0;
	Scanner sc = new Scanner(System.in);
	private void skilldepender(String s,Map m,Monster monster) {
		if(s.equals("Attack With Hard")) {
			this.awh(m, monster);
		}
		else if(s.equals("Become Huge")) {
			this.bh(m,monster);
		}
		else if(s.equals("Huge Impact")) {
			this.hi(m, monster);
		}
		else if(s.equals("Leech Seed")) {
			this.ls(m, monster);
		}
		else if(s.equals("Reversal")) {
			this.rs(m,monster);
		}
		else if(s.equals("Smash")) {
			this.sm(m, monster);
		}
		else if(s.equals("Tackle")) {
			this.tk(m, monster);
		}
		else if(s.equals("TwoWay")) {
			this.tw(m, monster);
		}
	}
	private void awh(Map m,Monster monster) {
			for(Ability ability:m.p.ablist.getAbilitylist()) {
				if(ability.getName().toLowerCase().equals("attack with hard")){
					if (ability.getPp() > 0) {
					m.p.setTempattack(this.attack*ability.getStrength());
					this.defence = m.p.getDefence()*ability.getDefenceboost();
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					System.out.println("You feel your defence improve.");
					double damage1 = (m.p.getTempattack()-monster.getDefence());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
					} else {
						System.out.println("You do not have enough pp!");
						sc.nextLine();
					}
					double damage2 = (monster.getAttack()-this.defence);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
	}
	private void bh(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("become huge")) {
			  if (ability.getPp() > 0) {
				this.attack = m.p.getAttack()*ability.getAttackboost();
				this.defence = m.p.getDefence()*ability.getDefenceboost();
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				System.out.println("You feel you attack and defence improve a lot.");
			  } else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
		   }
		}
	}	
	private void hi(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			 if(ability.getName().toLowerCase().equals("huge Impact")) {
				 if (ability.getPp() > 0) {
					m.p.setTempattack(m.p.getAttack()*ability.getStrength());
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					double damage1 = (m.p.getTempattack()-monster.getDefence());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
				 } else {
						System.out.println("You do not have enough pp!");
						sc.nextLine();
					}
					double damage2 = (monster.getAttack()-this.defence);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			 }
	    }
	}
	private void sm(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if (ability.getName().toLowerCase().equals("smash")) {
				if (ability.getPp() > 0) {
					m.p.setTempattack(attack * ability.getStrength());
					ability.setPp(ability.getPp() - 1);
					System.out.println("You used the " + ability.getName());
					double damage1 = (m.p.getTempattack() - monster.getDefence());
					if (damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth() - damage1);
					System.out.println("You have deal " + damage1 + " to " + monster.getName());
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			}
		}
	}
	private void tk(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("tackle")) {
				if (ability.getPp() > 0) {
				m.p.setTempattack(attack*ability.getStrength());
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				double damage1 = (m.p.getTempattack()-monster.getDefence());
				if(damage1 <= 0) {
					damage1 = 1;
				}
				monster.setHealth(monster.getHealth()-damage1);
				System.out.println("You have deal "+damage1+" to "+monster.getName());
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			}
		}
	}
	private void rs(Map m, Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("reversal")) {
				if (ability.getPp() > 0) {
				this.roundr = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("You feel you are full of healing power.");
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("Your heal is "+m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				this.roundr = 2;
				while(this.roundr!=0) {
					this.typedepender(m, monster);
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
					System.out.println("Due to the Reversal you get "+m.p.getHealthmax()*ability.getHealupbyp()+" heals");
					System.out.println("Now you heal is "+m.p.getHealth());
					this.roundr--;
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
				}
				System.out.println("Reversal effect disappear.");
				} else {
					System.out.println("Sorry you have not enough pp");
					sc.nextLine();
					double damage2 = (monster.getAttack()-this.defence);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
		}
	}
	private void ls(Map m, Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("leech seed")) {
				if (ability.getPp() > 0) {
				this.roundl = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("Enemy got the leechseed and keep losing heal, you are healed by seed.");
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				monster.setHealth(monster.getHealth()-monster.getHealthmax()*ability.getPercentagehit());
				m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
				this.roundl = 2;
				System.out.println("Due to the Leech Seed enemy gets "+monster.getHealthmax()*ability.getPercentagehit()+" damages.");
				System.out.println("And due to the Leech Seed you get "+monster.getHealthmax()*ability.getPercentagehit()+" heals.");
				System.out.println("Now you heal is "+m.p.getHealth());
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				this.roundl = 2;
				while(this.roundl!=0) {
					this.typedepender(m, monster);
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*ability.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
					System.out.println("Due to the Leech Seed enemy gets "+monster.getHealthmax()*ability.getPercentagehit()+" damages.");
					System.out.println("And due to the Leech Seed you get "+monster.getHealthmax()*ability.getPercentagehit()+" heals.");
					System.out.println("Now you heal is "+m.p.getHealth());
					System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
					this.roundl--;
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
				}
				System.out.println("Reversal effect disappear.");
				} else {
					System.out.println("Sorry you have not enough pp");
					sc.nextLine();
					double damage2 = (monster.getAttack()-this.defence);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
		}
	}
	private void tw(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("twoway")) {
				if (ability.getPp() > 0) {
				this.attack = m.p.getAttack()*ability.getAttackboost();
				this.defence = m.p.getDefence()*ability.getDefenceboost();
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				System.out.println("You feel you attack and defence improved.");
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defence);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
		   }
		}
	}
	private void battle(Map m,Monster monster) {
		int temp =0;
    	    System.out.println("Please select your ability to attack. Type 1, 2, 3 or 4 to select.");
    	    PlayerAbilityDisplay pad = new PlayerAbilityDisplay(m.p.ablist);
    	    int order = sc.nextInt();
    	    String s = m.p.ablist.getAbilitylist()[order-1].getName();
    	    this.skilldepender(s, m, monster);
    	    if(m.p.getHealth() <= 0) {
    	    	m.p.setRow(9);
    	    	m.p.setColumn(8);
    	    	m.p.setMoney(m.p.getMoney()/2);
    	    	m.p.setHealth(m.p.getHealthmax());
    	    	for (int i = 0; i < m.p.ablist.getTotalnumber(); i++) {
					m.p.ablist.getAbilitylist()[i].setPp(m.p.ablist.getAbilitylist()[i].getMaxpp());
				}
    	    	this.fighting =1;
    	    	System.out.println("You have been defeated!!");
    	    }
    	    if(monster.getHealth() <= 0) {
    	    	System.out.println("You have slain the monster! You have earned: "+monster.getMoney()+"$!");
    	    	if(monster.getHealthmax()==25) {
    	    		m.p.setM1defeat(true);
    	    	}
    	    	else if(monster.getHealthmax()==50) {
    	    		m.p.setM2defeat(true);
    	    	}
    	    	else if(monster.getHealthmax() == 90) {
    	    		m.p.setM3defeat(true);
    	    	}
    	    	else if(monster.getHealthmax() == 200) {
    	    		System.out.println("Now you save the small town! People are so happy that they won't suruand the demon!");
    	    		System.out.println("Congratuation and thank you for playing!");
    	    	}
    	    	m.p.setMoney(monster.getMoney()+m.p.getMoney());
    	    	
    	    	m.p.setExp(m.p.getExp()+monster.getExp());
    	    	if(m.p.getExp()>=10 && m.p.getExp()<30) {
    	    		m.p.setLevel(2);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv2 now!");
    	    	}
    	    	else if(m.p.getExp()>=30 && m.p.getExp()<50) {
    	    		m.p.setLevel(3);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv3 now!");
    	    	}
    	    	else if(m.p.getExp()>=50 && m.p.getExp()<80) {
    	    		m.p.setLevel(4);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv4 now!");
    	    	}
    	    	else if(m.p.getExp()>=80 && m.p.getExp()<120) {
    	    		m.p.setLevel(5);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv5 now!");
    	    	}
    	    	else if(m.p.getExp()>=120 && m.p.getExp()<160) {
    	    		m.p.setLevel(6);
    	    		System.out.println("Congrations! Level up! Your are lv6 now!");
    	    	}
    	    	else if(m.p.getExp()>=160 && m.p.getExp()<200) {
    	    		m.p.setLevel(7);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv7 now!");
    	    	}
    	    	else if(m.p.getExp()>=200 && m.p.getExp()<250) {
    	    		m.p.setLevel(8);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv8 now!");
    	    	}
    	    	else if(m.p.getExp()>=250 && m.p.getExp()<300) {
    	    		m.p.setLevel(9);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv9 now!");
    	    	}
    	    	else if(m.p.getExp()>=300 && m.p.getExp()<384) {
    	    		m.p.setLevel(10);
    	    		m.p.setHealthmax(150);
    	    		m.p.setAttack(50);
    	    		m.p.setDefence(10);
    	    		System.out.println("Congrations! Level up! Your are lv10 now!");
    	    	}
    	    	this.fighting =1;
    	    	m.p.setColumn(5);
    	    	m.p.setRow(5);
    	    	}	
    	 }
	private void typedepender(Map m,Monster monster) {
		System.out.println("Please decide what you want to do: (Type the number)");
	    do {
	    	System.out.println("1.Battle");
	    	System.out.println("2.Bag");
	    	System.out.println("3.Run");
	    	try {
	    	     int order = sc.nextInt();
	    	     switch(order) {
	    	     case 1:
	    	    	 this.battle(m,monster);
	    	    	 break;
				 case 2:
					 UsingEntity ue = new UsingEntity(m.p);
	    	    	 double damage2 = (monster.getAttack()-this.defence);
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
	    		System.err.println(e);
	    	}
	
	}while(fighting == 0);
	}
	public Battle(Map m,Monster monster) {	
		this.attack = m.p.getAttack();
		this.defence = m.p.getDefence();
		System.out.println(m.p.getName()+" you meet a "+monster.getName()+"!");
    	this.typedepender(m, monster);
	}
}
