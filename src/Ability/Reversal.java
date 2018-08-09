package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class Reversal extends Ability{
	public Reversal() {
		super("Reversal");
		super.setDescription("This incredible ability can heal you one third life for next 3 round");
		super.setHealupbyp(0.3333);
		super.setMaxpp(1);
		super.setPp(1);
		}
}
