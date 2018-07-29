package start;
import java.util.Scanner;

public class Shopping {
	private enum Type{
		Entity,Ability,Healing;
	}
	public Shopping(Map m) {
		System.out.println("Welcome to cOnutDoWN shop Warrior "+m.p.getName());
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please tell me what you want.");
			System.out.println("1. "+Type.Entity+" 2. "+Type.Ability+" 3. "+Type.Healing);
			int temp = sc.nextInt();
			switch(temp){
			case 1:
				StringBuilder sb = new StringBuilder();
				sb.append("Entity | Price | Description");
				sb.append(System.getProperty("line.separator"));
				for (int i = 0; i < 55; i++) {
					sb.append("-");
				}
				sb.append(System.getProperty("line.separator"));
				for (int i = 0; i < m.shop.getEnlist().getTotalnumber(); i++) {
					sb.append(String.format("%16s|%4s|%33s", m.shop.getEnlist().getentityList()[i].getName(), m.shop.getEnlist().getentityList()[i].getMoney(), m.shop.getEnlist().getentityList()[i].getDescription()));
					sb.append(System.getProperty("line.separator"));
				}
				for (int i = 0; i < 55; i++) {
					sb.append("-");
				}
				sb.toString();
			}
//			StringBuilder sb = new StringBuilder();
//			sb.append("Type | Loop | Closed");
//			sb.append(System.getProperty("line.separator"));
//			for (int i = 0; i < 22; i++) {
//				sb.append("-");
//			}
//			sb.append(System.getProperty("line.separator"));
//			for (int i = 0; i < 10; i++) {
//				sb.append(String.format("%7d|%6d|%7d", (i + 1) * 10, loopTimes[i], closedFormTimes[i]));
//				sb.append(System.getProperty("line.separator"));
//			}
//			for (int i = 0; i < 22; i++) {
//				sb.append("-");
//			}
//			sb.toString();
		} while (true);
	}
}
