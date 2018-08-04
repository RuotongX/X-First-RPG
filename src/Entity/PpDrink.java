package Entity;
import start.*;

public class PpDrink extends Consumable {
	public PpDrink() {
		super("PP drink");
		super.setMoney(30);
		super.setPp(1);
		super.setDescription("This is the potion which can improve the pp once time for any ability." );
	}
}
