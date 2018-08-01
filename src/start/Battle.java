package start;
import java.util.Scanner;
import Ability.*;

public class Battle {
	private double attack;
	private double defence;
	private int round;
	Scanner sc = new Scanner(System.in);
	public enum skill{
		AttackWithHard,BecomeHuge,HugeImpact,LeechSeed,Reversal,Smash,Tackle,TwoWay;
	}
	private skill s;
	private void awh(Map m,Monster monster) {
			for(Ability ability:m.p.ablist.getAbilitylist()) {
				if(ability.getName().toLowerCase().equals("attackwithhard")){
					m.p.setTempattack(this.attack*ability.getStrength());
					this.defence = m.p.getDefence()*ability.getDefenceboost();
					m.p.setTempdefence(this.defence);
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					System.out.println("You feel your defence improve.");
					double damage1 = (m.p.getTempattack()-monster.getDefence());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
					double damage2 = (monster.getAttack()-m.p.getTempdefence());
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
			if(ability.getName().toLowerCase().equals("becomehuge")) {
				m.p.setTempattack(m.p.getAttack()*ability.getAttackboost());
				m.p.setTempdefence(m.p.getDefence()*ability.getDefenceboost());
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				System.out.println("You feel you attack and defence improve a lot.");
				double damage2 = (monster.getAttack()-m.p.getTempdefence());
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
			 if(ability.getName().toLowerCase().equals("hugeImpact")) {
					m.p.setTempattack(m.p.getAttack()*ability.getStrength());
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					double damage1 = (m.p.getTempattack()-monster.getDefence());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
					double damage2 = (monster.getAttack()-m.p.getTempdefence());
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
			if(ability.getName().toLowerCase().equals("smash")) {
				m.p.setTempattack(attack*ability.getStrength());
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				double damage1 = (m.p.getTempattack()-monster.getDefence());
				if(damage1 <= 0) {
					damage1 = 1;
				}
				monster.setHealth(monster.getHealth()-damage1);
				System.out.println("You have deal "+damage1+" to "+monster.getName());
				double damage2 = (monster.getAttack()-m.p.getTempdefence());
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
				m.p.setTempattack(attack*ability.getStrength());
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				double damage1 = (m.p.getTempattack()-monster.getDefence());
				if(damage1 <= 0) {
					damage1 = 1;
				}
				monster.setHealth(monster.getHealth()-damage1);
				System.out.println("You have deal "+damage1+" to "+monster.getName());
				double damage2 = (monster.getAttack()-m.p.getTempdefence());
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
				this.round = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("You feel you are full of healing power.");
				double damage2 = (monster.getAttack()-m.p.getTempdefence());
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("Your heal is "+m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("Now you heal is "+m.p.getHealth());
				this.round = 2;
				while(this.round!=0) {
					battle(m,monster);
					System.out.println("Due to the Reversal you get "+m.p.getHealthmax()*ability.getHealupbyp());
					System.out.println("Now you heal is "+m.p.getHealth());
					this.round--;
				}
				System.out.println("Reversal effect disappear.");
			}
		}
	}
	private void ls(Map m, Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("leechseed")) {
				this.round = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("Enemy got the leechseed and keep losing heal, you are healed by seed.");
				double damage2 = (monster.getAttack()-m.p.getTempdefence());
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				monster.setHealth(monster.getHealthmax()*ability.getPercentagehit());
				m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
				m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("Due to the Reversal you get "+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("Now you heal is "+m.p.getHealth());
				this.round = 2;
				while(this.round!=0) {
					battle(m,monster);
					System.out.println("Due to the Reversal you get "+m.p.getHealthmax()*ability.getHealupbyp());
					System.out.println("Now you heal is "+m.p.getHealth());
					this.round--;
				}
				System.out.println("Reversal effect disappear.");
			}
		}
	}
	private void battle(Map m,Monster monster) {
		do {
    	    System.out.println("Please select your ability to attack. Type 1, 2, 3 or 4 to select.");
    	    PlayerAbilityDisplay pad = new PlayerAbilityDisplay(m.p.ablist);
    	    int order = sc.nextInt();
    	 }while(true);
	}
	
	public Battle(Map m,Monster monster) {	
		int fighting = 0;
		this.attack = m.p.getAttack();
		this.defence = m.p.getDefence();
		System.out.println(m.p.getName()+" you meet a "+monster.getName()+"!");
    	System.out.println("Please decide what you want to do: (Type the number)");
	    do {
	    	System.out.println("1.Battle");
	    	System.out.println("2.Bag");
	    	System.out.println("3.Run");
	    	try {
	    	     int order = sc.nextInt();
	    	     switch(order) {
	    	     case 1:
	    	    	 break;
				 case 2:
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
}
