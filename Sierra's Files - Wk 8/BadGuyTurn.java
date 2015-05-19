import java.util.*;

public class BadGuyTurn extends BattleTurn 
{
   protected Random randomGenerator = new Random();

   public int chooseAttack(Character currentAttacker)
   {
      return randomGenerator.nextInt(3);
   }
   
   public int chooseOpponent(Party defenders)
   {
      return randomGenerator.nextInt(defenders.size());
 
   }
   
   public void checkDefenderLife(Party defenders, Character currentDefender, int currentDefendersPos)
   {

      if (currentDefender.checkForLife() == false) 
      {
         System.out.println(currentDefender.getName() + " was defeated!");
   
         defenders.removeMember(currentDefendersPos);
                           
      }  
  

   }   
}