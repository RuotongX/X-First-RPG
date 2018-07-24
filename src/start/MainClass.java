package start;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		String order;
		Map m = new Map();
		System.out.println("Welcome warrior, please type your order, W A S D with enter to move.");
		System.out.println("If you want to escape from this disappointing world just type 0.");
		System.out.println("Recommand fight with the monster on the left top first.");
		System.out.println("For more hits or information please type 1.");
		do {
			if(m.getFloor() == 0) {
			    m.display();
			}
			else {
				m.display2();
			}
			Scanner sc = new Scanner(System.in);
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
				System.out.println("You escape!");
				break;
			case "1":
				System.out.println("After battle if you win you will teleport to the center of the town, if you lose you will teleport near the shop and lose 80 coins.");
				break;
			}
			if(m.p.getRow() == m.m1.getRow() && m.p.getColumn() == m.m2.getColumn()) {
				Battle b = new Battle();
			}
			else if(m.p.getRow() == m.m2.getRow() && m.p.getColumn() == m.m2.getColumn()) {
				Battle b = new Battle();
			}
			else if(m.p.getRow() == m.m3.getRow() && m.p.getColumn() == m.m3.getColumn()) {
				Battle b = new Battle();
			}
			else if(m.p.getRow() == m.shop.getRow() && m.p.getColumn() == m.shop.getColumn()) {
				Shopping s = new Shopping();
			}
			else if(m.p.getRow() == 9 && m.p.getColumn() == 1) {
				BoyNextDoor bnd = new BoyNextDoor(m);
			}
		} while (!order.equals("0"));
	}
}
