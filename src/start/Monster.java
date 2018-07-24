package start;

public class Monster extends Player{
	private boolean defeat = true;
	public boolean isDefeat() {
		return defeat;
	}
	public void setDefeat(boolean defeat) {
		this.defeat = defeat;
	}
}
