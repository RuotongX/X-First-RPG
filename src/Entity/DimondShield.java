package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class DimondShield extends Entity{
	public DimondShield() {
		super("Dimond Shield");
		super.setdefense(50);
		super.setDescription("This dimond shield can help you improve 50 defence which worth 500 gold.");
		super.setMoney(500);
	}

}
