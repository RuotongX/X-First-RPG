package start;
import java.util.Scanner;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class UsingEntity {
	private void Weapondepender(String a,Player p) {
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getWeapon() == null) {
    				p.setWeapon(e);
    				System.out.println("You have equip "+e.getName());
    				p.setAttack(p.getAttack()+e.getAttack());
    				System.out.println("Your attack value becomes to "+p.getAttack());
    			}
    			else {
    				p.setAttack(p.getAttack()-p.getWeapon().getAttack());
    				System.out.println("You have take off the "+e.getName() +" and attack reduce "+e.getAttack());
    				p.setWeapon(e);
    				System.out.println("You have equip "+e.getName());
    				p.setAttack(p.getAttack()+e.getAttack());
    				System.out.println("Your attack value becomes to "+p.getAttack());
    				
    			}
    		}
    	}
	}
	private void Shielddepender(String a,Player p) {
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getShield() == null) {
    				p.setShield(e);;
    				System.out.println("You have equip "+e.getName());
    				p.setDefence(p.getDefence()+e.getDefence());
    				System.out.println("You defence has increased "+e.getDefence());
    				System.out.println("Your defence value becomes to "+p.getDefence());
    			}
    			else {
    				p.setDefence(p.getDefence()-p.getShield().getDefence());
    				System.out.println("You have take off the "+e.getName() +" and defence reduce "+e.getDefence());
    				p.setShield(e);
    				System.out.println("You have equip "+e.getName());
    				p.setDefence(p.getDefence()+e.getDefence());
    				System.out.println("Your defence value becomes to "+p.getDefence());
    				
    			}
    		}
    	}
	}
	private void Consumableuse(String a,Player p) {
		for(int i = 0;i<p.enlist.getTotalnumber();i++) {
			if(p.enlist.getentityList()[i].getName().toLowerCase().equals(a)) {
				System.out.println("You have used the "+p.enlist.getentityList()[i].getName());
				p.setHealth(p.getHealth()+p.enlist.getentityList()[i].getHealth());
				System.out.println("You have healed "+p.enlist.getentityList()[i].getHealth());
				System.out.println("Now you heal is "+p.getHealth());
				p.enlist.removeentityItems(i);
			}
		}
	}
	Scanner sc = new Scanner(System.in);
	public UsingEntity(Player p) {
		System.out.println("You have opened your bag");
	    PlayerEntityDisplay ped = new PlayerEntityDisplay(p.enlist);
	    System.out.println("Please type the name of what you want to use.(Type 'e' go back.");
	    String temp = sc.nextLine().toLowerCase();
	    switch(temp) {
	    case "e":
	    	break;
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
	    case "chicken thigth":
	    	this.Consumableuse("chicken thigth", p);
	    	break;
	    case "chocolate cake":
	    	this.Consumableuse("chocolate cake", p);
	    	break;
	    case "crow bar":
	    	this.Weapondepender("crow bar", p);
	    	break;
	    case "roastbeef":
	    	this.Consumableuse("roastbeef", p);
	    case "pp drink":
	    	for(int i = 0;i<p.enlist.getTotalnumber();i++) {
				if(p.enlist.getentityList()[i].getName().toLowerCase().equals("pp drink")) {
					PlayerAbilityDisplay pad = new PlayerAbilityDisplay(p.ablist);
					System.out.println("Please choose one of the skill");
                    try {
					   int num = sc.nextInt();
					   while(num<1||num>4) {
						   System.out.println("You can only input 1-4 value!");
					   }
					   switch(num) {
						case 1:
							p.ablist.getAbilitylist()[0].setPp(p.ablist.getAbilitylist()[0].getPp()+1);
							System.out.println(p.ablist.getAbilitylist()[0].getName()+" pp + 1!");
						    break;
					   case 2:
						   p.ablist.getAbilitylist()[1].setPp(p.ablist.getAbilitylist()[1].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[1].getName()+" pp + 1!");
						   break;
					   case 3:
						   p.ablist.getAbilitylist()[2].setPp(p.ablist.getAbilitylist()[2].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[2].getName()+" pp + 1!");
						   break;
					   case 4:
						   p.ablist.getAbilitylist()[3].setPp(p.ablist.getAbilitylist()[3].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[3].getName()+" pp + 1!");
						   break;
					   }
					   System.out.println("You used 1 pp drink!");
					   p.enlist.removeentityItems(i);
					}catch(Exception e) {
						System.out.println("Invalid input, you will get back to entity list!");
						sc.nextLine();
						return;
					}
			}
	    }
	    	break;
	    }
 }
}
