import java.util.*;
import java.util.Scanner;
public class Menu
{

	public static String getMapChoice()
	{
		String mapChoice = "EasyMap.txt";
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
      }while(choice <= 0 || choice > 3);  
		if(choice == 1)
			mapChoice = "EasyMap.txt";
			
		else if(choice == 2)
			mapChoice = "MediumMap.txt";
			
		else if(choice == 3)	
			mapChoice = "HardMap.txt";
			
		else
		 	mapChoice = "EasyMap.txt";	
			
		return mapChoice;
	} 

	public static int getMoveDirection()
	{
		int dir = 0;
		do{
         Scanner user_input = new Scanner( System.in );
         System.out.println("Pick your direction"); 
         System.out.println("1: Up");
         System.out.println("2: Down");
         System.out.println("3: Left");
			System.out.println("4: Right");
			System.out.println("0: Quit");
         try
         {
            dir = user_input.nextInt(); 
         }
         
         catch(InputMismatchException e)
         {
            System.out.println("Enter an int please!");
         }
      }while(dir < 0 || dir > 5);  
			
		return dir;
	}

}