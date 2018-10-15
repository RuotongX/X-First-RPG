package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class Crowbar extends Entity{

	public Crowbar() {
		super("Crow bar");
		super.setAttack(15);
		super.setDescription("This normal gray crowbar can help you improve 15 attack which worth 50 gold.");
		super.setMoney(50);
		}
}
