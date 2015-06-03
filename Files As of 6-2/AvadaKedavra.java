import java.util.*;

public class AvadaKedavra implements Attack
{
   private String attackName;

   public AvadaKedavra() 
   {
      attackName = "Avada Kedavra";
   }

   public String getName()
   {
      return attackName;
   }
      
   public void useAttack(Character attacker, Character defender) 
   {
      Random randomGenerator = new Random();

		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble() - 0.5;
   
		if (hitChanceTemp < attacker.getHitChance()) 
      {
			//take HP from monster
			defender.setHP(0);
			System.out.println(attacker.getName() + " hit the enemy with the Avada Kedavra course " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
         
		}//close hitChance if
      
      //else your attack fails
		else 
      {
			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
		}//else else     
   }   
}