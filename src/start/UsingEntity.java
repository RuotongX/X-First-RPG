package start;
import java.util.Scanner;

public class UsingEntity {
	Scanner sc = new Scanner(System.in);
	public UsingEntity(Player p) {
		System.out.println("You have opened your bag");
	    PlayerEntityDisplay ped = new PlayerEntityDisplay(p.enlist);
	    System.out.println("Please type the name of what you want to use.(Type 'e' go back.");
	    String temp = sc.nextLine().toLowerCase();
	    if(temp.equals("e")) {
	    	
	    }
	    else if(temp.equals("Axe")) {
	    	for(Entity entity:p.enlist.getentityList()) {
	    		
	    	}
	    }
 }
}
