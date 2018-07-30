package start;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Shopping {
	private enum Type{
		Entity,Ability,Healing;
	}
	public Shopping(Map m) {
		System.out.println("Welcome to CoNuTDoWn shop Warrior "+m.p.getName());
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please tell me what you want.");
			System.out.println("1. "+Type.Entity+" 2. "+Type.Ability+" 3. "+Type.Healing);
			int temp = sc.nextInt();
			switch(temp){
			case 1:
				TableDisplay td1 = new TableDisplay(m.shop.getEnlist());
				System.out.println("You can search what type entity you want, the result will search from the entity name and description."
						+ "type 'e' if you do not want to buy any things");
				String token ;
				sc.nextLine();
				token = sc.nextLine().toLowerCase();
				if (token.equals("e")) {
					break;
				}
				EntityList searchlist = new EntityList();
				for(int i =0;i< m.shop.getEnlist().getTotalnumber(); i++) {
					if(m.shop.getEnlist().getentityList()[i].getName().contains(token)||m.shop.getEnlist().getentityList()[i].getDescription().contains(token)) {
						searchlist.addentity(m.shop.getEnlist().getentityList()[i]);
					}
				}
				if(searchlist.getTotalnumber() == 0) {
					System.out.println("Sorry we do not hava "+token);
					break;
				}
				else {
				    TableDisplay td2 = new TableDisplay(searchlist);
				}
				System.out.println("Please choose which things you want to get, type the name below."
						+ "type 'e' if you do not want to buy any things");
				token = sc.nextLine().toLowerCase();
				if (token.equals("e")) {
					break;
				}
				for(int i =0;i< searchlist.getTotalnumber(); i++) {
					if(searchlist.getentityList()[i].getName().contains(token)) {
						if(searchlist.getentityList()[i].getMoney()<=m.p.getMoney()) {
						    m.p.setMoney(m.p.getMoney() - searchlist.getentityList()[i].getMoney());
						    m.p.enlist.addentity(searchlist.getentityList()[i]);
						}
						else {
							System.out.println("Sorry you do not have enough money");
						}
					}
					else {
					    System.out.println("Sorry we do not hava "+token);
						break;
						}
					}
				break;
			case 2:
				
				}
		} while (true);
	}
}
