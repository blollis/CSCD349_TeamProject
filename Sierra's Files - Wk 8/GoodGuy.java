import java.util.*;

public abstract class GoodGuy extends Character 
{
	protected String specialAttack;
   protected Attacks attacksInventory;
   protected int expPts = 0;
   protected Inventory inventory;

	public GoodGuy() 
   {
		super();
      Attack defaultAttack = new DefaultAttack();
            
	}//close GoodGuy

   public void attack(Character incomingCharacter, int choiceInput) 
   {
	   Attack attackToExecute = attacksInventory.getAttack(choiceInput);
      
      attackToExecute.useAttack(this, incomingCharacter);

 	}//close attack 

	   
}//close GoodGuy