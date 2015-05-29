abstract class GoodGuy extends Character 
{
   private int XP;
   protected Level level;
   protected Inventory inventory;

	protected GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
   {
		super(name, HPMax, damageMin, damageMax, hitChance, speed);
      
      this.XP = 0;
      
      //initialize inventory
      inventory  = new Inventory();
      
      //set character level at creation time as zero
      this.level = new Level();
      
      this.level.setLevel(0);
            
	}//close GoodGuy
      
   public void setXP(int x) 
   {
      this.XP = x;
   }
   
   public int getXP() 
   {
      return this.XP;
   }
   
   public void setLevel(int x) 
   {
      this.level.setLevel(x);
   }
   
   public int getLevel() 
   {
      return this.level.getLevel();
   } 
   
   public void updateLevel(GoodGuy character)
   {
      this.level.updateLevel(character);
   }
      
   public String charInfo() 
   {
      return (getName() + " - Level " + getLevel() + ": " + this.getHP() + "HP");
   } 
   
   public String printStats() 
   {
      return (getName()+ ": HP " + getHP() + ", Max Damage " + getDamageMax() + ", Hit Chance " + getHitChance());  
   }
   
   abstract void addSecondSpecial();
	   
}//close GoodGuy