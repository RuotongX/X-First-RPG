/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import database.PlayerDB;
import gui.MapDisplay;
import org.junit.Assert;
import org.junit.Test;
import start.*;

/**
 * This is a junit test class, in this game we designed 3 monsters at ground floor, the player can't go upstairs if he haven't defeated all this three monsters.
 * in this test we set player has already defeated these 3 monsters so the player should go upstairs successfully.
 * @author Ruotong Xu, Qichchang Zhou
 */
public class DoorChangeTest {
    @Test
	public void connecttest() {
            Map m = new Map();
            m.getP().setM1defeat(true);
            m.getP().setM2defeat(true);
            m.getP().setM3defeat(true);
            MapDisplay md = new MapDisplay(m,1);
            BoyNextDoor mdt  = new BoyNextDoor(m,md);
            int floor = m.getFloor();
            Assert.assertEquals(1,floor);
	}

}
