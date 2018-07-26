package start;

public abstract class Consumable extends Entity{
	
	boolean consumed = false;
	
	public boolean isConsumed() {
		return consumed;
	}

	public void setConsumed() {
		this.consumed = true;
	}
}
