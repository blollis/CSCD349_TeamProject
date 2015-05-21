import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.util.Scanner;

public class MainTester 
{

   public static void main(String args[]) 
   {	      
        //create map    
        CurrentMap map = new CurrentMap();
        
        //set gameOver status
        boolean gameOver = false;  
        
        //create good guys party
        Party goodGuys = new Party();
        
        //choose party
        goodGuys = chooseParty(goodGuys);
        
        System.out.println("You have chosen the following party. Let's get started!");
        
        //print statsfor chosen party
        goodGuys.printStats();
        
        //print map for firs time
        map.printCurrentMap();
        
        //allow good guys to start moving
		  String direction;
        
        //these two variables control chance of encountering a battle after moving
        int battleChance;
        int battleRoll;
        
        Random randomGenerator = new Random();
        
		  do{
            //get direction from map class
		  		direction = map.getMoveDirection(); 
				
            //if player chose to quit, then gameOver becomes true
            if (direction == "0") 
            {
               gameOver = true;
            }
            //move direction that was input
            else 
            {    
               map.movePlayer(direction); 
               
               //determine chance for battle
               battleChance = randomGenerator.nextInt(100);
               
               battleRoll = randomGenerator.nextInt(100);
               
               if (battleChance >= battleRoll) {
                  Battle battle = new Battle(goodGuys);
                  
                  //player goes into battle, returns false if they flee
                  if (battle.fight() == true) {
                     
                     //moves player backward on map if they fled
                     String moveBack = map.getOppositeDirection(direction);
                     
                     map.movePlayer(moveBack);  
                     
                     System.out.println("You fled the battle and moved back one space."); 
                  }
               }   

               //check if all good guys are dead
               if (goodGuys.size() < 1) 
               {
                  gameOver = true;
               }
               
               //check if reached exit
               else if (map.reachedExit() == true) 
               {  
                  gameOver = map.reachedExit();
                  
                  System.out.println("You reached the end of the game!\n");
                  System.out.println("Congratulations!You win!");
                  
               }  
               
               else 
               {
                  //regenerate some health
                  System.out.println("You reached the end of this turn! Keep up the good work!\n");
                  goodGuys.regenerate();
                  
                  //if no battle then player just keeps going
					   map.printCurrentMap();
               } 
               
			   }//close else
        
        //continues until game is over   
        } while(gameOver == false);
            
   }//end main
   
   public static Party chooseParty(Party goodGuys) 
   {
     
     //allow user to choose their party
     for (int i = 0; i <= 3; i++) {         
         Scanner kb = new Scanner(System.in);
         
         int choice = 99;
         
         GoodGuy tempChar;
         
         do 
         {
            //print menu of character options with stats
            System.out.println("Choose a member for your party: ");
            tempChar = new Archer();
            System.out.println("1. " + tempChar.printStats());
            tempChar = new Wizard();
            System.out.println("2. " + tempChar.printStats());
            tempChar = new Elf();
            System.out.println("3. " + tempChar.printStats());
            tempChar = new Warrior();
            System.out.println("4. " + tempChar.printStats());
            tempChar = new Druid();
            System.out.println("5. " + tempChar.printStats());
            tempChar = new Paladin();
            System.out.println("6. " + tempChar.printStats());
            tempChar = new Cleric();
            System.out.println("7. " + tempChar.printStats());
            tempChar = new Necromancer();
            System.out.println("8. " + tempChar.printStats());

            //checks that the user input was valid      
            try 
            {
         	  choice = kb.nextInt();
            } catch (InputMismatchException e) 
            {
               kb.nextLine();
               
               System.out.println("\nPlease enter a number from the list of bad guys.");
            }//close try-catch
         }
         while (choice < 1 || choice > 8);
         
         //adds a member to party based on choice
         if (choice == 1) 
            goodGuys.addMember(new Archer());
            
         else if (choice == 2) 
            goodGuys.addMember(new Wizard());
            
         else if (choice == 3) 
            goodGuys.addMember(new Elf());
            
         else if (choice == 4) 
            goodGuys.addMember(new Warrior());   
         
         else if (choice == 5) 
            goodGuys.addMember(new Druid());
            
         else if (choice == 6) 
            goodGuys.addMember(new Paladin());
            
         else if (choice == 7) 
            goodGuys.addMember(new Cleric()); 
            
         else if (choice == 8) 
            goodGuys.addMember(new Necromancer());    
     }
     
     return goodGuys;

   }//close chooseParty
   
}//end MainTester class