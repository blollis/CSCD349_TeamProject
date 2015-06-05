import java.util.*;
//BadGuyAttack
public class FireBreath implements Attack
{
   private String attackName;
   
   public FireBreath() 
   {
      attackName = "Fire Breath";
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
      
 		if (hitChanceTemp < attacker.getHitChance() - 0.2) 
      {  			
         //randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 20) + attacker.getDamageMin();
         
         //take HP from monster
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() + " blows a fiery breath! " + defender.getName() + " gets scorched for " + damageAmountTemp + " points of damage AND lose their eyebrows! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}   
