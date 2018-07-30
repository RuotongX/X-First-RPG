package Ability;
import start.*;

public class HugeImpact extends Ability{
	private int money = 150;
	public HugeImpact() {
		super("HugeImact");
		super.setDescription("This is the strongest attack ability in this game");
		super.setStrength(1);
		super.setPp(4);
		super.setMaxpp(4);
	}
	public int getMoney() {
		return this.money;
	}
}
