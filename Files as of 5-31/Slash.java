import java.util.*;
//BadGuyAttack
public class Slash implements Attack
{
   private String attackName;
   
   public Slash() 
   {
      attackName = "Slash";
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
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 8) + attacker.getDamageMin();         
         //take HP from monster
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() + " slashes " + defender.getName() + " with it's HandClawHoof for " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}       
