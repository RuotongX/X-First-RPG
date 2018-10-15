package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class GoldenShield extends Entity{
	public GoldenShield() {
		super("Golden Shield");
		super.setdefense(30);
		super.setDescription("This golden shield can help you improve 30 defence which worth 300 gold.");
		super.setMoney(300);
	}

}
