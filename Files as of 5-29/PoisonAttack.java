import java.util.*;

public class PoisonAttack implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Poison Attack";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {
      BadGuy currentBadGuy = (BadGuy)defender;
      
      Random randomGenerator = new Random();

 		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
      
 		if (hitChanceTemp < attacker.hitChance) 
      {
         System.out.println("You applied poison to your weapon");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
         //take HP from monster
  		   currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  		   System.out.println("Attack hit for " + damageAmountTemp + " points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
         
         for(int i = 0; i <= attack.damageMin; i++)
         {
            poisonDamage(attacker, currentBadGuy);
         }
         System.out.println(currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
                 
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("Your attack was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
   private void poisonDamage(Character attacker, BadGuy currentBadGuy)
   {
       currentBadGuy.setHP(currentBadGuy.getHP() - 1);
  		 System.out.println("Attack hit for 1 points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
          
   }//close poisonDamage()
   
}//Close class poisonAttack