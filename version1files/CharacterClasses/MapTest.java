import java.util.*;
import java.util.Scanner;
public class MapTest 
{

   public static void main(String args[]) 
   {	  
        boolean gameOver = false;  
		  String mapChoice = Menu.getMapChoice();
		  PlayerMap myMap = new PlayerMap(mapChoice);
        myMap.printMap(myMap);  
		  myMap.printPlayerMap(myMap);
        
        GoodGuy currentGoodGuy = new Elf();
        
		  Party myParty = new Party(1, 1); 
		  myParty.addMember(currentGoodGuy);
        
		  int direction; 
		  do{
		  		direction = Menu.getMoveDirection(); 
				boolean validMove = myParty.testMovePlayer(direction, myMap);
				if(validMove); 
					myMap.updateMapForPlayerLocation(myParty.getXCoord(), myParty.getYCoord());
               gameOver = myParty.getGameState(); 
					myMap.printPlayerMap(myMap);
				}while(direction != 0 && gameOver == false); 
            
            System.out.println("You reached the exit! Game Over!!"); 
   }//end main

}//end class