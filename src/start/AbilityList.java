package start;
import java.util.ArrayList;
/**
 *  This class maintains a list of film objects with functionality to add and
 * remove abilities from the list.
 * @author RuotongXu QiChangZhou
 *
 */
public class AbilityList {
	private ArrayList<Ability> abilityi;
	public AbilityList() {
		this.abilityi = new ArrayList<Ability>();
	}
	public void addAbility(Ability aAbility) {
		this.abilityi.add(aAbility);
	}
	public void removeAbility(int index){
		this.abilityi.remove(index);
	}
/**
 * This method is used to get the film array by rewrite the array list into a normal array.
 * @return
 */
	public Ability[] getAbilitylist() {
		Ability[] array = new Ability[this.abilityi.size()];
		for(int i = 0;i<array.length;i++) {
			array[i] = this.abilityi.get(i);
		}
		return array;
	}
	public boolean hasAbility(Ability aAbility) {
		return this.abilityi.contains(aAbility);
	}
	public int getTotalnumber() {
		return this.abilityi.size();
	}
	public void clear() {
		this.abilityi.clear();
	}
}
