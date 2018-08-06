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

public class FileControl {
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
			   fileWriter.println(p.getWeapon());
			   fileWriter.println(p.getShield());
			   for (Ability a : p.ablist.getAbilitylist()) {
				   fileWriter.println(a.getName());
				   fileWriter.println(a.getPp());
			   }
			   fileWriter.println("--SEPERATOR--");
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
			 String line;
			 
		} catch(Exception e) {
			
		}
	}
}
