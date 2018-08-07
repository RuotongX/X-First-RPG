package start;

public class Player {
	private String name;
	private int level;
	private int money;
	private double exp;
	private static int levelmax = 11;
	private int attack;
	private int defence;
	private double tempattack;
	private double health;
	private int healthmax;
	public EntityList enlist = new EntityList();
	public AbilityList ablist = new AbilityList();
	private int row = 5;
	private int column = 5;
	private Entity weapon;
	private Entity shield;
	
	private boolean m1defeat = false;
	private boolean m2defeat = false;
	private boolean m3defeat = false;
	

	public boolean isM1defeat() {
		return m1defeat;
	}

	public void setM1defeat(boolean m1defeat) {
		this.m1defeat = m1defeat;
	}

	public boolean isM2defeat() {
		return m2defeat;
	}

	public void setM2defeat(boolean m2defeat) {
		this.m2defeat = m2defeat;
	}

	public boolean isM3defeat() {
		return m3defeat;
	}

	public void setM3defeat(boolean m3defeat) {
		this.m3defeat = m3defeat;
	}

	public Entity getWeapon() {
		return weapon;
	}

	public void setWeapon(Entity weapon) {
		this.weapon = weapon;
	}
	
	public Entity getShield() {
		return shield;
	}

	public void setShield(Entity shield) {
		this.shield = shield;
	}

	public static int getLevelmax() {
		return levelmax;
	}

	public double getTempattack() {
		return tempattack;
	}

	public void setTempattack(double tempattack) {
		this.tempattack = tempattack;
	}

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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double d) {
		if(d>=this.healthmax) {
			this.health = this.healthmax;
		}
		else {
		    this.health = d;
		}
	}

	public int getHealthmax() {
		return healthmax;
	}

	public void setHealthmax(int healthmax) {
		this.healthmax = healthmax;
	}

	public void positionControler1(int row,int column) {
			if (column == 0 || column == 10) {
				this.column = this.getColumn();
				this.row = this.getRow();
			}
			else if(row == 0 || row == 10) {
				this.column = this.getColumn();
				this.row = this.getRow();
			}
			else if (row < 3 && row > 0 && column == 5) {
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
