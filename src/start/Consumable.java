package start;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public abstract class Consumable extends Entity{
	
	public Consumable(String name) {
		super(name);
	}

	boolean consumed = false;
	
	public boolean isConsumed() {
		return consumed;
	}

	public void setConsumed() {
		this.consumed = true;
	}
}
