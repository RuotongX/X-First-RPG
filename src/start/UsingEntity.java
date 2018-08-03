package start;
import java.util.Scanner;

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
	Scanner sc = new Scanner(System.in);
	public UsingEntity(Player p) {
		System.out.println("You have opened your bag");
	    PlayerEntityDisplay ped = new PlayerEntityDisplay(p.enlist);
	    System.out.println("Please type the name of what you want to use.(Type 'e' go back.");
	    String temp = sc.nextLine().toLowerCase();
	    if(temp.equals("e")) {
	    	
	    }
	    else if(temp.equals("axe")) {
	    	this.Weapondepender("axe", p);
	    }
	    else if(temp.equals("hammer")) {
	    	this.Weapondepender("hammer", p);
	    }
	    else if(temp.equals("pan")) {
	    	this.Weapondepender("pan", p);
	    }
	    else if(temp.equals("sword")) {
	    	this.Weapondepender("sword", p);
	    }
 }
}
