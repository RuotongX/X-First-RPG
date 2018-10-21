package Test;

import start.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
/*
 * This is a junit test class, we are doing a RPG game so make palyer move is very important, in this class we test all the four directions(up,down,left,right). It should pass the test 
 * succeddfully.
 * @author Ruotong Xu, Qichchang Zhou
 */
public class MoveDownTest {

	@Test
	public void movedown() {
            
            Map mdt  = new Map();
		//MoveDownTest mdt = new MoveDownTest();
            mdt.setFloor(0);
            mdt.getP().setRow(2);
            mdt.movedown(0);
            int output = mdt.getP().getRow();
            //(3,output);
            Assert.assertEquals(3,output);
	}
        public void moveleft(){
            Map mlt  = new Map();
            mlt.setFloor(0);
            mlt.getP().setColumn(5);
            mlt.moveleft(0);
            int output = mlt.getP().getColumn();
            assertEquals(4,output);
        }
        public void moveup(){
            Map mut = new Map();
            mut.setFloor(0);
            mut.getP().setRow(7);
            mut.moveup(0);
            int output = mut.getP().getRow();
            assertEquals(6,output);
        }
        
     
}
