package start;

public class PlayerEntityDisplay {
	StringBuilder sb = new StringBuilder();
	public PlayerEntityDisplay(EntityList a) {
		sb.append("         Entity | Quantity | Description");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < a.getTotalnumber(); i++) {
			sb.append(String.format("%16s|%4s|%77s",a.getentityList()[i].getName(),a.getentityList()[i].getNum(),a.getentityList()[i].getDescription()));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 100; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}

}
