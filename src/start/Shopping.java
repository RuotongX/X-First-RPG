package start;
import java.util.Scanner;

import Ability.AbilityLimiter;

public class Shopping {
	private enum Type{
		Entity,Ability,Healing,goback;
	}
	public Shopping(Map m) {
		System.out.println("Welcome to CoNuTDoWn shop Warrior "+m.p.getName());
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		do {
			System.out.println("Please tell me what you want.");
			System.out.println("1. "+Type.Entity+" 2. "+Type.Ability+" 3. "+Type.Healing+"(costs 6 dollors) 4. "+Type.goback);
			temp = sc.nextInt();
			switch(temp){
			case 1:
				EntityTableDisplay td1 = new EntityTableDisplay(m.shop.getEnlist());
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
					System.out.println("Sorry we do not have "+token);
					break;
				}
				else {
				    EntityTableDisplay td2 = new EntityTableDisplay(searchlist);
				}
				System.out.println("Please choose which things you want to get, type the name below."
						+ "type 'e' if you do not want to buy any things");
				token = sc.nextLine().toLowerCase();
				if (token.equals("e")) {
					break;
				}
				for(int i =0;i< searchlist.getTotalnumber(); i++) {
					if(searchlist.getentityList()[i].getName().toLowerCase().contains(token)) {
						if(searchlist.getentityList()[i].getMoney()<=m.p.getMoney()) {
						    m.p.setMoney(m.p.getMoney() - searchlist.getentityList()[i].getMoney());
						    m.p.enlist.addentity(searchlist.getentityList()[i]);
						    System.out.println("You have bought the "+token);
						    searchlist.clear();
						}
					    else {
					    	System.out.println("player money is "+m.p.getMoney());
							System.out.println("Sorry you do not have enough money.");
							searchlist.clear();
						}
					}
				}
				if(searchlist.getTotalnumber() != 0) {
					System.out.println("Sorry we do not have "+token);
				}
				break;
			case 2:
				AbilityTableList at = new AbilityTableList(m.shop.getAblist());
				System.out.println("Please choose which things you want to get, type the name below."
						+ "type 'e' if you do not want to buy any things");
				String token2 ;
				sc.nextLine();
				token2 = sc.nextLine().toLowerCase();
				if (token2.equals("e")) {
					break;
				}
				AbilityList searchlist2 = new AbilityList();
				for(int i =0;i< searchlist2.getTotalnumber(); i++) {
					if(searchlist2.getAbilitylist()[i].getName().toLowerCase().contains(token2)) {
						if(searchlist2.getAbilitylist()[i].getMoney()<=m.p.getMoney()) {
							AbilityLimiter al = new AbilityLimiter(m.p.ablist);
							if(al.isKeep() == true) {
								return;
							}
						    m.p.setMoney(m.p.getMoney() - searchlist2.getAbilitylist()[i].getMoney());
						    m.p.ablist.addAbility(searchlist2.getAbilitylist()[i]);
						    System.out.println("You have bought the "+token2);
						    searchlist2.clear();
						}
					    else {
					    	System.out.println("player money is "+m.p.getMoney());
							System.out.println("Sorry you do not have enough money.");
							searchlist2.clear();
						}
					}
				}
				if(searchlist2.getTotalnumber() != 0) {
					System.out.println("Sorry we do not have "+token2);
				}
				break;
			case 3:
				if(m.p.getMoney()>=6) {
					m.p.setMoney(m.p.getMoney()-6);
				    m.p.setHealth(m.p.getHealthmax());
				    for(int i = 0;i<m.p.ablist.getTotalnumber();i++) {
				        m.p.ablist.getAbilitylist()[i].setPp(m.p.ablist.getAbilitylist()[i].getMaxpp());
				    }
				System.out.println("Heal finished.");
				break;
				}
				else {
					System.out.println("Sorry your money is "+m.p.getMoney()+"which is not enough for healing.");
					break;
				}
			case 4:
				m.p.setRow(9);
				break;
			}
		} while (temp !=4);
	}
}
