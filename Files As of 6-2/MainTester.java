import java.util.*;

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
        GoodGuyFactory goodGuyFactory = new GoodGuyFactory();
        goodGuys = goodGuyFactory.chooseHeroes();
        
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
   
}//end MainTester class