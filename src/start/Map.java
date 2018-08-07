package start;
import java.util.Random;
import Ability.*;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class Map {
	private static int rowMax = 11;
	private static int columnMax = 11;
	private int floor = 0;
	private static int level = 2;
	private static String[][][] map = new String [rowMax][columnMax][level];
	Random rand = new Random();
	Player p = new Player();
	Monster m1 = new Monster();
	Monster m2 = new Monster();
	Monster m3 = new Monster();
	Monster boss = new Monster();
	Shop shop = new Shop();
	private void PlayerGenerator() {
		p.setExp(0);
		p.setHealthmax(100);
		p.setHealth(100);
		p.setAttack(35);
		p.setDefence(5);
		p.setLevel(1);
		p.setMoney(0);
		p.setTempattack(p.getAttack());
		Tackle tackle = new Tackle();
		p.ablist.addAbility(tackle);
	}
	private void MonsterGenerator() {
		m1.setRow(2);
		m1.setColumn(2);
		m1.setAttack(10);
		m1.setDefence(5);
		m1.setHealthmax(25);
		m1.setHealth(25);
		m1.setExp(10);
		m1.setLevel(1);
		m1.setMoney(rand.nextInt(9) + 6);
		m1.setName("Zombie");
		m2.setRow(2);
		m2.setColumn(8);
		m2.setAttack(40);
		m2.setDefence(20);
		m2.setHealthmax(50);
		m2.setHealth(50);
		m2.setExp(30);
		m2.setLevel(4);
		m2.setMoney(rand.nextInt(15)+12);
		m2.setName("Knight");
		m3.setRow(9);
		m3.setColumn(5);
		m3.setAttack(60);
		m3.setDefence(30);
		m3.setHealthmax(90);
		m3.setHealth(90);
		m3.setExp(50);
		m3.setLevel(7);
		m3.setMoney(rand.nextInt(30)+25);
		m3.setName("Dragon");
	}
	private void BossGenerator() {
		boss.setRow(8);
		boss.setColumn(5);
		boss.setAttack(100);
		boss.setDefence(80);
		boss.setHealthmax(200);
		boss.setHealth(200.00);
		boss.setLevel(10);
		boss.setExp(400);
		boss.setMoney(214748364);
		boss.setName("Demon");
	}
	private void ShopGenerator() {
	    shop.setRow(8);
	    shop.setColumn(8);
	}

	public void moveup(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow() - 1, p.getColumn());
		} else {
			p.positionControler2(p.getRow() - 1, p.getColumn());
		}
	}

	public void movedown(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow() + 1, p.getColumn());
		} else {
			p.positionControler2(p.getRow() + 1, p.getColumn());
		}
	}

	public void moveright(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow(), p.getColumn() + 1);
		} else {
			p.positionControler2(p.getRow(), p.getColumn() + 1);
		}
	}

	public void moveleft(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow(), p.getColumn() - 1);
		} else {
			p.positionControler2(p.getRow(), p.getColumn() - 1);
		}
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public void display() {
		this.MonsterGenerator();
		for(int i = 0;i<rowMax; i++) {
			for(int j = 0;j<columnMax; j++) {
				if(i == 0||j == 0||i== 10||j == 10) {
					map[i][j][floor] = "*";
			    }
				else if(i < 3 && i > 0 && j == 5) {
					map[i][j][floor] = "*";
				}
				else if(i < 10 && i > 6 && j == 2) {
					map[i][j][floor] = "*";
				}
				else if(i > 3 && i < 9 && j == 7) {
					map[i][j][floor] = "*";
				}
				else if(i == 6 && j > 7 && j < 10) {
					map[i][j][floor] = "*";
				}
				else if(i == m1.getRow() && j == m1.getColumn()) {
					map[i][j][floor] = "M";
				}
				else if(i == m2.getRow() && j == m2.getColumn()) {
					map[i][j][floor] = "M";
				}
				else if(i == m3.getRow() && j == m3.getColumn()) {
					map[i][j][floor] = "M";
				}
				else if(i == 9 && j == 1) {
					map[i][j][floor] = "D";
				}
				else if(i == shop.getRow() && j == shop.getColumn()) {
					map[i][j][floor] = "S";
				}
				else if(i==p.getRow() && j == p.getColumn()) {
					map[i][j][floor] = "P" ;
				}
				else {
					map[i][j][floor] = " ";
				}
				System.out.print(map[i][j][floor]+" ");
			}
			System.out.println();
		}
	}
	public void display2() {
		this.BossGenerator();
		for(int i = 0;i<rowMax; i++) {
			for(int j = 0;j<columnMax; j++) {
				if(i == 0||j == 0||i== 10||j == 10) {
					map[i][j][floor] = "*";
			    }
			    else if(j < 5 && i == 4) {
					map[i][j][floor] = "*";
				}
				else if(j > 5 && i == 4) {
					map[i][j][floor] = "*";
				}
				else if(i < 4 && j == 4) {
					map[i][j][floor] = "*";
				}
				else if(i < 4 && j == 6) {
					map[i][j][floor] = "*";
				}
				else if(i > 5 && j == 2) {
					map[i][j][floor] = "*";
				}
				else if(i > 5 && j == 8) {
					map[i][j][floor] = "*";
				}
				else if(i == 6 && j > 1 && j < 5) {
					map[i][j][floor] = "*";
				}
				else if(i == 6 && j < 9 && j > 5) {
					map[i][j][floor] = "*";
				}
				else if(i == p.getRow() && j == p.getColumn()) {
					map[i][j][floor] = "P";
				}
				else if(i == 9 && j == 1) {
					map[i][j][floor] = "D";
				}
				else if(i == boss.getRow() && j == boss.getColumn()) {
					map[i][j][floor] = "B";
				}
				else {
					map[i][j][floor] = " ";
				}
				System.out.print(map[i][j][floor]+" ");
			}
			System.out.println();
			}
		}	
	public Map() {
		this.PlayerGenerator();
		this.ShopGenerator();
	}
}

