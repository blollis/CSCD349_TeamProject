import java.util.*;

public class DoubleAttack implements Attack
{
      private String attackName;
      private Random randomGenerator = new Random();
   
      public DoubleAttack() 
      {
         attackName = "Double Attack";
      }
   
      public String getName()
      {
         return attackName;
      }
      
      //perform useAttack two times;
      public void useAttack(Character attacker, Character defender) 
      {
   		//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
   		if (hitChanceTemp < attacker.getHitChance()) 
         {
            int i = 0;
            while(i < 2 && defender.checkForLife())
            {
               doubleStrike(attacker, defender, i);
               i++;
            }
                       
   		}//close hitChance if
         
         //else your attack fails
   		else 
         {
   			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
   		}//else else
      }
   
      private void doubleStrike(Character attacker, Character defender, int i)
      {
         //randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
         //take HP from monster
   	   defender.setHP(defender.getHP() - damageAmountTemp);
   		System.out.println(attacker.getName() + "'s attack " + i + " was successful for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
      } 

}