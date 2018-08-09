package start;
/**
 * This class is used to display a table for the player's entity list by using the String Builder to format the information.
 * When the other class call this call just call the constructor and the table will display.
 * @author RuotongXu QiChangZhou
 *
 */
public class EntityTableDisplay {
	StringBuilder sb = new StringBuilder();
	public EntityTableDisplay(EntityList e) {
		sb.append("         Entity |Price| Description");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < e.getTotalnumber(); i++) {
			sb.append(String.format("%16s|%5s|%77s",e.getentityList()[i].getName(),e.getentityList()[i].getMoney(),e.getentityList()[i].getDescription()));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}

