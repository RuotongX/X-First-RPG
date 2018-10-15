package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class Pan extends Entity{
	public Pan() {
		super("Pan");
		super.setAttack(35);
		super.setDescription("This pan can help you improve 35 attack which worth 200 gold.");
		super.setMoney(200);
	}

}
