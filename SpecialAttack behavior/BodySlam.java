import java.util.*;

public class BodySlam implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Body Smash";
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
      double hitChanceTemp = randomGenerator.nextDouble();
      
 		if (hitChanceTemp < attacker.hitChance) 
      {
         System.out.println("You charge at the opponent");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
         //take HP from monster
  		   currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  		   System.out.println("You tackle for " + damageAmountTemp + " points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("Your attack was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
}//Close class BodySlam