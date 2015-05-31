import java.util.*;
//BadGuyAttack
public class Smash implements Attack
{
   private String attackName;
   
   public Smash() 
   {
      attackName = "Smash";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {
      GoodGuy currentGoodGuy = (GoodGuy)defender;
      
      Random randomGenerator = new Random();

 		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble();
      
 		if (hitChanceTemp < attacker.getHitChance()) 
      {
         System.out.println("The Cyclops smashes the hero with its humongo fists!");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
         //take HP from monster
  		   currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
  		   System.out.println("The Cyclops smashes for " + damageAmountTemp + " points of damage! " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}
