import java.util.*;

public class SummonWolf implements Attack
{
   private String attackName;

   public SummonWolf() 
   {
      attackName = "Summon Wolf";
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
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin() + 1;
         int wolfDamage = randomGenerator.nextInt(20) + 1;
         
         //take HP from monster
			defender.setHP(defender.getHP() - damageAmountTemp);
			System.out.println(attacker.getName() + " hit for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
         defender.setHP(defender.getHP() - wolfDamage);
			System.out.println("A wolf appears and charges! He bites " + defender.getName() + " for " + damageAmountTemp + " points damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
         

		}//close hitChance if
      
      //else your attack fails
		else 
      {
			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
		}//else else     
   }   
}