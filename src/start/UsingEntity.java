package start;
import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * This class is used when player want to use the entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class UsingEntity {
/**
 * This method is used to show when player used the weapon, the attack will increase,
 * using the for loop to find which entity player used.
 * And also avoid player to equip more than 1 weapon.
 * When player equip another weapon, the previous one will be replaced.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Weapondepender(String a,Player p) {
		String hit = "";
		int temp = p.getAttack();
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getWeapon() == null) {
    				p.setWeapon(e);
    				hit = "You have equip "+e.getName();
    				p.setAttack(p.getAttack()+e.getAttack());
    				hit = hit+"\nYour attack value becomes to "+p.getAttack();
    			}
    			else {
    				p.setAttack(p.getAttack()-p.getWeapon().getAttack());
    				hit = "\nYou have take off the "+e.getName() +" and attack reduce "+e.getAttack();
    				p.setWeapon(e);
    				hit = hit+"\nYou have equip "+e.getName();
    				p.setAttack(p.getAttack()+e.getAttack());
    				hit = hit+"\nYour attack value becomes to "+p.getAttack();
    				
    			}
    		}
    	}
		if(p.getAttack() == temp) {
			hit = "Sorry you do not have this weapon or you current equip this weapon.";
		}
		JOptionPane.showMessageDialog(null,hit, "Message",JOptionPane.INFORMATION_MESSAGE);
	}
/**
 * This method is used to show when player used the shield, the defense will increase,
 * using the for loop to find which entity player used.
 * And also avoid player to equip more than 1 shield.
 * When player equip another shield, the previous one will be replaced.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Shielddepender(String a,Player p) {
		String hit = "";
		int temp = p.getdefense();
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getShield() == null) {
    				p.setShield(e);
    				hit = "You have equip "+e.getName();
    				p.setdefense(p.getdefense()+e.getdefense());
    				hit = hit+"\nYour defense value becomes to "+p.getdefense();
    			}
    			else {
    				p.setdefense(p.getdefense()-p.getShield().getdefense());
    				hit = "You have take off the "+e.getName() +" and defense reduce "+e.getdefense();
    				p.setShield(e);
    				hit = hit+"\nYou have equip "+e.getName();
    				p.setdefense(p.getdefense()+e.getdefense());
    				hit = hit +"\nYour defense value becomes to "+p.getdefense();
    				
    			}
    		}
    	}
		if(p.getdefense() == temp) {
			hit = "Sorry you do not have this shield or you current equip this shield.";
		}
		JOptionPane.showMessageDialog(null,hit, "Message",JOptionPane.INFORMATION_MESSAGE);
	}
/**
 * This method is used when player use the consumable entity,
 * using the for loop to find which entity player used.
 * if player have more than one consumable entity, the quantity of that entity will reduce one,
 * else the entity will disappear after use.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Consumableuse(String a,Player p) {
		String hit = "";
		double temp = p.getHealth();
		for(int i = 0;i<p.enlist.getTotalnumber();i++) {
			if(p.enlist.getentityList()[i].getName().toLowerCase().equals(a)) {
				hit = "You have used the "+p.enlist.getentityList()[i].getName();
				p.setHealth(p.getHealth()+p.enlist.getentityList()[i].getHealth());
				hit = hit + "\nYou have healed "+p.enlist.getentityList()[i].getHealth();
				hit = hit + "\nNow you heal is "+p.getHealth();
				if(p.enlist.getentityList()[i].getNum() == 1) {
				    p.enlist.removeentityItems(i);
				}
				else {
					p.enlist.getentityList()[i].setNum(p.enlist.getentityList()[i].getNum()-1);
				}
			}
		}
		if(p.getHealth()==temp) {
			hit = "Sorry you do not have "+a;
		}
		JOptionPane.showMessageDialog(null,hit, "Message",JOptionPane.INFORMATION_MESSAGE);
	}
	Scanner sc = new Scanner(System.in);
/**
 * This is a constructor of this class, when call this constructor, it will display the entity list by calling PlayerEntityDisplay class,
 * then player input which entity, I using the switch to depend which type of entity he enter and call the method in this class to implement
 * the entity function.
 * @param p
 */
	public UsingEntity(String temp,Player p) {
	    temp = temp.toLowerCase();
	    switch(temp) {
	    case "axe":
	    	this.Weapondepender("axe", p);
	    	break;
	    case "hammer":
	    	this.Weapondepender("hammer", p);
	    	break;
	    case "pan":
	    	this.Weapondepender("pan", p);
	    	break;
	    case "sword":
	    	this.Weapondepender("sword", p);
	    	break;
	    case "dimond shield":
	    	this.Shielddepender("dimond shield", p);
	    	break;
	    case "golden shield":
	    	this.Shielddepender("golden shield", p);
	    	break;
	    case "iron shield":
	    	this.Shielddepender("iron shield", p);
	    	break;
	    case "silvery shield":
	    	this.Shielddepender("silvery shield", p);
	    	break; 
	    case "wooden shield":
	    	this.Shielddepender("wooden shield", p);
	    	break;
	    case "chinken thigth":
	    	this.Consumableuse("chinken thigth", p);
	    	break;
	    case "chocolate cake":
	    	this.Consumableuse("chocolate cake", p);
	    	break;
	    case "crow bar":
	    	this.Weapondepender("crow bar", p);
	    	break;
	    case "roast beef":
	    	this.Consumableuse("roast beef", p);
	    case "pp drink"://coz player have 4 ability so I need to use the switch case to depend which ability that player want to add pp.
	    	for(int i = 0;i<p.enlist.getTotalnumber();i++) {
				if(p.enlist.getentityList()[i].getName().toLowerCase().equals("pp drink")) {
					PlayerAbilityDisplay pad = new PlayerAbilityDisplay(p.ablist);
					String iii = JOptionPane.showInputDialog(null, "Please choose one of the skill"
							+ "\nYou can only input 1-4 value!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    try {
					   int num = Integer.valueOf(iii);
					   System.out.println(num);
					   while(num<1||num>4) {
						   JOptionPane.showInputDialog(null, "Please choose one of the skill"
									+ "\nYou can only input 1-4 value!", "Message", JOptionPane.INFORMATION_MESSAGE);
						   num = Integer.valueOf(JOptionPane.INPUT_VALUE_PROPERTY);
					   }
					   String hit = "";
					   switch(num) {
						case 1:
							p.ablist.getAbilitylist()[0].setPp(p.ablist.getAbilitylist()[0].getPp()+1);
							hit = p.ablist.getAbilitylist()[0].getName()+" pp + 1!";
						    break;
					   case 2:
						   p.ablist.getAbilitylist()[1].setPp(p.ablist.getAbilitylist()[1].getPp()+1);
						   hit = p.ablist.getAbilitylist()[1].getName()+" pp + 1!";
						   break;
					   case 3:
						   p.ablist.getAbilitylist()[2].setPp(p.ablist.getAbilitylist()[2].getPp()+1);
						  hit = p.ablist.getAbilitylist()[2].getName()+" pp + 1!";
						   break;
					   case 4:
						   p.ablist.getAbilitylist()[3].setPp(p.ablist.getAbilitylist()[3].getPp()+1);
						  hit = p.ablist.getAbilitylist()[3].getName()+" pp + 1!";
						   break;
					   }
					   hit = hit +"\nYou used 1 pp drink!";
					   p.enlist.removeentityItems(i);
					   JOptionPane.showMessageDialog(null,hit, "Message",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception e) {
						return;
					}
			}
	    }
	    	break;
	    }
 }
}
