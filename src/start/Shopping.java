package start;

import java.util.Scanner;

import Ability.AbilityLimiter;

public class Shopping {
	private enum Type {
		Entity, Ability, Healing, goback;
	}

	public Shopping(Map m) {
		System.out.println("Welcome to CoNuTDoWn shop Warrior " + m.p.getName());
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		do {
			System.out.println("Please tell me what you want.");
			System.out.println("1. " + Type.Entity + " 2. " + Type.Ability + " 3. " + Type.Healing
					+ "(costs 6 dollors) 4. " + Type.goback);
			try {
				temp = sc.nextInt();
				if (temp > 4) {
					temp = 4;
				}
			} catch (Exception e) {

				System.out.println("You must input a number less or equal than 4. You are kicked out from our shop!!");
				temp = 4;
			}
			switch (temp) {
			case 1:
				EntityTableDisplay td1 = new EntityTableDisplay(m.shop.getEnlist());
				System.out.println(
						"Type the name which you want, the result will search from the entity name and description."
								+ "type 'e' if you do not want to buy any things");
				String token;
				sc.nextLine();
				token = sc.nextLine().toLowerCase();
				if (token.equals("e")) {
					break;
				}
				EntityList searchlist = new EntityList();
				for (int i = 0; i < m.shop.getEnlist().getTotalnumber(); i++) {
					if (m.shop.getEnlist().getentityList()[i].getName().contains(token)
							|| m.shop.getEnlist().getentityList()[i].getDescription().toLowerCase().contains(token)) {
						searchlist.addentity(m.shop.getEnlist().getentityList()[i]);
					}
				}
				if (searchlist.getTotalnumber() == 0 && (temp == 0)) {
					System.out.println("Sorry we do not have " + token);
					break;
				} else {
					EntityTableDisplay td2 = new EntityTableDisplay(searchlist);
				}

				System.out.println("Please choose which things you want to get, type the name below."
						+ "Otherwise you will back to main menu!");
				String input = sc.nextLine().toLowerCase();
				if (input.equals("e")) {
					break;
				}
				for (int i = 0; i < searchlist.getTotalnumber(); i++) {
					while (input.equals(searchlist.getentityList()[i].getName().toLowerCase())) {
						if (searchlist.getentityList()[i].getName().toLowerCase().contains(token)) {
							if (searchlist.getentityList()[i].getMoney() <= m.p.getMoney()) {
								m.p.setMoney(m.p.getMoney() - searchlist.getentityList()[i].getMoney());
								if (m.p.enlist.hasEntity(searchlist.getentityList()[i])) {

									for (int j = 0; j < m.p.enlist.getTotalnumber(); j++) {
										if (m.p.enlist.getentityList()[j].getName().toLowerCase().equals(token)) {
											m.p.enlist.getentityList()[j].setNum(m.p.enlist.getentityList()[j].getNum());
										} 
									}
								}
									else {
										m.p.enlist.addentity(searchlist.getentityList()[i]);
									}

								}
								System.out.println("You have bought the " + input + ".Now back to main menu.");
								searchlist.clear();
								break;
							} else {
								System.out.println("player money is " + m.p.getMoney());
								System.out.println("Sorry you do not have enough money!Back to main menu");
								searchlist.clear();
								break;
							}
						}
					}

				
				break;

			case 2:
				AbilityTableList at = new AbilityTableList(m.shop.getAblist());
				System.out.println("Please choose which things you want to get, type the name below."
						+ "Otherwise you will back to main menu.");
				String token2;
				sc.nextLine();
				token2 = sc.nextLine().toLowerCase();
				for (int i = 0; i < m.shop.getAblist().getTotalnumber(); i++) {
					if (m.shop.getAblist().getAbilitylist()[i].getName().toLowerCase().equals(token2)) {
						if (m.shop.getAblist().getAbilitylist()[i].getMoney() <= m.p.getMoney()) {
							AbilityLimiter al = new AbilityLimiter(m.p.ablist);
							if (al.isKeep() == true) {
								return;
							}
							m.p.setMoney(m.p.getMoney() - m.shop.getAblist().getAbilitylist()[i].getMoney());
							m.p.ablist.addAbility(m.shop.getAblist().getAbilitylist()[i]);
							System.out.println("You have bought the " + token2);
							break;
						} else {
							System.out.println("player money is " + m.p.getMoney());
							System.out.println("Sorry you do not have enough money.");
						}
					} else if (token2.equals("e")) {
						break;
					}

				}
				break;
			case 3:
				if (m.p.getMoney() >= 6) {
					m.p.setMoney(m.p.getMoney() - 6);
					m.p.setHealth(m.p.getHealthmax());
					for (int i = 0; i < m.p.ablist.getTotalnumber(); i++) {
						m.p.ablist.getAbilitylist()[i].setPp(m.p.ablist.getAbilitylist()[i].getMaxpp());
					}
					System.out.println("Heal finished.");
					break;
				} else {
					System.out.println("Sorry your money is " + m.p.getMoney() + " you can't get healed.");
					break;
				}
			case 4:
				m.p.setRow(9);
				break;
			}
		} while (temp != 4);
	}
}
