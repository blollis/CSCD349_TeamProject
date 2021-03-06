import java.util.*;
//BadGuyAttack
public class BoneSpear implements Attack
{
   private String attackName;
   
   public BoneSpear() 
   {
      attackName = "Bone Spear";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {      
      Random randomGenerator = new Random();

 		//randomly generated hitChance temp determines if attack will be a success
      double hitChanceTemp = randomGenerator.nextDouble();
      
 		if (hitChanceTemp < attacker.getHitChance()) 
      {
         System.out.println(attacker.getName() + " throws a Bone Spear! It was his own leg wtf?!?!?!");
  			
         //randomly generate amount of damage to be done within damage range for one bat
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 10) + attacker.getDamageMin();
                    
         //take HP from monster
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println(attacker.getName() + " impales " + defender.getName() + " for " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");
                          
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println("The attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else

           
   }//close useAttack()   
}   
