package Ability;
import start.*;

public class Tackle extends Ability {
	public Tackle() {
		super("Tackle");
		super.setStrength(0.35);
		super.setDescription("This is a basic attack ability with a little damage.");
		super.setMaxpp(10);
		super.setPp(10);
	}
}
