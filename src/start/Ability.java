package start;

public abstract class Ability {
	private int pp;
	private double strength;
	private String description;
	private double attackboost;
	private double defenceboost;
	private double healupbyp;
	private double healupbyv;
	private double percentagehit;
	private int maxpp;
	
	public int getMaxpp() {
		return maxpp;
	}
	public void setMaxpp(int maxpp) {
		this.maxpp = maxpp;
	}
	public double getPercentagehit() {
		return percentagehit;
	}
	public void setPercentagehit(double percentagehit) {
		this.percentagehit = percentagehit;
	}
	public double getHealupbyp() {
		return healupbyp;
	}
	public void setHealupbyp(double healupbyp) {
		this.healupbyp = healupbyp;
	}
	public double getHealupbyv() {
		return healupbyv;
	}
	public void setHealupbyv(double healupbyv) {
		this.healupbyv = healupbyv;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public double getStrength() {
		return strength;
	}
	public void setStrength(double strength) {
		this.strength = strength;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAttackboost() {
		return attackboost;
	}
	public void setAttackboost(double attackboost) {
		this.attackboost = attackboost;
	}
	public double getDefenceboost() {
		return defenceboost;
	}
	public void setDefenceboost(double defenceboost) {
		this.defenceboost = defenceboost;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private boolean block;
	private String name;
	public Ability(String name) {
		this.name = name;
	}
}
