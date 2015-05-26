import java.util.*;

public abstract class GoodGuy extends Character 
{
   protected int XP = 0;
   protected Level level;
   protected Inventory inventory = new Inventory();

	public GoodGuy() 
   {
		super();
      
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
      return (this.name + " - Level " + this.getLevel() + ": " + this.getHP() + "HP");
   } 
   
   public String printStats() 
   {
      return (this.name + ": HP " + this.getHP() + ", Max Damage " + this.getDamageMax()  + ", Hit Chance " + this.getHitChance());  
   }
   
   abstract void addSecondSpecial();
	   
}//close GoodGuy