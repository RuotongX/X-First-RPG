package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class ChocolateCake extends Consumable{
	public ChocolateCake() {
		super("Chocolate Cake");
		super.setHealth(20);
		super.setDescription("a chocolate cake");
		super.setMoney(10);
	}

}
