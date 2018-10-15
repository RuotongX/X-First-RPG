package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class Axe extends Entity{
	public Axe() {
		super("Axe");
		super.setAttack(55);
		super.setDescription("This axe can help you improve 55 attack which worth 500 gold.");
		super.setMoney(500);
	}

}
