import java.util.*;
//BadGuyAttack
public class FireBreath implements Attack
{
   private String attackName;
   
   public FireBreath() 
   {
      attackName = "Fire Breth";
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
         System.out.println("The dragon breathes fire on the hero! Its getting hot in here!");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 1) + attacker.getDamageMin();
         
         //take HP from monster
  		   currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
  		   System.out.println("You get scorched by dragon flames for " + damageAmountTemp + " points of damage AND you lose your eyebrows! " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + currentGoodGuy.getName() + " has " + currentGoodGuy.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}   
