package start;
import java.util.Scanner;

public class Battle {
	public Battle(Map m,Monster monster) {	
		int fighting = 0;
		Scanner sc = new Scanner(System.in);
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
	    	    	 fighting = 1;
	    	    	 break;
	    	     }
	    	}catch(Exception e) {
	    		System.err.println(e);
	    	}
	    }while(fighting == 0);
	}
}
