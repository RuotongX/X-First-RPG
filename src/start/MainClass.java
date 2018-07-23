package start;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		String order;
		Map m = new Map();
		do {
			m.display();
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome warrior, please type your order, W A S D with enter to move.");
			order = sc.nextLine();
			switch (order) {
			case "W":
				m.moveup();
				break;
			case "S":
				m.movedown();
				break;
			case "A":
				m.moveleft();
				break;
			case "D":
				m.moveright();
			}
		} while (!order.equals("0"));
	}
}
