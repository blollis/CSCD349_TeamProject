import java.util.*;

public class DoubleAttack implements Attack
{
      private String attackName;
   
      public DoubleAttack() 
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
         Random randomGenerator = new Random();

   		//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
   		if (hitChanceTemp < attacker.hitChance) 
         {
            int i = 0;
            while(i < 2 && defender.checkForLife)
            {
               doubleStrike(attacker, defender, i);
               i++;
            }
            
   			//if statement to find out if monster is dead
   			if (defender.checkForLife()) 
            {
   				//randomly generate healChanceTemp determines if monster will heal
               double healChanceTemp = randomGenerator.nextDouble();
   
   				if (healChanceTemp < defender.getChanceToHeal()) 
               {
   					//randomly generate amount to be healed within heal range
                  int healAmountTemp = randomGenerator.nextInt((defender.getHealMax() - defender.getHealMin()) + 1) + defender.getHealMin();
                  
                  //set new HP for monster
   					defender.setHP(defender.getHP() + healAmountTemp);
   
   					System.out.println(defender.getName() + " healed himself! He now has " + defender.getHP() + " HP points.\n");
   
   				}//close temp <chanceToHeal
               
               //else healing fails
   				else 
               {
   					System.out.println(defender.getName() + " attempted to heal himself but failed. He still has " + defender.getHP() + " HP points.\n");
   				}//close else
               
   			}//close defender healing attempt
            
   		}//close hitChance if
         
         //else your attack fails
   		else 
         {
   			System.out.println("Your attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
   		}//else else
      }
   
      private void doubleStrike(Character attacker, Character defender, int i)
      {
         //randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
         //take HP from monster
   	   defender.setHP(defender.getHP() - damageAmountTemp);
   		System.out.println("Attack " + i + " was successful for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.");
      } 

}