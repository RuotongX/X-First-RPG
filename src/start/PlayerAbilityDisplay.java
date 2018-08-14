package start;
/**
 * This class is used to display a table for the player's ability list by using the String Builder to format the information.
 * When the other class call this call just call the constructor and the table will display.
 * @author RuotongXu QiChangZhou
 *
 */
public class PlayerAbilityDisplay {
	StringBuilder sb = new StringBuilder();
	public PlayerAbilityDisplay(AbilityList a) {
		sb.append("         Entity | PP | Description");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < a.getTotalnumber(); i++) {
			sb.append(String.format("%16s|%4s|%77s",a.getAbilitylist()[i].getName(),a.getAbilitylist()[i].getPp(),a.getAbilitylist()[i].getDescription()+" Strength is "+a.getAbilitylist()[i].getStrength()*100));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}
