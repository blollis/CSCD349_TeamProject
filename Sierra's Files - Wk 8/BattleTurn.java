public abstract class BattleTurn 
{
   
   final boolean executeTurn(Party attackers, Party defenders) 
   {
      int attackersPos = attackers.getTurnPos();
      int defendersPos = defenders.getTurnPos();
      
      Character currentAttacker = attackers.getMember(attackersPos);
      
      int menuChoice = optionsMenu(currentAttacker);
      
      while (menuChoice == 2) 
      {
         System.out.println("Current good guys: ");
         attackers.printStats();
         
         System.out.println("Current bad guys: ");
         defenders.printStats();
         
         menuChoice = optionsMenu(currentAttacker);
      }   

      if (menuChoice == 3) 
      {
         return true;
      }   
      
      int choice = chooseAttack(currentAttacker);
      int currentDefendersPos = chooseOpponent(defenders);
      
      Character currentDefender = defenders.getMember(currentDefendersPos);
      
      executeAttack(currentAttacker, currentDefender, choice);
      checkDefenderLife(defenders, currentDefender, currentDefendersPos);
      advanceTurnOrder(attackers, defenders);  
            
      
      return false;
   }//close battleTurn
   
   public int optionsMenu(Character currentAttacker) {
      int x = 1;
      
      return x;
   }   
   
   abstract int chooseAttack(Character currentAttacker);
   abstract int chooseOpponent(Party defenders);
   
   public void executeAttack(Character currentAttacker, Character currentDefender, int choice) 
   {
      currentAttacker.attack(currentDefender, choice);

   }
   
   abstract void checkDefenderLife(Party defenders, Character currentDefender, int defendersPos); 
   
   public void advanceTurnOrder(Party attackers, Party defenders) 
   {
      attackers.incrementTurnPos();

      //if turn order of attackers reaches end of attackers, reset turn order to beginning
      if (attackers.getTurnPos() >= attackers.size()) {
         attackers.resetTurnPos();
      } 
      
      //check that defenders turnPos is still valid
      if (defenders.getTurnPos() >= defenders.size()) {
         defenders.resetTurnPos();
      } 

         
   }//close advanceTurnOrder

}