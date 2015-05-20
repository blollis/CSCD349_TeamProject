public class Heal implements SpecialAttack
{
   public void specialAttack(Character attacker, Character defender)
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