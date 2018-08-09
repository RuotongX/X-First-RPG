package start;
import java.util.ArrayList;
/**
 * This class maintains a list of film objects with functionality to add and
 * remove entities from the list.
 * @author RuotongXu QiChangZhou
 *
 */
public class EntityList {
	private ArrayList<Entity> entityItems;
	public EntityList() {
		this.entityItems = new ArrayList<Entity>();
	}
	public void addentity(Entity aentity) {
		this.entityItems.add(aentity);
	}
	public void removeentityItems(int index) {
		this.entityItems.remove(index);
	}
/**
 * This method is used to get the film array by rewrite the array list into a normal array.
 * @return
 */
	public Entity[] getentityList() {
		Entity[] array = new Entity[this.entityItems.size()];
		for(int i =0; i<array.length;i++) {
			array[i] = this.entityItems.get(i);
		}
		return array;
	}
	public int getTotalnumber() {
		return this.entityItems.size();
	}
	public boolean hasEntity(Entity aentity) {
		return this.entityItems.contains(aentity);
	}
	public void clear() {
		this.entityItems.clear();
	}
}
