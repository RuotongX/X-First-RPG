package start;

import java.io.BufferedReader;
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
import java.io.File;

public class FileControl {
	public static void savemap(Player p) {
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
}
