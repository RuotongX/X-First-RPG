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
		super.setDescription("This wooden shield can help you improve 5 defence which worth 20 gold.");
		super.setMoney(20);
	}
}
