package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class HugeImpact extends Ability{
	public HugeImpact() {
		super("Huge Impact");
		super.setDescription("This is the strongest attack ability in this game, which worth 150$.");
		super.setStrength(1);
		super.setMaxpp(4);
		super.setPp(4);
		super.setMoney(150);
	}
}
