import java.util.*;
//BadGuyAttack
public class BloodLust implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Blood Lust";
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
      
 		if (hitChanceTemp < attacker.hitChance) 
      {
         System.out.println("The Orc goes into a Blood Lust Frenzy! He is swinging like some kinda crazy swinging thing!");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax) - attacker.damageMin) + 1) + attacker.damageMin;
         
         //take HP from monster
  		   currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
  		   System.out.println("You are hit for " + damageAmountTemp + " points of damage! " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}  
   }//close useAttack()
      
}