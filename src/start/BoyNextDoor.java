package start;

public class BoyNextDoor {
	public BoyNextDoor(Map map) {
		if (map.m1.isDefeat() == true && map.m2.isDefeat() == true && map.m3.isDefeat() == true) {
			if (map.getFloor() == 0) {
				map.setFloor(1);
				map.display2();
				map.p.setColumn(1);
				map.p.setRow(8);
			} else {
				map.setFloor(0);
				map.p.setColumn(1);
				map.p.setRow(8);
			}
		} else {
			map.p.setColumn(1);
			map.p.setRow(8);
			System.out.println("You have not defeat all of the floor 1 monster, you can not get up to see the boss.");
		}
	}
}
