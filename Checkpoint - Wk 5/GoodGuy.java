import java.util.*;

public abstract class GoodGuy extends Character 
{
	protected String specialAttack;
   protected ArrayList<Integer> attackChoices = new ArrayList<Integer>();

	public GoodGuy() 
   {
		super();
      specialAttack ="";
      attackChoices.add(0);
      attackChoices.add(1);
      
	}//close GoodGuy
   
   //will be overwritten by individual goodguys
	public abstract void specialAttack(BadGuy currentBadGuy);

	public void attack(Character incomingCharacter, int choiceInput) 
   {
	   BadGuy currentBadGuy = (BadGuy)incomingCharacter;
      
      Random randomGenerator = new Random();
      
      //choice is passed in from the driver
		int choice = choiceInput;
      
      //if statement based on user's choice determines attack to be used
		if (choice == 1) 
      {
			//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble();
         
			if (hitChanceTemp < hitChance) 
         {
				//randomly generate amount of damage to be done within damage range
            int damageAmountTemp = randomGenerator.nextInt((damageMax - damageMin) + 1) + damageMin;
            
            //take HP from monster
				currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
				System.out.println("Attack was successful for " + damageAmountTemp + " points damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
            
            //if statement to find out if monster is dead
				if (currentBadGuy.checkForLife()) 
            {
					//randomly generate healChanceTemp determines if monster will heal
               double healChanceTemp = randomGenerator.nextDouble();

					if (healChanceTemp < currentBadGuy.getChanceToHeal()) 
               {
						//randomly generate amount to be healed within heal range
                  int healAmountTemp = randomGenerator.nextInt((currentBadGuy.getHealMax() - currentBadGuy.getHealMin()) + 1) + currentBadGuy.getHealMin();
                  
                  //set new HP for monster
						currentBadGuy.setHP(currentBadGuy.getHP() + healAmountTemp);

						System.out.println(currentBadGuy.getName() + " healed himself! He now has " + currentBadGuy.getHP() + " HP points.\n");

					}//close temp <chanceToHeal
               
               //else healing fails
					else 
               {
						System.out.println(currentBadGuy.getName() + " attempted to heal himself but failed. He still has " + currentBadGuy.getHP() + " HP points.\n");
					}//close else
               
				}//close currentBadGuy healing attempt
            
			}//close hitChance if
         
         //else your attack fails
			else 
         {
				System.out.println("Your attack was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
			}//else else
		}//close choice = 1
      
      //else if user chose special attack
		else if (choice == 2) 
      {
			specialAttack(currentBadGuy);
		}//close else if
 	}//close attack 
   
}//close GoodGuy