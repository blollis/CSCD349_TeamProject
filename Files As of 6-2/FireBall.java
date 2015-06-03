import java.util.*;

public class FireBall implements SpecialAttack
{
      private String attackName;
   
      public FireBall() 
      {
         attackName = "Fire Ball";
      }
   
      public String getName()
      {
         return attackName;
      }

      
      public void useAttack(Character attacker, Character defender) 
      {
         Random randomGenerator = new Random();

   		//randomly generated hitChance temp determines if attack will be a success
         double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
   		if (hitChanceTemp < attacker.hitChance) 
         {
   			//randomly generate amount of damage to be done within damage range
            int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax * 2) - attacker.damageMin) + 1) + attacker.damageMin;
         
            //take HP from monster
   			defender.setHP(defender.getHP() - damageAmountTemp);
   			System.out.println("You casted a fire ball dealing " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.");
            
   		}//close hitChance if
         
         //else your attack fails
   		else 
         {
   			System.out.println("Your attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
   		}//else else
      }
   
               
}