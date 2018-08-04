package Ability;
import start.*;

public class AttackWithHard extends Ability {
	public AttackWithHard() {
		super("Attackwithhard");
		super.setDescription("This ability can attack a decent damage with improving your defence.");
		super.setStrength(0.5);
		super.setDefenceboost(1.5);
		super.setMaxpp(10);
		super.setPp(10);
		super.setMoney(100);
	}
}
