import java.util.*;

public class DefaultAttack implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Default Attack";
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
         int damageAmountTemp = randomGenerator.nextInt((attacker.getDamageMax() - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
         //take HP from monster
			defender.setHP(defender.getHP() - damageAmountTemp);
			System.out.println(attacker.getName() + " successfully attacked " + defender.getName() + " for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
         
		}//close hitChance if
      
      //else your attack fails
		else 
      {
			System.out.println(attacker.getName() + " attempted to attack " + defender.getName() + ", but was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
		}//else else
   }

}