package Ability;
import start.*;

public class BecomeHuge extends Ability {
	private int money = 300;
	public BecomeHuge() {
		super("Become Huge");
		super.setDescription("This ability can improve your attack and defence a lot.");
		super.setAttackboost(3.5);
		super.setDefenceboost(2.5);
		super.setPp(2);
		super.setMaxpp(2);
	}
	public int getMoney() {
		return this.money;
	}
}
