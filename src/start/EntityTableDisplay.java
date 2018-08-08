package start;
/**
 * 
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

