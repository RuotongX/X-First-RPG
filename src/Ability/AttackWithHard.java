package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class AttackWithHard extends Ability {
	public AttackWithHard() {
		super("Attack With Hard");
		super.setDescription("This ability can attack a decent damage with improving your defense.");
		super.setStrength(0.5);
		super.setdefenseboost(1.2);
		super.setMaxpp(10);
		super.setPp(10);
		super.setMoney(100);
	}
}
