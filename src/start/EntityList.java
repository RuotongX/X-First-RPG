package start;
import java.util.ArrayList;
/**
 * 
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
