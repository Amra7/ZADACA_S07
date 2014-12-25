package OdbranaSela;

public class Character {
 
	protected int strength;
	protected int armor;
	protected int hp; //healt ponits
	
	public Character( int strength, int armor, int hp){
		this.strength=strength;
		this.armor=armor;
		this.hp=hp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Character [strength=" + strength + ", armor=" + armor + ", hp="
				+ hp + "]";
	}
	
	
}
