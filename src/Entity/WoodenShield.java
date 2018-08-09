package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class WoodenShield extends Entity{
	public WoodenShield() {
		super("Wooden Shield");
		super.setdefense(5);
		super.setDescription("a wooden shield");
		super.setMoney(20);
	}
}
