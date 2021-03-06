import java.util.*;

public class DoubleAttack implements Attack
{
      private String attackName;
   
      public DefaultAttack() 
      {
         attackName = "Default Attack";
      }
   
      public String getName()
      {
         return attackName;
      }
      
      //perform useAttack two times;
      public void useAttack(Character attacker, Character defender) 
      {
         BadGuy currentBadGuy = (BadGuy)defender;
      
         Random randomGenerator = new Random();

   		//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
   		if (hitChanceTemp < attacker.hitChance) 
         {
            int i = 0;
            while(i < 2 && currentBadGuy.checkForLife)
            {
               doubleStrike(attacker, currentBadGuy, i);
               i++;
            }
            
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
      }
   
      private void doubleStrike(Character attacker, BadGuy defender, int i)
      {
         //randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
         //take HP from monster
   	   currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
   		System.out.println("Attack " + i + " was successful for " + damageAmountTemp + " points damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
      } 

}