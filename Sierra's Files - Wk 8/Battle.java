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
      
      boolean fled = false;
      
      //while loop to carry out battle
   	while (checkPartiesAlive() && fled == false) 
      {
         int currGoodPos = goodGuys.getTurnPos();
         int currBadPos = badGuys.getTurnPos();
         
         Character currentGoodGuy = goodGuys.getMember(currGoodPos);
         Character currentBadGuy = badGuys.getMember(currBadPos);
         
         GoodGuyTurn turnGoodGuy = new GoodGuyTurn();
         BadGuyTurn turnBadGuy = new BadGuyTurn();
         
         //if currentGoodGuy is faster, then he goes first
         if (currentGoodGuy.getSpeed() >= currentBadGuy.getSpeed()) 
         {
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
      
      //print results
      printResult();
                  
      return fled;

   }//close fight
      
   public boolean checkPartiesAlive() 
   {
      return goodGuys.size() > 0 && badGuys.size() > 0;  
   }
   
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