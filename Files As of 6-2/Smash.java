import java.util.*;
//BadGuyAttack
public class Smash implements Attack
{
   private String attackName;
   
   public Smash() 
   {
      attackName = "Smash";
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
         //randomly generate amount of damage to be done within damage range 
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 20) + attacker.getDamageMin();
         
         //take HP 
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() + " smashes with his humong fists for " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}
