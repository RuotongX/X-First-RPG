package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class Hammer extends Entity{
	public Hammer() {
		super("Hammer");
		super.setAttack(25);
		super.setDescription("This normal hammer can help you improve 25 attack which worth 100 gold.");
		super.setMoney(100);
	}

}
