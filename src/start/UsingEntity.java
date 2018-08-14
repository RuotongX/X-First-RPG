package start;
import java.util.Scanner;
/**
 * This class is used when player want to use the entity.
 * @author RuotongXu QiChangZhou
 *
 */
public class UsingEntity {
/**
 * This method is used to show when player used the weapon, the attack will increase,
 * using the for loop to find which entity player used.
 * And also avoid player to equip more than 1 weapon.
 * When player equip another weapon, the previous one will be replaced.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Weapondepender(String a,Player p) {
		int temp = p.getAttack();
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getWeapon() == null) {
    				p.setWeapon(e);
    				System.out.println("You have equip "+e.getName());
    				p.setAttack(p.getAttack()+e.getAttack());
    				System.out.println("Your attack value becomes to "+p.getAttack());
    			}
    			else {
    				p.setAttack(p.getAttack()-p.getWeapon().getAttack());
    				System.out.println("You have take off the "+e.getName() +" and attack reduce "+e.getAttack());
    				p.setWeapon(e);
    				System.out.println("You have equip "+e.getName());
    				p.setAttack(p.getAttack()+e.getAttack());
    				System.out.println("Your attack value becomes to "+p.getAttack());
    				
    			}
    		}
    	}
		if(p.getdefense() == temp) {
			System.out.println("Sorry you do not have this weapon or you current equip this weapon.");
		}
	}
/**
 * This method is used to show when player used the shield, the defense will increase,
 * using the for loop to find which entity player used.
 * And also avoid player to equip more than 1 shield.
 * When player equip another shield, the previous one will be replaced.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Shielddepender(String a,Player p) {
		int temp = p.getdefense();
		for(Entity e :p.enlist.getentityList()) {
    		if(e.getName().toLowerCase().equals(a)) {
    			if(p.getShield() == null) {
    				p.setShield(e);;
    				System.out.println("You have equip "+e.getName());
    				p.setdefense(p.getdefense()+e.getdefense());
    				System.out.println("You defense has increased "+e.getdefense());
    				System.out.println("Your defense value becomes to "+p.getdefense());
    			}
    			else {
    				p.setdefense(p.getdefense()-p.getShield().getdefense());
    				System.out.println("You have take off the "+e.getName() +" and defense reduce "+e.getdefense());
    				p.setShield(e);
    				System.out.println("You have equip "+e.getName());
    				p.setdefense(p.getdefense()+e.getdefense());
    				System.out.println("Your defense value becomes to "+p.getdefense());
    				
    			}
    		}
    	}
		if(p.getdefense() == temp) {
			System.out.println("Sorry you do not have this shield or you current equip this shield.");
		}
	}
/**
 * This method is used when player use the consumable entity,
 * using the for loop to find which entity player used.
 * if player have more than one consumable entity, the quantity of that entity will reduce one,
 * else the entity will disappear after use.
 * If not find the entity system will say sorry you do not have that.
 * @param a
 * @param p
 */
	private void Consumableuse(String a,Player p) {
		double temp = p.getHealth();
		for(int i = 0;i<p.enlist.getTotalnumber();i++) {
			if(p.enlist.getentityList()[i].getName().toLowerCase().equals(a)) {
				System.out.println("You have used the "+p.enlist.getentityList()[i].getName());
				p.setHealth(p.getHealth()+p.enlist.getentityList()[i].getHealth());
				System.out.println("You have healed "+p.enlist.getentityList()[i].getHealth());
				System.out.println("Now you heal is "+p.getHealth());
				if(p.enlist.getentityList()[i].getNum()>1) {
				    p.enlist.removeentityItems(i);
				}
				else {
					p.enlist.getentityList()[i].setNum(p.enlist.getentityList()[i].getNum()-1);
				}
			}
		}
		if(p.getHealth()==temp) {
			System.out.println("Sorry you do not have "+a);
		}
	}
	Scanner sc = new Scanner(System.in);
/**
 * This is a constructor of this class, when call this constructor, it will display the entity list by calling PlayerEntityDisplay class,
 * then player input which entity, I using the switch to depend which type of entity he enter and call the method in this class to implement
 * the entity function.
 * @param p
 */
	public UsingEntity(Player p) {
		System.out.println("You have opened your bag");
	    PlayerEntityDisplay ped = new PlayerEntityDisplay(p.enlist);
	    System.out.println("Please type the name of what you want to use.(Type 'e' go back.");
	    String temp = sc.nextLine().toLowerCase();
	    switch(temp) {
	    case "e":
	    	break;
	    case "axe":
	    	this.Weapondepender("axe", p);
	    	break;
	    case "hammer":
	    	this.Weapondepender("hammer", p);
	    	break;
	    case "pan":
	    	this.Weapondepender("pan", p);
	    	break;
	    case "sword":
	    	this.Weapondepender("sword", p);
	    	break;
	    case "dimond shield":
	    	this.Shielddepender("dimond shield", p);
	    	break;
	    case "golden shield":
	    	this.Shielddepender("golden shield", p);
	    	break;
	    case "iron shield":
	    	this.Shielddepender("iron shield", p);
	    	break;
	    case "silvery shield":
	    	this.Shielddepender("silvery shield", p);
	    	break; 
	    case "wooden shield":
	    	this.Shielddepender("wooden shield", p);
	    	break;
	    case "chicken thigth":
	    	this.Consumableuse("chicken thigth", p);
	    	break;
	    case "chocolate cake":
	    	this.Consumableuse("chocolate cake", p);
	    	break;
	    case "crow bar":
	    	this.Weapondepender("crow bar", p);
	    	break;
	    case "roastbeef":
	    	this.Consumableuse("roastbeef", p);
	    case "pp drink"://coz player have 4 ability so I need to use the switch case to depend which ability that player want to add pp.
	    	for(int i = 0;i<p.enlist.getTotalnumber();i++) {
				if(p.enlist.getentityList()[i].getName().toLowerCase().equals("pp drink")) {
					PlayerAbilityDisplay pad = new PlayerAbilityDisplay(p.ablist);
					System.out.println("Please choose one of the skill");
                    try {
					   int num = sc.nextInt();
					   while(num<1||num>4) {
						   System.out.println("You can only input 1-4 value!");
					   }
					   switch(num) {
						case 1:
							p.ablist.getAbilitylist()[0].setPp(p.ablist.getAbilitylist()[0].getPp()+1);
							System.out.println(p.ablist.getAbilitylist()[0].getName()+" pp + 1!");
						    break;
					   case 2:
						   p.ablist.getAbilitylist()[1].setPp(p.ablist.getAbilitylist()[1].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[1].getName()+" pp + 1!");
						   break;
					   case 3:
						   p.ablist.getAbilitylist()[2].setPp(p.ablist.getAbilitylist()[2].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[2].getName()+" pp + 1!");
						   break;
					   case 4:
						   p.ablist.getAbilitylist()[3].setPp(p.ablist.getAbilitylist()[3].getPp()+1);
						   System.out.println(p.ablist.getAbilitylist()[3].getName()+" pp + 1!");
						   break;
					   }
					   System.out.println("You used 1 pp drink!");
					   p.enlist.removeentityItems(i);
					}catch(Exception e) {
						System.out.println("Invalid input, you will get back to entity list!");
						sc.nextLine();
						return;
					}
			}
	    }
	    	break;
	    }
 }
}
