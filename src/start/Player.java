package start;

public class Player {
	private String name;
	private int level;
	private int money;
	private static int levelmax = 11;
	private int attack;
	private int defence;
	private int health;
	private int healthmax;
	private EntityList enlist;
	private AbilityList ablist;
	private int row = 5;
	private int column = 5;
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
}
