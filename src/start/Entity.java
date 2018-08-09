package start;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public abstract class Entity {
	private int health;
	private double exp;
	private int attack;
	private int defense;
	private int money;
	private String name;
	private String description;
	private int pp;
	private int num = 1;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
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
	public int getdefense() {
		return defense;
	}
	public void setdefense(int defense) {
		this.defense = defense;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Entity(String name) {
		this.name = name;
	}
}
