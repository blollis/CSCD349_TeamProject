import java.util.Random;
import java.util.Scanner;

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

   //calls the badGuyFactory to generate a party of enemies to fight
   private Party generateEnemies()
	{            
      //determines a party size for the enemies no larger than the goodGuys party
      int enemyCount = randomGenerator.nextInt(goodGuys.size()) + 1;
      
      Party badGuys = new Party();
      
      //generates and adds enemies
      for (int i = 0; i < enemyCount; i++) {        
         int badGuyID = randomGenerator.nextInt(100);
         
         BadGuy bg = BadGuyFactory.createBadGuy(badGuyID);
         
         badGuys.addMember(bg);
      }
      
      System.out.println(); 
      
      return badGuys;
      
   }//close generateEnemies
   
   public boolean fight()
   {
   	System.out.println("You've been challenged! Let the battle begin!\n");
      
      //boolean changes if user flees the battle
      boolean fled = false;
      
      //while loop to carry out battle
   	while (checkPartiesAlive() && fled == false) 
      {
         //get current turn positions in each party
         int currGoodPos = goodGuys.getTurnPos();
         int currBadPos = badGuys.getTurnPos();
         
         //get current goodGuy and badGuy based on turn positions
         Character currentGoodGuy = goodGuys.getMember(currGoodPos);
         Character currentBadGuy = badGuys.getMember(currBadPos);
         
         //create a turn for each current character
         GoodGuyTurn turnGoodGuy = new GoodGuyTurn();
         BadGuyTurn turnBadGuy = new BadGuyTurn();
         
         //if currentGoodGuy is faster, then he goes first
         if (currentGoodGuy.getSpeed() >= currentBadGuy.getSpeed()) 
         {
            //executes the good guy's turn, changes the boolean if they flee
            fled = turnGoodGuy.executeTurn(goodGuys, badGuys); 
            
            //if both parties are still alive, then bad guy can attack
            if (checkPartiesAlive() && fled == false ) 
            {                
               turnBadGuy.executeTurn(badGuys, goodGuys);
            }
            //else battle is over because a party is dead or fled
            else {
               break;
            }   
                              
         }    
     
         //if currentBadGuy is faster, then he goes first 
         else 
         {                    
            turnBadGuy.executeTurn(badGuys, goodGuys);

            //if both parties are still alive, then good guy can attack
            if (checkPartiesAlive()) 
            {                   
               fled = turnGoodGuy.executeTurn(goodGuys, badGuys);
            }
            //else battle is over
            else {
               break;
            } 
            
         }//close else 

      }//while party alive
      
      //print results of battle
      printResult();
                  
      return fled;

   }//close fight
      
   //makes sure both parties still have living members
   public boolean checkPartiesAlive() 
   {
      return goodGuys.size() > 0 && badGuys.size() > 0;  
   }
   
   //prints results of the battle based on party sizes
   public void printResult() 
   {
      if (badGuys.size() <= 0)
      {
         System.out.println("You defeated all the enemies! Well done!\n");
      }
      if (goodGuys.size() <= 0) 
      { 
         System.out.println("You were defeated in battle. Better luck next time!\n"); 
      }   
   }
     
} //End of Battle Class