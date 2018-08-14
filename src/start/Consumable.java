package start;
/**
 * This class is used to specific the type of entity. The consumable entity has the consume attribute.
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
