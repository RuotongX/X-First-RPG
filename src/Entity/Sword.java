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
		super.setDescription("An shiny sword");
		super.setMoney(300);		
	}

}
