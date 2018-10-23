package start;
import java.io.FileNotFoundException;

import java.io.PrintWriter;


import java.util.Scanner;

import Ability.AbilityLimiter;
import Ability.AttackWithHard;
import Ability.BecomeHuge;
import Ability.HugeImpact;
import Ability.LeechSeed;
import Ability.Reversal;
import Ability.Smash;
import Ability.Tackle;
import Ability.TwoWay;
import Entity.Axe;
import Entity.ChickenThigth;
import Entity.ChocolateCake;
import Entity.Crowbar;
import Entity.DimondShield;
import Entity.GoldenShield;
import Entity.Hammer;
import Entity.IronShield;
import Entity.Pan;
import Entity.PpDrink;
import Entity.RoastBeef;
import Entity.SilveryShield;
import Entity.Sword;
import Entity.WoodenShield;

import java.io.File;
/**
 * This class is the file io, when the player want to save or load game progress system will call this class,
 * first I create all abilities and entities instance in this class, so that its easy to load the player abilities and entities.
 * @author RuotongXu QiChangZhou
 *
 */
public class FileControl {
	private static EntityList enlist = new EntityList();
	private static AbilityList ablist = new AbilityList();
	private Axe axe = new Axe();
	private ChickenThigth ct = new ChickenThigth();
	private ChocolateCake cc = new ChocolateCake();
	private Crowbar crowbar = new Crowbar();
	private DimondShield ds = new DimondShield();
	private GoldenShield gs = new GoldenShield();
	private Hammer hammer = new Hammer();
	private IronShield is = new IronShield();
	private Pan pan = new Pan();
	private PpDrink pp = new PpDrink();
	private RoastBeef rb = new RoastBeef();
	private SilveryShield ss = new SilveryShield();
	private Sword sword = new Sword();
	private WoodenShield ws = new WoodenShield();
	private AttackWithHard awh = new AttackWithHard();
	private BecomeHuge bh = new BecomeHuge();
	private HugeImpact hi = new HugeImpact();
	private LeechSeed ls = new LeechSeed();
	private TwoWay twoway = new TwoWay();
	private Smash smash = new Smash();
	private Reversal reversal = new Reversal();
	private Tackle tackle = new Tackle();
/**
 * This method is to save the player data to a txt file, when store the list, it used the for loop to get each object in that list,
 * I also create the method in arraylist class which can transfer the arraylist to array so that easy to read and write.
 * @param p
 */
	public static void savefile(Player p) {
		try {
			
		   try(PrintWriter fileWriter = new PrintWriter(new File("playerdata/data.txt"))){
			   fileWriter.println(p.getName());
			   fileWriter.println(p.getAttack());
			   fileWriter.println(p.getdefense());
			   fileWriter.println(p.getLevel());
			   fileWriter.println(p.getHealthmax());
			   fileWriter.println(p.getHealth());
			   fileWriter.println(p.getMoney());
			   fileWriter.println(p.getRow());
			   fileWriter.println(p.getColumn());
			   fileWriter.println(p.isM1defeat());
			   fileWriter.println(p.isM2defeat());
			   fileWriter.println(p.isM3defeat());
			   fileWriter.println(p.getExp());
			   if(p.getWeapon() == null) {
				   fileWriter.println("null");
			   }
			   else {
			       fileWriter.println(p.getWeapon().getName());
			   }
			   if(p.getShield() == null) {
				   fileWriter.println("null");
			   }
			   else {
			       fileWriter.println(p.getShield().getName());
			   }
			   fileWriter.println(p.ablist.getTotalnumber());//write how many ability that player have.
			   for (Ability a : p.ablist.getAbilitylist()) {
				   fileWriter.println(a.getName());
				   fileWriter.println(a.getPp());
			   }
			   fileWriter.println(p.enlist.getTotalnumber());//write how many entity that player have.
			   for (Entity e : p.enlist.getentityList()) {
			       fileWriter.println(e.getName());
			       fileWriter.println(e.getNum());
			   }
			   fileWriter.close();
		   }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/**
 * This method is used to load the txt file and read the player information into the game,
 * it read the entity's or ability's name and number, then set for player's attributes.
 * @param p
 * @throws FileNotFoundException
 */
	public static void loadfile(Player p) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File("playerdata/data.txt"));
		try {
			 String line = fileScan.nextLine();
			 p.setName(line);
			 int value = fileScan.nextInt();
			 p.setAttack(value);
			 value = fileScan.nextInt();
			 p.setdefense(value);
			 value = fileScan.nextInt();
			 p.setLevel(value);
			 value = fileScan.nextInt();
			 p.setHealthmax(value);
			 double v2 = fileScan.nextDouble();
			 p.setHealth(v2);
			 value = fileScan.nextInt();
			 p.setMoney(value);
			 value = fileScan.nextInt();
			 p.setRow(value);
			 value = fileScan.nextInt();
			 p.setColumn(value);
			 boolean b = fileScan.nextBoolean();
			 p.setM1defeat(b);
			 b = fileScan.nextBoolean();
			 p.setM2defeat(b);
			 b = fileScan.nextBoolean();
			 p.setM3defeat(b);
			 v2 = fileScan.nextDouble();
			 p.setExp(v2);
			 fileScan.nextLine();
			 line = fileScan.nextLine();
			 for(Entity e : enlist.getentityList()) {//used for loop to find the player weapen in the total list.
				 if(e.getName().equals(line)) {
					 p.setWeapon(e);
				 }
			 }
			line = fileScan.nextLine();
			for(Entity e : enlist.getentityList()) {//used for loop to find the player shield in the total list.
				 if(e.getName().equals(line)) {
					 p.setShield(e);
				 }
			 }
//			fileScan.nextLine();
			int valuep = fileScan.nextInt();//read how many abilities that player has.
			for(int i = 0;i<valuep;i++) {//used the for loop to read each information that a attribute has(actually it just has the name and pp number)
				fileScan.nextLine();
				line = fileScan.nextLine();
				value = fileScan.nextInt();
				for(Ability a:ablist.getAbilitylist()) {//This for loop is used to find this entity in the total list in this class.
					if(a.getName().equals(line)) {
						if(line.equals("Tackle")) {
							for(Ability a2:p.ablist.getAbilitylist()) {
								if(a2.getName().equals("Tackle")) {//Because player always has tackle so it avoid player learn this ability again.
									a2.setPp(value);
								}
							}
						}
						else {
							AbilityLimiter al = new AbilityLimiter(p.ablist);
							if(al.AvoidDupulicate(p, a)) {
							} else
								p.ablist.addAbility(a);
						   
						   for(Ability a3:p.ablist.getAbilitylist()) {
							   if(a3.getName().equals(line)) {
								   a3.setPp(value);
							   }
						   }
						}
						
					}
				}
                                if(p.ablist.getTotalnumber()==5){
                                    p.ablist.removeAbility(0);
                                }
			}
			int valuee = fileScan.nextInt();//read how many entities that player has.
			for(int i = 0;i<valuee;i++) {//used the for loop to read each information that a entity has(actually it just has the name and quantity number)
				fileScan.nextLine();
				line = fileScan.nextLine();
				value = fileScan.nextInt();
				for(Entity e : enlist.getentityList()) {//This for loop is used to find this entity in the total list in this class.
					if(e.getName().equals(line)) {
						p.enlist.addentity(e);
						for(Entity e2:p.enlist.getentityList()) {
							   if(e2.getName().equals(line)) {
								   e2.setNum(value);
							   }
						   }
					}
				}
			}
			 fileScan.close();
		} catch(Exception e) {
			
		}
	}
/**
 * This is a constructor of this class, it add all the instance of abilities and entities into the list of this class.
 * So that its easy to get one of them and add it to the player list.
 */
	public FileControl() {
		enlist.addentity(axe);
		enlist.addentity(ct);
		enlist.addentity(cc);
		enlist.addentity(crowbar);
		enlist.addentity(ds);
		enlist.addentity(gs);
		enlist.addentity(hammer);
		enlist.addentity(is);
		enlist.addentity(pan);
		enlist.addentity(pp);
		enlist.addentity(rb);
		enlist.addentity(ss);
		enlist.addentity(sword);
		enlist.addentity(ws);
		ablist.addAbility(awh);
		ablist.addAbility(bh);
		ablist.addAbility(hi);
		ablist.addAbility(ls);
		ablist.addAbility(twoway);
		ablist.addAbility(smash);
		ablist.addAbility(reversal);
		ablist.addAbility(tackle);
	}
}
