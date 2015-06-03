import java.util.*;

public class Bats implements Attack
{
   private String attackName;
   
   public Bats() 
   {
      attackName = "Summon Bats";
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
      
 		if (hitChanceTemp < attacker.hitChance) 
      {
         System.out.println("You summoned bats to attack!");
  			
         //Bat 1 thro 4 attacks
         for(int i = 1; i <= 4; i++)
         {
            batAttack(attacker, defender, i);
         }
               
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("Your attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
   private void batAttack(Character attacker, Character defender, int i)
   {
      //randomly generate amount of damage to be done within damage range for one bat
      int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax / 3) - attacker.damageMin) + 1) + attacker.damageMin;
         
      //take HP from monster
  		defender.setHP(defender.getHP() - damageAmountTemp);
  		System.out.println("Bat " + i + " hits for " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.");
   }//close batAttack()
   
}//Close class DrainLife