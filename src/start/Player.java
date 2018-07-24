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

	public void positionControler1(int row,int column) {
			if (column == 0 || column == 10) {
				this.column = this.getColumn();
				this.row = this.getRow();
			} else if (row < 3 && row > 0 && column == 5) {
				this.column = this.getColumn();
				this.row = this.getRow();
			} else if (row < 10 && row > 6 && column == 2) {
				this.column = this.getColumn();
				this.row = this.getRow();
			} else if (row > 3 && row < 9 && column == 7) {
				this.column = this.getColumn();
				this.row = this.getRow();
			} else if (row == 6 && column > 7 && column < 10) {
				this.column = this.getColumn();
				this.row = this.getRow();
			} else {
				this.column = column;
				this.row = row;
			}
	}
	public void positionControler2(int row,int column) {
		if(row == 0||column == 0||row== 10||column == 10) {
			this.column = this.getColumn();
			this.row = this.getRow();
	    }
	    else if(column < 5 && row == 4) {
	    	this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(column > 5 && row == 4) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row < 4 && column == 4) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row < 4 && column == 6) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row > 5 && column == 2) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row > 5 && column == 8) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row == 6 && column > 1 && column < 5) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else if(row == 6 && column < 9 && column > 5) {
			this.column = this.getColumn();
			this.row = this.getRow();
		}
		else {
			this.column = column;
			this.row = row;
		}
	}
}
