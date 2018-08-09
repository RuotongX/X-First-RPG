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
		super.setDescription("an normal hammer");
		super.setMoney(100);
	}

}
