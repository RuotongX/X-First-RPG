package start;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Ability.AttackWithHard;
import Ability.BecomeHuge;
import Ability.HugeImpact;
import Ability.LeechSeed;
import Ability.Reversal;
import Ability.Smash;
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
 * 
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
	public static void savefile(Player p) {
		try {
			
		   try(PrintWriter fileWriter = new PrintWriter(new File("playerdata/data.txt"))){
			   fileWriter.println(p.getName());
			   fileWriter.println(p.getAttack());
			   fileWriter.println(p.getDefence());
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
			   fileWriter.println(p.ablist.getTotalnumber());
			   for (Ability a : p.ablist.getAbilitylist()) {
				   fileWriter.println(a.getName());
				   fileWriter.println(a.getPp());
			   }
			   fileWriter.println(p.enlist.getTotalnumber());
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
	public static void loadfile(Player p) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File("playerdata/data.txt"));
		try {
			 String line = fileScan.nextLine();
			 p.setName(line);
			 int value = fileScan.nextInt();
			 p.setAttack(value);
			 value = fileScan.nextInt();
			 p.setDefence(value);
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
			 line = fileScan.nextLine();
			 for(Entity e : enlist.getentityList()) {
				 if(e.getName().equals(line)) {
					 p.setWeapon(e);
				 }
			 }
			line = fileScan.nextLine();
			for(Entity e : enlist.getentityList()) {
				 if(e.getName().equals(line)) {
					 p.setShield(e);
				 }
			 }
			value = fileScan.nextInt();
			for(int i = 0;i<value;i++) {
				line = fileScan.nextLine();
				value = fileScan.nextInt();
				for(Ability a:ablist.getAbilitylist()) {
					if(a.getName().equals(line)) {
						a.setPp(value);
						p.ablist.addAbility(a);
					}
				}
			}
			value = fileScan.nextInt();
			for(int i = 0;i<value;i++) {
				line = fileScan.nextLine();
				value = fileScan.nextInt();
				for(Entity e : enlist.getentityList()) {
					if(e.getName().equals(line)) {
						e.setNum(value);
						p.enlist.addentity(e);
					}
				}
			}
			 fileScan.close();
		} catch(Exception e) {
			
		}
	}
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
	}
}
