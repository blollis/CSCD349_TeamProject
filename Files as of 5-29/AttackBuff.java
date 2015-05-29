import java.util.*;

public class AttackBuff implements Attack
{
   private String attackName;
   
   public AttackBuff() 
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
      
 		if (hitChanceTemp < attacker.getHitChance()) 
      {
         System.out.println("You body begins to illuminate!");
  			
         //randomly generate amount of damage to be done within increased damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax() / 4)) + 1) + attacker.getDamageMin();
         currentGoodGuy.setDamageMax(attacker.getDamageMax() + damageAmountTemp); 
         
         //take HP from monster
  		   currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() +"'s max attack increased! He attacked " + currentBadGuy.getName() + " for " + damageAmountTemp + " points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The buff was unsuccessful. " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
}//Close class BodySlam