public abstract class Character {
   protected String name;
	protected int HP;
	protected int damageMin;
	protected int damageMax;
	protected double hitChance;

	public Character() {
		//DVC
		name = "";
		HP = 0;
		damageMin = 0;
		damageMax = 0;
		hitChance = 0D;
 
	}//close DungeonCharacter

	public void setName(String nameInput) {
		name = nameInput;
	}//close setName

	public String getName() {
		return name;
	}//close getName

	public void setHP(int HPInput) {
		if (HPInput < 0) {
			HP = 0;
		}
		else {
			HP = HPInput;
		}   
	}//close setHP    

	public int getHP() {
		return HP;
	}//close getHP

	public void setDamageMin(int damageMinInput) {
		damageMin = damageMinInput;
	}//close setdamageMin    

	public int getDamageMin() {
		return damageMin;
	}//close getdamageMin

	public void setDamageMax(int damageMaxInput) {
		damageMax = damageMaxInput;
	}//close setdamageMax    

	public int getDamageMax() {
		return damageMax;
	}//close getdamageMax

	public void setHitChance(double hitChanceInput) {
		hitChance = hitChanceInput;
	}//close sethitChance    

	public double getHitChance() {
		return hitChance;
	}//close gethitChance
   
   public boolean checkForLife() {
      if (HP > 0) {
         return true;
      }
      return false;
   }      
	
}