package Ability;
import start.*;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class TwoWay extends Ability {

	public TwoWay() {
		super("TwoWay");
		super.setAttackboost(2);
		super.setDefenceboost(1.5);
		super.setMaxpp(5);
		super.setPp(5);
		super.setDescription("This is a skill which can improve your attack and deffence.");
	}
}
