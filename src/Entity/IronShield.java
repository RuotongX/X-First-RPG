package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class IronShield extends Entity{
	public IronShield() {
		super("Iron Shield");
		super.setdefense(10);
		super.setDescription("This iron shield can help you improve 10 defence which worth 100 gold.");
		super.setMoney(100);
		
	}
	

}
