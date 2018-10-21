package Test;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import start.Map;
/*
 * This is a junit test class which used for testing while player beside the wall, if the code is correct he can't move inside the wall so he should be stay in the same place.
 * in this test we make the player at lest side wall, if test success means the wall blocked the player.
 * @author Ruotong Xu, Qichchang Zhou
 */


public class WallBlockTest{
        @Test
	public void test() {
		Map wbt = new Map();
		wbt.setFloor(0);
		wbt.getP().setColumn(1);
		wbt.moveleft(0);
		int output = wbt.getP().getColumn();
		assertEquals(1,output);
		
	}

}
