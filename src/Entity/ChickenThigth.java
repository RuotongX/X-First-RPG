package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class ChickenThigth extends Consumable{
	public ChickenThigth() {
		super("Chinken Thigth");
		super.setHealth(50);
		super.setDescription("This chicken thigth can help you improve 50 hp which worth 50 gold.");
		super.setMoney(50);
	}

}
