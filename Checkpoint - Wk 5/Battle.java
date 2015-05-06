import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Battle
{
   protected Party goodGuys;
   protected Party badGuys;
   protected Random randomGenerator = new Random();
      
   public Battle(Party goodGuys)
   {
      this.goodGuys = goodGuys;
      this.badGuys = generateEnemies();
   }//close Battle EVC

   private Party generateEnemies()
	{
		int enemyCount = randomGenerator.nextInt(goodGuys.size());
      
      Party badGuys = new Party();
      
      for (int i = 0; i <= enemyCount; i++) {         
         badGuys.addMember(new Ogre());
      }
      
      return badGuys;
      
   }//close generateEnemies
   
   public boolean fight()
   {
   	System.out.println("\nYou've been challenged! Let the battle begin!\n");
      
      int currentGoodPos = 0;
      int currentBadPos = 0;

      //while loop to carry out battle
   	while (goodGuys.size() > 0 && badGuys.size() > 0) 
      {
         Character currentGoodGuy = goodGuys.getMember(currentGoodPos);
         Character currentBadGuy = badGuys.getMember(currentBadPos);
         
         if (currentGoodGuy.getSpeed() >= currentBadGuy.getSpeed()) 
         {
            
            int optionsChoice = optionsMenu(currentGoodGuy);
            
            if (optionsChoice == 2) 
            {
                        
               System.out.println("Current good guys: ");
               printStats(goodGuys);
               
               System.out.println("Current bad guys: ");
               printStats(badGuys);

            }
            else if (optionsChoice == 1)
            {
               int choice = chooseAttack(currentGoodGuy);
            
               //choose badguy to attack
               int badGuyUnderAttackPos = chooseBadGuyToAttack();
               
               Character badGuyUnderAttack = badGuys.getMember(badGuyUnderAttackPos);     
         
               //carry out chosen attack              
               currentGoodGuy.attack(badGuyUnderAttack, choice);
               
               if (badGuyUnderAttack.checkForLife() == false) 
               {
                  System.out.println("You defeated " + badGuyUnderAttack.getName() + "!");
                  
                  badGuys.removeMember(badGuyUnderAttackPos);
                  
                  if (currentBadPos == badGuyUnderAttackPos) {
                     currentBadPos++;
                  }
               }  
            
               //advance turn order
               currentGoodPos++;
            }   
            else 
            {
               return false;
            }    
                              
         }    
     
         //if current character in turn order is a bad guy 
         else 
         {
            //randomly choose which attack monster will do
            int choice = randomGenerator.nextInt(3);
            
            //choose goodguy to attack
            int goodGuyUnderAttackPos = randomGenerator.nextInt(goodGuys.size());
         
            Character goodGuyUnderAttack = goodGuys.getMember(goodGuyUnderAttackPos); 
      
            //carry out chosen attack
      		currentBadGuy.attack(goodGuyUnderAttack, choice);
         
            if (goodGuyUnderAttack.checkForLife() == false) 
            {
               System.out.println(currentBadGuy.getName() + " defeated " + goodGuyUnderAttack.getName() + "!");
               
               goodGuys.removeMember(goodGuyUnderAttackPos);
               
               if (currentGoodPos == goodGuyUnderAttackPos) {
                     currentGoodPos++;
                  }
            }   
            
            //advance turn order
            currentBadPos++;
 
         }//close else
         
         //move turn order pointers back if they're at the end of the party
         if (currentGoodPos >= goodGuys.size()) {
            currentGoodPos = 0;
         } 
         
         if (currentBadPos >= badGuys.size()) {
            currentBadPos = 0;
         }     
            
      }//while party alive
      
      if (badGuys.size() <= 0)
      {
         System.out.println("You defeated all the enemies! Well done!\n");
      }
      else 
      { 
         System.out.println("You were defeated in battle. Better luck next time!\n"); 
      }   
      
      return true;

   }//close fight
   
   private int optionsMenu(Character currentGoodGuy)
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

   
   private int chooseAttack(Character currentGoodGuy)
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
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an attack.");
         }//close try-catch
      }
      while (currentGoodGuy.validAttackChoice(choice) == false); 
      
      return choice;

   }//close chooseAttack
   
   private int chooseBadGuyToAttack () 
   {
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         System.out.println("Who would you like to attack? ");
         printStats(badGuys);
               
         try 
         {
   		  choice = kb.nextInt();
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list of bad guys.");
         }//close try-catch
      }
      while (choice < 1 || choice > badGuys.size());
      
      return choice - 1;
      
   }//close chooseBadGuyToAttack
   
   private void printStats(Party inputParty)
   {
      Character currCharacter;
      
      for (int i = 0; i < inputParty.size(); i++)
      {
         currCharacter = inputParty.getMember(i);
         
         System.out.println((i + 1) + ". " + currCharacter.getName() + ": " + currCharacter.getHP() + "HP");
      }
      
      System.out.println("");
      
   }//close printStats
   
} //End of Battle Class