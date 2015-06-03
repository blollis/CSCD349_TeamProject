import java.util.*;

public class FireBall implements Attack
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
      
   		if (hitChanceTemp < attacker.getHitChance()) 
         {
   			//randomly generate amount of damage to be done within damage range
            int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax() * 2) - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
            //take HP from monster
   			defender.setHP(defender.getHP() - damageAmountTemp);
   			System.out.println(attacker.getName() + " cast a fire ball dealing " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
            
   		}//close hitChance if
         
         //else your attack fails
   		else 
         {
   			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
   		}//else else
      }
   
               
}