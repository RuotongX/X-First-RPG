package start;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import Ability.*;
import gui.*;
/**
 * This is our main class, it can read existing file which contains player's record and make player decide
 * continue pre-game or not. Also this class can check does player has the qualification to go upstairs.
 * When player stop this game, all the information will be recored automatically for next time to load this game.
 * @author RuotongXu QiChangZhou
 *
 */
public class MainClass {
	public static void main(String[] args) {
		FileControl fc = new FileControl();
		String order;
		Scanner sc = new Scanner(System.in);
		Map m = new Map();
/**
 * This is using a boolean value to check the player want to use record or not, if true, it will ask loadfile function in filecontrol class.
 */
		System.out.println("Would you like to use the record?(Type true of false.)");
		boolean command =true;
		try
			{
			command= sc.nextBoolean();
			}
		catch(InputMismatchException e) {
			 System.out.println("Invalid input, the system will load the record.");
		}
		if (command == true) {
			try {
				fc.loadfile(m.p);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hey, Warrior, tell me your name :");
			sc.nextLine();
			String name = sc.nextLine();
			m.p.setName(name);
		}
		System.out.println("Welcome " + m.p.getName() + ", please type your order, W A S D with enter to move.");
		System.out.println("Recommand fight with the monster on the left top first.");
		sc.nextLine();
/**
 * This is using a do while loop to keep accept the player input about move the player position. Each move have record the game progress
 * and check the position of the player, if player meet something it will change to the other mode like battle and shopping.
 * The map will generate each times and the monster will be generated too.
 * It also has the switch case function for depend what player want to do except moving.
 */
		do {
			if (m.getFloor() == 0) {
				m.display();
				JFrame mapd = new GuiRunner(m);
				mapd.setVisible(true);
			} else {
				m.display2();
			}
			try {
				order = sc.nextLine().toUpperCase();
				switch (order) {
				case "W":
					m.moveup(m.getFloor());
					break;
				case "S":
					m.movedown(m.getFloor());
					break;
				case "A":
					m.moveleft(m.getFloor());
					break;
				case "D":
					m.moveright(m.getFloor());
					break;
				case "0":
					System.out.println(m.p.getName() + " You escape!");
					break;
				case "1":
					System.out.println(
							"There are many sign on the map, Player is P, Monster is M, Shop is S, Boss is B, Wall is *");
					System.out.println(
							"After battle if you win you will teleport to the center of the town, if you lose you will teleport near the shop and lose 80 coins.");
					break;
				case "B":
					UsingEntity ue = new UsingEntity(m.p);
					break;
				case "2":
					System.out.println("Player State");
					System.out.println("Player Heal: "+m.p.getHealth());
					System.out.println("Player Attack: "+m.p.getAttack());
					System.out.println("Player defense: "+m.p.getdefense());
					if(m.p.getWeapon() == null) {
						System.out.println("No weapon");
					} else {
					    System.out.println("Player weapon: "+m.p.getWeapon().getName());
					}
					if(m.p.getShield() == null) {
						System.out.println("No shield");
					} else {
					    System.out.println("Player shield: "+m.p.getShield().getName());
					}
					System.out.println("Player level: "+m.p.getLevel());
					System.out.println("Player money: "+m.p.getMoney());
					System.out.println("Zombie slain "+m.p.isM1defeat());
					System.out.println("Knight slain "+m.p.isM2defeat());
					System.out.println("Drangon slain "+m.p.isM3defeat());
					PlayerAbilityDisplay pad = new PlayerAbilityDisplay(m.p.ablist);
					sc.nextLine();
					break;
				}
			} catch (Exception e) {
				System.out.println("The input is invalid!");
				return;
			}

			if (m.p.getRow() == m.m1.getRow() && m.p.getColumn() == m.m1.getColumn() && m.getFloor() == 0) {
				Battle b = new Battle(m, m.m1);
			} else if (m.p.getRow() == m.m2.getRow() && m.p.getColumn() == m.m2.getColumn() && m.getFloor() == 0) {
				Battle b = new Battle(m, m.m2);
			} else if (m.p.getRow() == m.m3.getRow() && m.p.getColumn() == m.m3.getColumn() && m.getFloor() == 0) {
				Battle b = new Battle(m, m.m3);
			} else if (m.p.getRow() == m.shop.getRow() && m.p.getColumn() == m.shop.getColumn() && m.getFloor() == 0) {
//				JFrame frame = new ShopGUI(m);
//				frame.setVisible(true);
				Shopping s = new Shopping(m);
			} else if (m.p.getRow() == 9 && m.p.getColumn() == 1) {
				BoyNextDoor bnd = new BoyNextDoor(m);
			} else if (m.p.getRow() == m.boss.getRow() && m.p.getColumn() == m.boss.getColumn() && m.getFloor() == 1) {
				Battle b = new Battle(m, m.boss);
			}
			fc.savefile(m.p);
		} while (!order.equals("0"));
		sc.close();
	}
}
