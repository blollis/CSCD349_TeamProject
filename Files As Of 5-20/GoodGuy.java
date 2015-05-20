import java.util.*;

public abstract class GoodGuy extends Character 
{
   protected Attacks attacksInventory = new Attacks();
   protected int XP = 0;
   protected int level = 0;
   protected Inventory inventory = new Inventory();

	public GoodGuy() 
   {
		super();
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
            
	}//close GoodGuy

   public void attack(Character incomingCharacter, int choiceInput) 
   {
	   Attack attackToExecute = attacksInventory.getAttack(choiceInput);
      
      attackToExecute.useAttack(this, incomingCharacter);

 	}//close attack 
   
   public void printAttacks() 
   {
      for(int i = 0; i < attacksInventory.size(); i++) 
      {
         System.out.println((i+1) + ". " + attacksInventory.getAttack(i).getName());
      }
   }

   public boolean validAttackChoice(int x) 
   {
      if (x >= 0 && x < attacksInventory.size()) {
         return true;
      }
      
      return false;
   }
   
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
	   
}//close GoodGuy