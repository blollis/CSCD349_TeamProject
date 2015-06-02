import java.util.*;

public class Sacrifice implements Attack
{
   private String attackName;
   
   public Sacrifice() 
   {
      attackName = "Sacrifice";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {
      Random randomGenerator = new Random();

 		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble();
      
 		if (hitChanceTemp < attacker.getHitChance()) 
      {
         System.out.println(attacker.getName() + "'s body begins to illuminate!");
  			
         //Takes half of good guy's life.
         int damageAmountTemp = attacker.getHP() / 2;
         attacker.setHP(damageAmountTemp);
         
         //take HP from monster
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() + " sacrificed half their life to deal " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("Your attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
}//Close class BodySlam