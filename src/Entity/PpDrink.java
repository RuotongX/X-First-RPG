package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class PpDrink extends Consumable {
	public PpDrink() {
		super("PP drink");
		super.setMoney(30);
		super.setPp(1);
		super.setDescription("This potion can help you improve once usage for any ability which worth 30 gold." );
	}
}
