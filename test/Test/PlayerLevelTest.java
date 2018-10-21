package Test;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import start.*;
/*
 * This is a junit test class, in this game when user star to play it, all the player shoud be set at Lv1, so we need to test is our code can set player's Lv successfully.
 * @author Ruotong Xu, Qichchang Zhou
 */
public class PlayerLevelTest{

        @Test
	public void test() {
		Player plt = new Player();
		plt.setLevel(1);
		int output = plt.getLevel();
		assertEquals(1,output);
	}

}
