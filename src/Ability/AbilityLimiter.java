package Ability;
import start.*;
import java.util.Scanner;
/**
 * This class is used to avoid the ability amount of player hold, it also help user get the same ability many times when level up.
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
/**
 * This method is used to control the player ability amount maximum equal to 4.
 * Once player got a new ability, which is the fifth ability in player's list,
 * player types the name of the ability and the for loop will search the ability and remove it from arraylist.
 * Player can also keep the ability in this level by type 'e'.
 * If player types the wrong name it will ask player to type again.
 * @param al
 */
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
/**
 * This method to avoid player have 2 same ability by return a boolean value, using the for loop to search the player ability list, 
 * when find the same ability return true to avoid player get it again.
 * @param p
 * @param a
 * @return
 */
	public boolean AvoidDupulicate(Player p,Ability a) {
		for(Ability a2:p.ablist.getAbilitylist()) {
			if(a2.getName().equals(a.getName())) {
				return true;
			}
		}
		return false;
	}
}
