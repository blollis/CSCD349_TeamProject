import java.util.*;
import java.util.Scanner;
public class MapTest 
{

   public static void main(String args[]) 
   {
      int mapChoice = getMapChoice(); 
      String filePath = ""; 
      if(mapChoice == 1)
         filePath = "EasyMap.txt"; 
         
      else if(mapChoice == 2)
         filePath = "MediumMap.txt"; 
         
      else if(mapChoice == 3)
         filePath = "HardMap.txt"; 
         
         Map myMap = new PlayerMap(filePath);
         myMap.printMap(myMap); 
         System.out.println(); 
   }//end main

   private static int getMapChoice()
   {
      int choice = 0; 
      
      do{
         Scanner user_input = new Scanner( System.in );
         System.out.println("Pick your map"); 
         System.out.println("1: Easy");
         System.out.println("2: Medium");
         System.out.println("3: Hard");
         try
         {
            choice = user_input.nextInt(); 
         }
         
         catch(InputMismatchException e)
         {
            System.out.println("Enter an int please!");
         }
      }while(choice == 0 || choice < 0 || choice > 3);      
      
      return choice; 
      
   }//end getMapChoice

}//end class