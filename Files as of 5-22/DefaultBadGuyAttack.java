import java.util.*;

public class DefaultBadGuyAttack implements Attack
{
   private String attackName;
   
   public DefaultBadGuyAttack() 
   {
      attackName = "Default Bad Guy Attack";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {
      GoodGuy currentGoodGuy = (GoodGuy)defender;
      
		Random randomGenerator = new Random();
      
      //randomly generates to determine if attack will succeed
		double hitChanceTemp = randomGenerator.nextDouble();

		if (hitChanceTemp < currentGoodGuy.getHitChance()) 
      {

			//randomly generates to determine if hero will block attack
         double blockChanceTemp = randomGenerator.nextDouble();

			//generates amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt((attacker.getDamageMax() - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
         //apply damage to hero
			currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
			System.out.println(attacker.getName() + " attacked you for " + damageAmountTemp + " points damage! You have " + currentGoodGuy.getHP() + " hit points remaining.\n");
		          
		}//close if hit chance
      
      //else attack did not succeed
		else 
      {
			System.out.println(attacker.getName() + " attempted to attack but was unsuccessful. You have " + currentGoodGuy.getHP() + " hit points remaining.\n");       
		}//close else
   }

}