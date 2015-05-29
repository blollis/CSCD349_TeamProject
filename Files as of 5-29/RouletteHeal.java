import java.util.*;

public class RouletteHeal implements Attack
{
   private String attackName;
   
   public RouletteHeal() 
   {
      attackName = "Roulette Heal";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender)
   {
      Random randomGenerator = new Random();
      
      int roulette = randomGenerator.nextInt(100);

      //randomly generate amount to be stolen for defender's HP
      int healAmountTemp = randomGenerator.nextInt(20);
         
		if (roulette < 50) 
      {
         attacker.setHP(attacker.getHP() + healAmountTemp);
         
         System.out.println(attacker.getName() + " successfully healed for " + healAmountTemp + " health points!\n");
      }
      else 
      {
         defender.setHP(defender.getHP() + healAmountTemp);
         
         System.out.println(attacker.getName() + " messed up his spell and healed " + defender.getName() + " for " + healAmountTemp + " health points!\n");
      }
   }   
}