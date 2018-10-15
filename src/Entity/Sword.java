package Entity;
import start.*;
/**
 * This class just give the basic value to this entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class Sword extends Entity{
	public Sword() {
		super("Sword");
		super.setAttack(45);
		super.setDescription("This shiny sword can help you improve 45 attack which worth 300 gold.");
		super.setMoney(300);		
	}

}
