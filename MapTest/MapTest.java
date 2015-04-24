import java.util.*;
import java.util.Scanner;
public class MapTest 
{

   public static void main(String args[]) 
   {	  
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
					
					myMap.printPlayerMap(myMap);
				}while(direction != 0);  
   }//end main

}//end class