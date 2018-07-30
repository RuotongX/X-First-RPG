package Ability;
import start.*;

public class AttackWithHard extends Ability {
	private int money;
	public AttackWithHard() {
		super("Attack with hard");
		super.setDescription("This ability can attack a decent damage with improving your defence.");
		super.setStrength(0.5);
		super.setDefenceboost(1.5);
		super.setPp(10);
		this.money = 100;
		super.setMaxpp(10);
	}
	public int getMoney() {
		return money;
	}
}
