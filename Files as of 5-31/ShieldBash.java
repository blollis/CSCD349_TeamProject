import java.util.*;

public class ShieldBash implements Attack
{
   private String attackName;

   public ShieldBash() 
   {
      attackName = "Shield Bash";
   }

   public String getName()
   {
      return attackName;
   }
      
   public void useAttack(Character attacker, Character defender) 
   {
      Random randomGenerator = new Random();

		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble() - 0.2;
   
		if (hitChanceTemp < attacker.getHitChance()) 
      {
			//randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin() + 8;
      
         //take HP from monster
			defender.setHP(defender.getHP() - damageAmountTemp);
			System.out.println(attacker.getName() + " bashed the enemy with their shield for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
         
		}//close hitChance if
      
      //else your attack fails
		else 
      {
			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
		}//else else     
   }   
}