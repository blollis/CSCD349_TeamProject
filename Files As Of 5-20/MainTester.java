import java.util.*;
import java.util.Scanner;

public class MainTester 
{

   public static void main(String args[]) 
   {	    
        //start game, initialize and print map      
        CurrentMap map = new CurrentMap();
        
        boolean gameOver = false;  
        
        //create good guys party
        Party goodGuys = new Party();
        
        //allow user to choose their party
        for (int i = 0; i <= 3; i++) {         
            Scanner kb = new Scanner(System.in);
            
            int choice = 99;
            
            do 
            {
               System.out.println("Choose a member for your party: ");
               System.out.println("1. Archer");
               System.out.println("2. Wizard");
               System.out.println("3. Elf");
               System.out.println("4. Warrior");
               System.out.println("5. Druid");
               System.out.println("6. Paladin");
               System.out.println("7. Cleric");
               System.out.println("8. Necromancer");
                     
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
        
        System.out.println("You have chosen the following party. Let's get started!");
        goodGuys.printStats();
        
        map.printCurrentMap();
        
        //allow good guys to start moving
		  String direction;
        
        int battleChance;
        int battleRoll;
        
        Random randomGenerator = new Random();
        
		  do{
		  		direction = map.getMoveDirection(); 
				
            if (direction == "0") 
            {
               gameOver = true;
            }
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
               
			   } 
            
        } while(gameOver == false); 

            
   }//end main

}//end class