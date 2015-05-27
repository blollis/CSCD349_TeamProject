import java.util.*;

public class AttackBuff implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Attack Buff";
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
      double hitChanceTemp = randomGenerator.nextDouble();
      
 		if (hitChanceTemp < attacker.hitChance) 
      {
         System.out.println("You body begins to illuminate!");
  			
         //Takes half of good guy's life.
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax / 4)) + 1) + attacker.damageMin;
         currentGoodGuy.setDamgaeMax(attacker.damageMax + damgaeAmountTemp);
         
         //take HP from monster
  		   currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  		   System.out.println("You max attack increased and you dealt " + damageAmountTemp + " points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The buff was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
}//Close class BodySlam