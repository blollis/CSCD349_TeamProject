import java.util.*;

public class PreciseHit implements Attack
{
      private String attackName;
   
      public PreciseHit() 
      {
         attackName = "Precise Hit";
      }
   
      public String getName()
      {
         return attackName;
      }
      
      public void useAttack(Character attacker, Character defender) 
      {
         Random randomGenerator = new Random();

         //Skips the chance to hit so there is 100% chance to hit

  			//randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(attacker.getDamageMax() - attacker.getDamageMin())+ 1;
        
         //take HP from monster
 			defender.setHP(defender.getHP() - damageAmountTemp);
  			System.out.println("This attack never misses! " + attacker.getName() + " hit for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
            
  		}   
               
}