import java.util.*;

public class PoisonAttack implements Attack
{
   private String attackName;
   
   public PoisonAttack() 
   {
      attackName = "Poison Attack";
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
      
 		if (hitChanceTemp < attacker.getHitChance()) 
      {
         System.out.println(attacker.getName() + " applied poison to their weapon.");
  			
         //randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(((attacker.getDamageMax()) - attacker.getDamageMin()) + 10) + attacker.getDamageMin();
         
         //take HP from monster
  		   defender.setHP(defender.getHP() - damageAmountTemp);
  		   System.out.println("Attack hit for " + damageAmountTemp + " points of damage! " + defender.getName() + " has " + defender.getHP() + " hit points remaining.");
         
         int j = randomGenerator.nextInt(attacker.getDamageMin()) + 1;
         
         for(int i = 1; i <= j; i++)
         {
            poisonDamage(defender);
         }
         
         System.out.println(defender.getName() + " is finally clear of the poison.\n");
                 
      }//close hitChance if
         
      //else your attack fails
  		else 
      {
  			System.out.println(attacker.getName() + "'s attack was unsuccessful. " + defender.getName() + " has " + defender.getHP() + " hit points remaining.\n");       
 		}//else else
     
   }//close useAttack()
   
   private void poisonDamage(Character defender)
   {
       defender.setHP(defender.getHP() - 1);
  		 System.out.println(defender.getName() + " is still suffering the effects of the poison! " +  defender.getName() + " lost one more hit point.");
          
   }//close poisonDamage()
   
}//Close class poisonAttack