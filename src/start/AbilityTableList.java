package start;
/**
 * This class is used to display a table for the player's ability list by using the String Builder to format the information.
 * When the other class call this call just call the constructor and the table will display.
 * @author RuotongXu QiChangZhou
 *
 */
public class AbilityTableList {
	StringBuilder sb = new StringBuilder();
	public AbilityTableList(AbilityList a) {
		sb.append("         Entity |Price| Description");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 80; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < a.getTotalnumber(); i++) {
			sb.append(String.format("%16s|%5s|%57s",a.getAbilitylist()[i].getName(),a.getAbilitylist()[i].getMoney(),a.getAbilitylist()[i].getDescription()));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 80; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}
