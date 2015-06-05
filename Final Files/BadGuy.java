public abstract class BadGuy extends Character 
{
	private double chanceToHeal;
	private int healMin;
	private int healMax;
   //used to determine amount of XP goodGuy can get when they kill this badGuy
   private int droppedXP;

	protected BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP) 
   {
		super(name, HPMax, damageMin, damageMax, hitChance, speed);
      
      this.chanceToHeal = chanceToHeal;
 		this.healMin = healMin;
		this.healMax = healMax;
      this.droppedXP = droppedXP;
      
   }//close BadGuy

	public void setHealMin(int healMinInput) 
   {
		healMin = healMinInput;
	}//close sethealMin    

	public int getHealMin() 
   {
		return healMin;
	}//close gethealMin

	public void setHealMax(int healMaxInput) 
   {
		healMax = healMaxInput;
	}//close sethealMax    

	public int getHealMax() 
   {
		return healMax;
	}//close gethealMax

	public void setChanceToHeal(double chanceToHealInput) 
   {
		chanceToHeal = chanceToHealInput;
	}//close setchanceToHeal    

	public double getChanceToHeal() 
   {
		return chanceToHeal;
	}//close getchanceToHeal

	public int  getDroppedXP() 
   {
		return droppedXP;
	}//close getDroppedXP
   
}//close BadGuy