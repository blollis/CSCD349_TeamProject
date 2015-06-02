import java.util.*;

public class BadGuyTurn extends BattleTurn 
{
   protected Random randomGenerator = new Random();
   
   //randomly chooses an attack from the badGuy's attacksInventory
   public int chooseAttack(Character currentAttacker)
   {
      int choice;
      
      do 
      {
         choice = randomGenerator.nextInt(currentAttacker.attacksInventory.size());
         
      }
      while (currentAttacker.validAttackChoice(choice) == false); 
      
      return choice;
      
   }
   
   //chooses an opponent randomly from the goodGuys party
   public int chooseOpponent(Party defenders)
   {
      return randomGenerator.nextInt(defenders.size());
 
   }
   
   //checks whether the person that was just attacked is still alive
   public void checkDefenderLife(Character currentAttacker, Party defenders, Character currentDefender, int currentDefendersPos)
   {

      if (currentDefender.checkForLife() == false) 
      {
         System.out.println(currentDefender.getName() + " was defeated!\n");
         
         //removes the person who was just attacked from the party if they are dead
         defenders.removeMember(currentDefendersPos);
                           
      }  
  

   }   
}