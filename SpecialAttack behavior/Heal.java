import java.util.*;

public class Heal implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Heal";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender)
   {
      double healChanceTemp = randomGenerator.nextDouble();

		if (healChanceTemp < attacker.getHitChance()) 
      {
		   //randomly generate amount to be healed within 5 min and 25 max
         int healAmountTemp = randomGenerator.nextInt(20) + 5;
         
         attacker.setHP(attacker.getHP() + healAmountTemp);
         System.out.println("You successfully healed for " + healAmountTemp + ".");
      }
   }   
}