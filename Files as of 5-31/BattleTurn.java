public abstract class BattleTurn 
{

  final boolean executeTurn(Party attackers, Party defenders) {
      //gets position of both attacker and defender
      int attackersPos = attackers.getTurnPos();
      int defendersPos = defenders.getTurnPos();
      
      //gets currentAttacker (so we can pass this as a parameter)
      Character currentAttacker = attackers.getMember(attackersPos);
      
      //calls menu choice, which is overwritten in goodGuyTurn to display options, does nothing but return 1 for badGuyTurn
      int menuChoice = optionsMenu(currentAttacker);
      
      //prints stats menu if goodGuy chose this option
      while (menuChoice == 2) {
         System.out.println("Current good guys: ");
         attackers.printStats();
         
         System.out.println("Current bad guys: ");
         defenders.printStats();
         
         menuChoice = optionsMenu(currentAttacker);
      }  
       
      //flees if goodGuy chose this option
      if (menuChoice == 3) 
         return true;   
      
      //allows character to choose attack from attacksInventory
      int choice = chooseAttack(currentAttacker);
      
      //allows character to choose an opponent 
      int currentDefendersPos = chooseOpponent(defenders);
      
      //gets currentDefender (so we can pass this as a parameter)
      Character currentDefender = defenders.getMember(currentDefendersPos);
      
      //carries out attack and clean up steps
      executeAttack(currentAttacker, currentDefender, choice);
      checkDefenderLife(currentAttacker, defenders, currentDefender, currentDefendersPos);
      advanceTurnOrder(attackers, defenders);  
              
      return false;
   }//close battleTurn
   
   //hook that is overwritten in goodGuyTurn
   public int optionsMenu(Character currentAttacker) {
      int x = 1;
      
      System.out.println(currentAttacker.getName() + " is attacking!");
      
      return x;
   }   
   
   //both of these methods are overwritten in both goodGuy and badGuy turns
   abstract int chooseAttack(Character currentAttacker);
   abstract int chooseOpponent(Party defenders);
   
   //executes attack the same for either type of turn
   public void executeAttack(Character currentAttacker, Character currentDefender, int choice) 
   {
      currentAttacker.attack(currentDefender, choice);

   }
   
   //overwritten in both goodGuy and badGuy turns 
   abstract void checkDefenderLife(Character currentAttacker, Party defenders, Character currentDefender, int defendersPos); 
   
   //advances turn order for the party when a character's turn is completed
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

}//close BattleTurn