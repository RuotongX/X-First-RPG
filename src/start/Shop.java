package start;
import Ability.*;
import Entity.*;
/**
 * This class is used to add all the entity which can be bought by player to the shop list by initializing all those entities or abilities
 * and the shop entity list and shop ability list.
 * This class also sets the position of the shop.
 * @author RuotongXu QiChangZhou
 *
 */
public class Shop {
	private EntityList enlist = new EntityList();
	private AbilityList ablist = new AbilityList();
	private int row;
	private int column;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public EntityList getEnlist() {
		return enlist;
	}
	public AbilityList getAblist() {
		return ablist;
	}
	public Shop() {
		Axe axe = new Axe();
		ChickenThigth ct = new ChickenThigth();
		ChocolateCake cc = new ChocolateCake();
		Crowbar crowbar = new Crowbar();
		DimondShield ds = new DimondShield();
		GoldenShield gs = new GoldenShield();
		Hammer hammer = new Hammer();
		IronShield is = new IronShield();
		Pan pan = new Pan();
		PpDrink pp = new PpDrink();
		RoastBeef rb = new RoastBeef();
		SilveryShield ss = new SilveryShield();
		Sword sword = new Sword();
		WoodenShield ws = new WoodenShield();
		AttackWithHard awh = new AttackWithHard();
		BecomeHuge bh = new BecomeHuge();
		HugeImpact hi = new HugeImpact();
		LeechSeed ls = new LeechSeed();
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
