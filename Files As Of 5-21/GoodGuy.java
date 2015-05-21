import java.util.*;

public abstract class GoodGuy extends Character 
{
   protected int XP = 0;
   protected int level = 0;
   protected Inventory inventory = new Inventory();

	public GoodGuy() 
   {
		super();
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
            
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
      this.level = x;
   }
   
   public int getLevel() 
   {
      return this.level;
   } 
   
   public void updateLevel()
   {
      int tempLevel = 99;
      
      if (this.XP < 10)
      {
         tempLevel = 1;
      }
      else if (this.XP >= 10 && this.XP < 25)
      {
         tempLevel = 2;
      }
      else if (this.XP >= 25 && this.XP < 45)
      {
         tempLevel = 3;
      }
      else if (this.XP >= 45 && this.XP < 70)
      {
         tempLevel = 4;
      }
      else 
      {
         tempLevel = 5;
      }
      
      if (tempLevel != this.level) 
      {
         System.out.println("Congratulations! " + this.getName() + " leveled up to " + tempLevel + "!");
      }
      
      this.level = tempLevel;
   }
   
   public String charInfo() 
   {
      return (this.name + " - Level " + this.getLevel() + ": " + this.getHP() + "HP");
   } 
   
   public String printStats() 
   {
      return (this.name + ": HP " + this.getHP() + ", Max Damage " + this.getDamageMax()  + ", Hit Chance " + this.getHitChance());  
   }
	   
}//close GoodGuy