/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import start.*;
import Entity.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
/*
 * This is a junit test class, in our game player could buy items in the shop by doing this, all the item information should be in our 'check entity' function. So this test is to 
 * test either we can store item iinformaiton or not. So we try to add a weapon(axe), if the code work properly it will pass the test successfully.
 * @author Ruotong Xu, Qichchang Zhou
 */
public class EntityTest {
    @Test
	public void entitylisttest() {
            
            EntityList mdt  = new EntityList();
            Axe a = new Axe();
		//MoveDownTest mdt = new MoveDownTest();
            mdt.addentity(a);
            int output = mdt.getTotalnumber();
            //(3,output);
            Assert.assertEquals(1,output);
	}
}
