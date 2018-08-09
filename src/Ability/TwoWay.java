package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class TwoWay extends Ability {

	public TwoWay() {
		super("TwoWay");
		super.setAttackboost(1.2);
		super.setdefenseboost(1.2);
		super.setMaxpp(5);
		super.setPp(5);
		super.setDescription("This is a skill which can improve your attack and deffence.");
	}
}
