package start;

public class PpPotion extends Consumable {
	public PpPotion() {
		super("PP Potion");
		super.setMoney(30);
		super.setPp(1);
		super.setDescription("This is the potion which can improve the pp once time for any ability." );
	}
}
