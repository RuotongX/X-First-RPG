package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class BecomeHuge extends Ability {
	public BecomeHuge() {
		super("Become Huge");
		super.setDescription("This ability can improve your attack and defense a lot, which worth 300$");
		super.setAttackboost(1.6);
		super.setdefenseboost(1.6);
		super.setMaxpp(2);
		super.setPp(2);
		super.setMoney(300);
	}
}
