package Ability;
import start.*;
import java.util.Scanner;
/**
 * 
 * @author RuotongXu QiChangZhou
 *
 */
public class AbilityLimiter {
	Scanner sc = new Scanner(System.in);
	private boolean keep = false;
	
	public boolean isKeep() {
		return keep;
	}

	public void setKeep(boolean keep) {
		this.keep = keep;
	}

	public AbilityLimiter(AbilityList al) {
		if(al.getTotalnumber() > 4) {
			System.out.println("You can only master 4 ability , please delete one of your ability");
			PlayerAbilityDisplay pad = new PlayerAbilityDisplay(al);
			System.out.println("Type the name of the ability, if you do not want to forget any ablility just type 'e'.");
			try {
			    String token = sc.nextLine().toLowerCase();
			    if(token.equals("e")) {
					this.setKeep(true);
				}
				else {
					for(int i = 0;i<al.getTotalnumber();i++) {
						if(al.getAbilitylist()[i].getName().toLowerCase().contains(token)) {
							al.removeAbility(i);
						}
					}
					if(al.getTotalnumber() > 4) {
						System.out.println("You do not have "+token+" Please type again.");
						return;
					}
				}
			}catch(Exception e) {
				
			}
		}
	}
	public boolean AvoidDupulicate(Player p,Ability a) {
		for(Ability a2:p.ablist.getAbilitylist()) {
			if(a2.getName().equals(a.getName())) {
				return true;
			}
		}
		return false;
	}
}
