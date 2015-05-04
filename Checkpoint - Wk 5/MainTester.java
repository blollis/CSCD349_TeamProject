import java.util.*;
import java.util.Scanner;
public class MainTester 
{

   public static void main(String args[]) 
   {	    
        //start game, initialize and print map      
        CurrentMap map = new CurrentMap();
        
        boolean gameOver = false;  
		  
        map.printCurrentMap();
        
        //create good guys party
        Party goodGuys = new Party();
        
        for (int i = 0; i <= 1; i++) {         
         goodGuys.addMember(new Elf());
         goodGuys.addMember(new Wizard());
        }
        
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
                  if (battle.fight() == false) {
                     String moveBack = map.getOppositeDirection(direction);
                     
                     map.movePlayer(moveBack);  
                     
                     System.out.println("You fled the battle and moved back one space."); 
                  }
               }   
 
               //if no battle then player just keeps going
					map.printCurrentMap();
               
               //check if all good guys are dead
               if (goodGuys.size() < 1) 
               {
                  gameOver = true;
               }
               
               //check if reached exit
               if (map.reachedExit() == true) 
               {   
                  gameOver = map.reachedExit();
                  
                  System.out.println("Congratulations!You beat the game!");
                  
               }   
               
			   } 
            
        } while(gameOver == false); 

            
   }//end main

}//end class