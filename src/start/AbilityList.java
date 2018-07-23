package start;
import java.util.ArrayList;

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
}
