package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class RoastBeef extends Consumable{
	public RoastBeef() {
		super("Roast Beef");
		super.setHealth(100);
		super.setDescription("This roast beef can help you improve 100 hp which worth 100 gold.");
		super.setMoney(100);
	}

}
