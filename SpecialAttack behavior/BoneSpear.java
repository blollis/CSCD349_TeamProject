import java.util.*;

public class BoneSpear implements Attack
{
   private String attackName;
   
   public DefaultAttack() 
   {
      attackName = "Bone Spear";
   }
   
   public String getName()
   {
      return attackName;
   }
   
   public void useAttack(Character attacker, Character defender) 
   {
           
   }//close useAttack()
   
   private void boneSpearAttack(Character attacker, BadGuy currentBadGuy, int i)
   {
      /*
      //randomly generate amount of damage to be done within damage range for one bite
      int damageAmountTemp = randomGenerator.nextInt(((attacker.damageMax / 3) - attacker.damageMin) + 1) + attacker.damageMin;
         
      //take HP from monster
  		currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  		System.out.println("Bite " + i + " hits for " + damageAmountTemp + " points of damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
      
      */
   }//close biteAttack()
   
}