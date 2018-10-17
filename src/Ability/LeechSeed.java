package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class LeechSeed extends Ability {
	public LeechSeed() {
		super("Leech Seed");
		super.setDescription("This ability can make the enemy keep losing max health 1/6 and heal your self for 3 round, which worth 200$.");
		super.setPercentagehit(0.16667);
		super.setMaxpp(1);
		super.setPp(1);
		super.setMoney(200);
	}
}
