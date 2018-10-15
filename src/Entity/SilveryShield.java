package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class SilveryShield extends Entity{
	public SilveryShield() {
		super("Silver Shield");
		super.setdefense(20);
		super.setDescription("This silvery shield can help you improve 20 defence which worth 200 gold.");
		super.setMoney(200);
	}

}
