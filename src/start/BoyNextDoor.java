package start;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.MapDisplay;

/**
 * This class is used to ensure the player have defeated all the monsters which are lies in first floor, so that player can go to the 
 * second floor. And also if player want to go floor 1 from floor 2, this class also is been used. 
 * @author RuotongXu QiChangZhou
 *
 */
public class BoyNextDoor {
	public BoyNextDoor(Map map,MapDisplay md) {
		if (map.p.isM1defeat() == true && map.p.isM2defeat() == true && map.p.isM3defeat() == true) {
			if (map.getFloor() == 0) {
				map.setFloor(1);
				map.p.setColumn(1);
				map.p.setRow(8);
				md.setM2(map);
			} else {
				map.setFloor(0);
				map.p.setColumn(1);
				map.p.setRow(8);
				md.setM1(map);
			}
		} else {
			map.p.setColumn(1);
			map.p.setRow(8);
			JOptionPane.showMessageDialog(null,"You have not defeat all of the floor 1 monster, you can not get up to see the boss.","Warning",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
