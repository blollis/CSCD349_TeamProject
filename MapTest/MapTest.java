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
		  Player myPlayer = new Player(1, 1); 
		  
		  int direction; 
		  do{
		  		direction = Menu.getMoveDirection(); 
				boolean validMove = myPlayer.testMovePlayer(direction, myMap);
				if(validMove); 
					myMap.updateMapForPlayerLocation(myPlayer.getXCoord(), myPlayer.getYCoord());
               gameOver = myPlayer.getGameState(); 
					myMap.printPlayerMap(myMap);
				}while(direction != 0 && gameOver == false); 
            
            System.out.println("You reached the exit! Game Over!!"); 
   }//end main

}//end class