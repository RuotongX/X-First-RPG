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
		super.setDescription("This chocolate cake can help you improve 20 hp which worth 10 gold.");
		super.setMoney(10);
	}

}
