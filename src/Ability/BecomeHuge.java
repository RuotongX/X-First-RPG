package Ability;
import start.*;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class BecomeHuge extends Ability {
	public BecomeHuge() {
		super("Become Huge");
		super.setDescription("This ability can improve your attack and defense a lot.");
		super.setAttackboost(3.5);
		super.setdefenseboost(2.5);
		super.setMaxpp(2);
		super.setPp(2);
		super.setMoney(300);
	}
}
