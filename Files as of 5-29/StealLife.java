import java.util.*;

public class StealLife implements Attack
{
   private String attackName;

   public StealLife() 
   {
      attackName = "Steal Life";
   }

   public String getName()
   {
      return attackName;
   }

   public void useAttack(Character attacker, Character defender) 
   {
      Random randomGenerator = new Random();
   
      double healChanceTemp = randomGenerator.nextDouble();

		if (healChanceTemp < attacker.getHitChance()) 
      {
		   //randomly generate amount to be stolen for defender's HP
         int healAmountTemp = randomGenerator.nextInt(defender.getHP());
         
         attacker.setHP(attacker.getHP() + healAmountTemp);
         defender.setHP(defender.getHP() - healAmountTemp);
         
         System.out.println(attacker.getName() + " successfully stole " + healAmountTemp + " health points from " + defender.getName() + ".");
      }
  
   }//close useAttack()
   
}//Close class Steal Life