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
		super.setDescription("a roast beef");
		super.setMoney(100);
	}

}
