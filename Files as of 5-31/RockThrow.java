import java.util.*;
//BadGuyAttack
public class RockThrow implements Attack
{
   private String attackName;
   
   public RockThrow() 
   {
      attackName = "Rock Throw";
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
         System.out.println("The Ogre picks up a big ol' rock and throws it at the hero! What a prick!");
  			
         //randomly generate amount of damage to be done within damage range for one bat
          int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin();         
         //take HP from monster
  		   currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
  		   System.out.println("The rock hits your face for " + damageAmountTemp + " points of damage! " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}  
