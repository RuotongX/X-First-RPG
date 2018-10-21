/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import database.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import start.*;
/**
 * This is a junit test class, in the class we decided to test our code about database's part, we use database to store our player's name, so in this test we set a name 'Hi' then
 * we store this name into our database, last we call 'getinfo' method to compare with 'Hi', if the name this equal it should pass this test successfully.
 * @author Ruotong Xu, Qichchang Zhou
 */
public class ConnectingTest {
    @Test
	public void connecttest() {
            
            PlayerDB mdt  = new PlayerDB();
            Map m = new Map();
            m.getP().setName("Hi");
            mdt.addinfo(m);
            mdt.getinfo(m);
            String name = m.getP().getName();
            Assert.assertTrue(name.equals("Hi"));
	}
}
