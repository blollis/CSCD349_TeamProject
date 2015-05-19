import java.util.*;

public class GoodGuyTurn extends BattleTurn 
{
   public int chooseAttack(Character currentAttacker)
   {
      //allow user to choose an attack
      System.out.println("Choose an attack:\t1. Regular Attack ");      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         try 
         {
   		  choice = kb.nextInt();
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
         System.out.println("Who would you like to attack? ");
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
   
   public void checkDefenderLife(Party defenders, Character currentDefender, int currentDefendersPos)
   {
      if (currentDefender.checkForLife() == false) 
      {
         System.out.println("You defeated " + currentDefender.getName() + "!");
   
         defenders.removeMember(currentDefendersPos);  
                           
      }  
   }  
   
   public int optionsMenu(Character currentGoodGuy)
   {
      //allow user to choose an option
      System.out.println(currentGoodGuy.getName() + " is up. What would you like to do?");
      System.out.println("1. Attack \t 2. Print Stats \t 3. Flee");      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      while (choice < 1 || choice > 3)
      {
         try 
         {
   		  choice = kb.nextInt();
           
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }//close try-catch
         
         if (choice < 1 || choice > 3) {
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }   
            
      }
      
      return choice;

   }//close optionsMenu 
}