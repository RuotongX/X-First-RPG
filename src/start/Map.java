package start;
import java.util.Random;
import Ability.*;
/**
 * This class show all the monsters in the map and control player's move.
 * Besides when player play this game, it will show some basic information at the right
 * of the map.
 * @author RuotongXu QiChangZhou
 *
 */
public class Map{
	private static int rowMax = 11;
	private static int columnMax = 12;
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
public Player getP() {
		return p;
	}
	public Shop getShop() {
		return shop;
	}
/**
 * This method is used to generate player, give the basic value to player.
 */
	private void PlayerGenerator() {
		p.setExp(0);
		p.setHealthmax(100);
		p.setHealth(100);
		p.setAttack(35);
		p.setdefense(5);
		p.setLevel(1);
		p.setMoney(0);
		p.setTempattack(p.getAttack());
		Tackle tackle = new Tackle();
		p.ablist.addAbility(tackle);
	}
	/**
	 * This method is used to generate monster, give the basic value to player.
	 */
	private void MonsterGenerator() {
		m1.setRow(2);
		m1.setColumn(2);
		m1.setAttack(10);
		m1.setdefense(5);
		m1.setHealthmax(25);
		m1.setHealth(25);
		m1.setExp(10);
		m1.setLevel(1);
		m1.setMoney(rand.nextInt(9) + 6);
		m1.setName("Zombie");
		m2.setRow(2);
		m2.setColumn(8);
		m2.setAttack(40);
		m2.setdefense(20);
		m2.setHealthmax(50);
		m2.setHealth(50);
		m2.setExp(30);
		m2.setLevel(4);
		m2.setMoney(rand.nextInt(15)+12);
		m2.setName("Knight");
		m3.setRow(9);
		m3.setColumn(5);
		m3.setAttack(60);
		m3.setdefense(30);
		m3.setHealthmax(90);
		m3.setHealth(90);
		m3.setExp(50);
		m3.setLevel(7);
		m3.setMoney(rand.nextInt(30)+25);
		m3.setName("Dragon");
	}
	/**
	 * This method is used to generate monster, give the basic value to player.
	 */
	private void BossGenerator() {
		boss.setRow(8);
		boss.setColumn(5);
		boss.setAttack(100);
		boss.setdefense(80);
		boss.setHealthmax(200);
		boss.setHealth(200.00);
		boss.setLevel(10);
		boss.setExp(400);
		boss.setMoney(214748364);
		boss.setName("Demon");
	}
	/**
	 * This method is to create a shop by give the basic position value.
	 */
	private void ShopGenerator() {
	    shop.setRow(8);
	    shop.setColumn(8);
	}
/**
 * The method to set player position.
 * @param floor
 */
	public void moveup(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow() - 1, p.getColumn());
		} else {
			p.positionControler2(p.getRow() - 1, p.getColumn());
		}
	}
	/**
	 * The method to set player position.
	 * @param floor
	 */
	public void movedown(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow() + 1, p.getColumn());
		} else {
			p.positionControler2(p.getRow() + 1, p.getColumn());
		}
	}
	/**
	 * The method to set player position.
	 * @param floor
	 */
	public void moveright(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow(), p.getColumn() + 1);
		} else {
			p.positionControler2(p.getRow(), p.getColumn() + 1);
		}
	}
	/**
	 * The method to set player position.
	 * @param floor
	 */
	public void moveleft(int floor) {
		if (floor == 0) {
			p.positionControler1(p.getRow(), p.getColumn() - 1);
		} else {
			p.positionControler2(p.getRow(), p.getColumn() - 1);
		}
	}
	/**
	 * get set method for floor.
	 * @return
	 */
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	/**
	 * This method is use the double for loop to display what the map details, each element has different sign, which will be define in this method
	 * this method is use to display the map in level 1
	 */
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
					map[i][j][floor] = "1";
				}
				else if(i == m2.getRow() && j == m2.getColumn()) {
					map[i][j][floor] = "2";
				}
				else if(i == m3.getRow() && j == m3.getColumn()) {
					map[i][j][floor] = "3";
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
				map[1][11][floor] = "     Map information";
				map[2][11][floor] = "     'P' is player, 'M' is monster, 'S' is shop, 'D' is door, '*' is wall, 'B' is boss.";
				map[3][11][floor] = "     If you want to escape from this disappointing world just type 0.";
				map[4][11][floor] = "     For more hits or information please type 1.";
				map[5][11][floor] = "     To check player states please type '2'";
				map[6][11][floor] = "     To check you bag please type 'b'";
				map[7][11][floor] = "     Player heals "+p.getHealth();
				map[8][11][floor] = "     Player level "+p.getLevel();
				map[0][11][floor] = "";
				map[10][11][floor] = "";
				System.out.print(map[i][j][floor]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * This method is use the double for loop to display what the map details, each element has different sign, which will be define in this method
	 * this method is use to display the map in level 2.
	 */
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
				map[1][11][floor] = "     Map information";
				map[2][11][floor] = "     'P' is player, 'M' is monster, 'S' is shop, 'D' is door, '*' is wall, 'B' is boss.";
				map[3][11][floor] = "     If you want to escape from this disappointing world just type 0.";
				map[4][11][floor] = "     For more hits or information please type 1.";
				map[5][11][floor] = "     To check player states please type '2'";
				map[6][11][floor] = "     To check you bag please type 'b'";
				map[7][11][floor] = "     Player heals "+p.getHealth();
				map[8][11][floor] = "     Player level "+p.getLevel();
				map[0][11][floor] = "";
				map[10][11][floor] = "";
				System.out.print(map[i][j][floor]+" ");
			}
			System.out.println();
			}
		}	
	/**
	 * The constructor of the map class which will initialise the player and shop.
	 */
	public Map() {
		this.PlayerGenerator();
		this.ShopGenerator();
	}
	public static String[][][] getMap() {
		return map;
	}	
}

