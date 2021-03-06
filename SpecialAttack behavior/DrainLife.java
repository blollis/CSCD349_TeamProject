import java.util.*;

public class DrainLife implements Attack
{
      private String attackName;
   
      public DefaultAttack() 
      {
         attackName = "Drain Life";
      }
   
      public String getName()
      {
         return attackName;
      }
   
      public void useAttack(Character attacker, Character defender) 
      {
         BadGuy currentBadGuy = (BadGuy)defender;
         GoodGuy currentGoodGuy = (GoodGuy)attacker;
      
         Random randomGenerator = new Random();

   		//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
   		if (hitChanceTemp < attacker.hitChance) 
         {
   			//randomly generate amount of damage to be done within damage range
            int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
            //take HP from monster
   			currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
   			System.out.println("Attack was successful for " + damageAmountTemp + " points damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
   
            
            //Heals for the amount of damage dealt
            //set new HP for hero
				currentGoodGuy.setHP(currentGoodGuy.getHP() + damageAmountTemp);
   
				System.out.println(currentGoodGuy.getName() + " healed himself! He now has " + currentBadGuy.getHP() + " HP points.\n");
            
                           
   		}//close hitChance if
         
         //else your attack fails
   		else 
         {
   			System.out.println("Your attack was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
   		}//else else
     
      }//close useAttack()
   }//close specialAttack()   
}//Close class DrainLife