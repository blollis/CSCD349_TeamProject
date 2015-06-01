import java.util.*;

public class GoodGuyTurn extends BattleTurn 
{
   protected Random randomGenerator = new Random();
   
   public int chooseAttack(Character currentAttacker)
   {
      //allow user to choose an attack
      GoodGuy attacker = (GoodGuy)currentAttacker;
      
      System.out.println("Choose an attack: ");
      attacker.printAttacks();      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         try 
         {
   		  choice = kb.nextInt() - 1;
         } 
         catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an attack.");
         }//close try-catch
      }
      while (currentAttacker.validAttackChoice(choice) == false); 
      
      return choice;

   }
   
   public int chooseOpponent(Party defenders)
   {
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         System.out.println("Who would you like to attack?");
         defenders.printStats();
               
         try 
         {
   		  choice = kb.nextInt();
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list of bad guys.");
         }//close try-catch
      }
      while (choice < 1 || choice > defenders.size());
            
      return choice - 1;

   }
   
   public void checkDefenderLife(Character currentAttacker, Party defenders, Character currentDefender, int currentDefendersPos)
   {
      if (currentDefender.checkForLife() == false) 
      {
         System.out.println(currentAttacker.getName() + " defeated " + currentDefender.getName() + "!\n"); 
         
         //attacker gains XP if they killed the defender
         
         BadGuy defender = (BadGuy)currentDefender;
         
         int gainedXP = defender.getDroppedXP();
         
         GoodGuy attacker = (GoodGuy)currentAttacker;
          
         attacker.setXP(attacker.getXP() +gainedXP);
         
         attacker.updateLevel(attacker); 
         
         defenders.removeMember(currentDefendersPos);
         
         dropItem(attacker);
                           
      }  
   }  
   
   public int optionsMenu(Character currentGoodGuy)
   {
      //allow user to choose an option
      System.out.println(currentGoodGuy.getName() + " is up. What would you like to do?");
    
      System.out.println("1. Attack \t 2. Use Item \t 3. Print Stats \t 4. Flee");      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      while (choice < 1 || choice > 4)
      {
         try 
         {
   		  choice = kb.nextInt();
           
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }//close try-catch
         
         if (choice < 1 || choice > 4) {
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }   
            
      }
      
      return choice;

   }//close optionsMenu 
   
   public void dropItem(GoodGuy attacker) 
   {           
      //determines a party size for the enemies no larger than the goodGuys party
      int itemChance = randomGenerator.nextInt(100);
            
      //generates item and adds to inventory if over itemChance over 50%
      if (itemChance > 50) 
      {        
         Item item = ItemFactory.createItem(itemChance);
         
         attacker.addInventoryItem(item);
         
         System.out.println("Congratulations! " + attacker.getName() + " just found a " + item.getName() + " that was droppped by the slain enemy!\n");
      }
   }//close dropItem
   
   public void useItem(GoodGuy user) 
   {      
      int choice = chooseItem(user);
      
      Item item = user.getInventoryItem(choice);
      
      item.useItem(user);
      
   }
   
   private int chooseItem(GoodGuy user)
   {
      //allow user to choose an item
      
      System.out.println("Which item would you like to use? ");
      user.printInventory();      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         try 
         {
   		  choice = kb.nextInt() - 1;
         } 
         catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an item.");
         }//close try-catch
      }
      while (user.validInventoryChoice(choice) == false); 
      
      return choice;

   }

   
}